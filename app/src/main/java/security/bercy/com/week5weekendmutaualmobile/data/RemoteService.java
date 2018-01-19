package security.bercy.com.week5weekendmutaualmobile.data;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import security.bercy.com.week5weekendmutaualmobile.model.Response;

/**
 * Created by Bercy on 1/17/18.
 */

public interface RemoteService {

    @GET("search")
    Observable<Response> getRecipes(
            @Query("q") String query,
            @Query("from") String from,
            @Query("to") String to,
            @Query("app_id") String app_id,
            @Query("app_key") String app_key);


}
