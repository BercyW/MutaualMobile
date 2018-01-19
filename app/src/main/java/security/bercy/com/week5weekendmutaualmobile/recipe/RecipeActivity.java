package security.bercy.com.week5weekendmutaualmobile.recipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import security.bercy.com.week5weekendmutaualmobile.R;
import security.bercy.com.week5weekendmutaualmobile.application.CustomApplication;
import security.bercy.com.week5weekendmutaualmobile.data.RemoteDataSource;
import security.bercy.com.week5weekendmutaualmobile.model.Recipe;

public class RecipeActivity extends AppCompatActivity implements RecipeContract.View,RecipeAdapter.RecipeListItemListener{
    @Inject
    RecipePresenter recipePresenter;
    private List<Recipe> recipeList = new ArrayList<>();
    private RecipeAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);


        //setup component
        setupComponent();
        recipePresenter.attachView(this);
        recyclerSetup();
        recipePresenter.getRecipes(0, "rice");
    }

    private void setupComponent() {
        Log.d("2222", "setupComponent: "+this);
        CustomApplication.get(this).getRecipeComponent().inject(this);
    }

    private void recyclerSetup() {

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);


        adapter = new RecipeAdapter(this, recipeList);


        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void updateRecipe(List<Recipe> list) {
        this.recipeList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onItemClicked(Recipe recipe) {

    }
}
