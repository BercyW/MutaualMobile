package security.bercy.com.week5weekendmutaualmobile.di.component;

import dagger.Subcomponent;
import security.bercy.com.week5weekendmutaualmobile.di.module.RecipeModule;
import security.bercy.com.week5weekendmutaualmobile.di.scope.ActivityScope;
import security.bercy.com.week5weekendmutaualmobile.model.Recipe;
import security.bercy.com.week5weekendmutaualmobile.recipe.RecipeActivity;

/**
 * Created by Bercy on 1/18/18.
 */
@ActivityScope
@Subcomponent(modules = RecipeModule.class)
public interface RecipeComponent {
    void inject(RecipeActivity activity);
}
