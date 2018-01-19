package security.bercy.com.week5weekendmutaualmobile.recipe;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import security.bercy.com.week5weekendmutaualmobile.data.RemoteDataSource;

import security.bercy.com.week5weekendmutaualmobile.model.HitsItem;
import security.bercy.com.week5weekendmutaualmobile.model.Response;
import security.bercy.com.week5weekendmutaualmobile.model.Recipe;

/**
 * Created by Bercy on 1/17/18.
 */

public class RecipePresenter implements RecipeContract.Presenter {

    RemoteDataSource remoteDataSource;
    RecipeContract.View view;

    List<Recipe> recipeList = new ArrayList<>();

    @Inject
    public RecipePresenter(RemoteDataSource remoteDataSource){
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void attachView(RecipeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getRecipes(int fromNum, String query) {

        String from = String.valueOf(fromNum);
        String to = String.valueOf(fromNum+30);
        Observer<Recipe> observer = new Observer<Recipe>() {


            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Recipe recipe) {
                Log.d("", "onNext: "+recipe);
                recipeList.add(recipe);
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onComplete() {
                view.updateRecipe(recipeList);
            }
        };

        remoteDataSource.getResponse(query,from,to).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<Response, Observable<Recipe>>() {
                    @Override
                    public Observable<Recipe> apply(final Response response) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<Recipe>() {
                            @Override
                            public void subscribe(ObservableEmitter<Recipe> e) throws Exception {
                                for (HitsItem hitsItem : response.getHits()) {
                                    e.onNext(hitsItem.getRecipe());
                                }
                                e.onComplete();
                            }
                        });
                    }
                })
                .subscribe(observer);



    }
}
