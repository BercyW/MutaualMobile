package security.bercy.com.week5weekendmutaualmobile.di.module;

import dagger.Module;
import dagger.Provides;
import security.bercy.com.week5weekendmutaualmobile.data.RemoteDataSource;
import security.bercy.com.week5weekendmutaualmobile.di.scope.ActivityScope;
import security.bercy.com.week5weekendmutaualmobile.recipe.RecipePresenter;

/**
 * Created by Bercy on 1/18/18.
 */

@Module
public class RecipeModule {


    @Provides
    @ActivityScope
    RecipePresenter provideRecipePresenter(RemoteDataSource remoteDataSource){
        return new RecipePresenter(remoteDataSource);
    }
}
