package trainings.binglas.trainingsession.model.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import trainings.binglas.trainingsession.model.GetPublicPhotosResponse;

/**
 * Created by joaozao on 24/09/16.
 */

public interface PicturesAPI {

    @GET("/services/rest")
    Call<GetPublicPhotosResponse> getPublicPictures(
            @Query("method") String method,
            @Query("api_key")String apiKey,
            @Query("user_id") String userID,
            @Query("format") String format,
            @Query("nojsoncallback") String noJson);
}
