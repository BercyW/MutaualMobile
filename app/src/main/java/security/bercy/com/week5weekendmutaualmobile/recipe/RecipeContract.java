package security.bercy.com.week5weekendmutaualmobile.recipe;

import java.util.List;

import security.bercy.com.week5weekendmutaualmobile.baseUtils.BasePresenter;
import security.bercy.com.week5weekendmutaualmobile.baseUtils.BaseView;
import security.bercy.com.week5weekendmutaualmobile.model.Recipe;

/**
 * Created by Bercy on 1/17/18.
 */

public interface RecipeContract {

    interface View extends BaseView {
        void updateRecipe(List<Recipe> recipesList);
    }
    interface Presenter extends BasePresenter<View> {
        void getRecipes(int fromNum,String query);
    }
}
