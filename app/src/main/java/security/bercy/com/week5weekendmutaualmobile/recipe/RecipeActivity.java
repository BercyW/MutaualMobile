package security.bercy.com.week5weekendmutaualmobile.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import security.bercy.com.week5weekendmutaualmobile.R;
import security.bercy.com.week5weekendmutaualmobile.model.Recipe;

public class RecipeActivity extends AppCompatActivity implements RecipeContract.View{

    RecipePresenter recipePresenter;
    List<Recipe> recipeList = new ArrayList<>();
    RecipeAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipePresenter.getRecipes(0,"rice");
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecipeAdapter(this, recipeList);

        recyclerView.setAdapter(adapter);

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
}
