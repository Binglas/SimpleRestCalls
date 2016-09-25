package trainings.binglas.trainingsession.model.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import trainings.binglas.trainingsession.model.GetPublicPhotosResponse;
import trainings.binglas.trainingsession.model.RetrievePhotosSizesResponse;

/**
 * Created by joaozao on 24/09/16.
 */

public interface PicturesAPI {

    @GET("/services/rest")
    Call<RetrievePhotosSizesResponse> getPicturesSizes(
            @Query("method") String method,
            @Query("api_key")String apiKey,
            @Query("photo_id") String photoID,
            @Query("format") String format,
            @Query("nojsoncallback") String noJson);

    @GET("/services/rest")
    Call<GetPublicPhotosResponse> getInfo(
            @Query("method") String method,
            @Query("api_key")String apiKey,
            @Query("photo_id") String photoID,
            @Query("format") String format,
            @Query("nojsoncallback") String noJson);


}
