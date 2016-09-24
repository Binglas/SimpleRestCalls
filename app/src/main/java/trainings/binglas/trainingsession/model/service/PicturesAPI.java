package trainings.binglas.trainingsession.model.service;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by joaozao on 24/09/16.
 */

public interface PicturesAPI {

    @GET("/services/rest")
    Call<JsonObject> getPublicPictures(
            @Query("method") String method,
            @Query("api_key")String apiKey,
            @Query("user_id") String userID,
            @Query("format") String format,
            @Query("nojsoncallback") String noJson);
}
