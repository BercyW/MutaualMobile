package security.bercy.com.week5weekendmutaualmobile.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import security.bercy.com.week5weekendmutaualmobile.R;

public class RecipeActivity extends AppCompatActivity {

    RecipePresenter recipePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipePresenter.getRecipes(0,"rice");

    }
}
