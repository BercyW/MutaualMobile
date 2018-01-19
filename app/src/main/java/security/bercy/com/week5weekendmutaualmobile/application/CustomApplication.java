package security.bercy.com.week5weekendmutaualmobile.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import security.bercy.com.week5weekendmutaualmobile.di.component.AppComponent;
import security.bercy.com.week5weekendmutaualmobile.di.component.DaggerAppComponent;
import security.bercy.com.week5weekendmutaualmobile.di.component.RecipeComponent;
import security.bercy.com.week5weekendmutaualmobile.di.module.AppModule;
import security.bercy.com.week5weekendmutaualmobile.di.module.RecipeModule;

/**
 * Created by Bercy on 1/17/18.
 */

public class CustomApplication extends Application {
    public static final String BASE_URL = "https://api.edamam.com/";
    private AppComponent appComponent;
    private RecipeComponent recipeComponent;

    @Override
    public void onCreate() {
        super.onCreate();




       AppModule appModule = new AppModule(BASE_URL, getApplicationContext());
       appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
    }


    public static CustomApplication get(Context context){

        return (CustomApplication) context.getApplicationContext();
    }

    public RecipeComponent getRecipeComponent(){
        recipeComponent = appComponent.plus(new RecipeModule());
        return recipeComponent;
    }

    public void clearRecipeListComponent() {
        recipeComponent = null;

    }
}
