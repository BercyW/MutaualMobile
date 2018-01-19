package security.bercy.com.week5weekendmutaualmobile.data;

import android.content.Context;



import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import security.bercy.com.week5weekendmutaualmobile.model.Response;

/**
 * Created by Bercy on 1/17/18.
 */

public class RemoteDataSource {

    public static final String APP_ID="4e364f74";
    public static final String APP_KEY="1cae91ccb431532e2f7d8cb5c7f6bfbc";
    Context context;
    private String BASE_URL;

    @Inject
    public RemoteDataSource(String BASE_URL, Context context) {
        this.BASE_URL = BASE_URL;
        this.context = context;
    }

    public Retrofit create() {

        int cacheSize = 10 * 1024 * 1024;

        Cache cache = new Cache(context.getCacheDir(), cacheSize);


        //Create a logging interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        //create a client for the adding the interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public Observable<Response> getResponse(String query, String from, String to) {
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getRecipes(query,from,to,APP_ID,APP_KEY);
    }


}
