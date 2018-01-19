package security.bercy.com.week5weekendmutaualmobile.di.component;

import dagger.Component;
import dagger.Module;
import security.bercy.com.week5weekendmutaualmobile.di.module.AppModule;
import security.bercy.com.week5weekendmutaualmobile.di.module.RecipeModule;
import security.bercy.com.week5weekendmutaualmobile.di.scope.AppScope;

/**
 * Created by Bercy on 1/17/18.
 */
@AppScope
@Component(modules= AppModule.class)
public interface AppComponent {

    RecipeComponent plus(RecipeModule recipeModule);

}
