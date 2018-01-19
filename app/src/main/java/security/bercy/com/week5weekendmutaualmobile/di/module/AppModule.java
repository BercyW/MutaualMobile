package security.bercy.com.week5weekendmutaualmobile.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import security.bercy.com.week5weekendmutaualmobile.data.RemoteDataSource;
import security.bercy.com.week5weekendmutaualmobile.di.scope.AppScope;

/**
 * Created by Bercy on 1/17/18.
 */

@Module
public class AppModule {

    String BASE_URL;
    Context context;

    public AppModule(String BASE_URL,Context context){
        this.BASE_URL = BASE_URL;
        this.context = context;
    }

    //pass the dependencies to sub-components

    @AppScope
    @Provides
    RemoteDataSource provideRemoteDataSource(){
        return new RemoteDataSource(BASE_URL,context);
    }
    @AppScope
    @Provides
    Context provideContext(){
        return this.context;
    }
}
