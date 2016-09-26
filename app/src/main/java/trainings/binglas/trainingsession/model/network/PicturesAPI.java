package trainings.binglas.trainingsession.model.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import trainings.binglas.trainingsession.model.infos.RetrievePhotoInfo;
import trainings.binglas.trainingsession.model.sizes.RetrievePhotosSizesResponse;

/**
 * Created by joaozao on 24/09/16.
 */

public interface PicturesAPI {

    @GET("/services/rest")
    Call<RetrievePhotosSizesResponse> getPictureSizes(
            @Query("method") String method,
            @Query("api_key")String apiKey,
            @Query("photo_id") String photoID,
            @Query("format") String format,
            @Query("nojsoncallback") String noJson);

    @GET("/services/rest")
    Call<RetrievePhotoInfo> getPictureInfo(
            @Query("method") String method,
            @Query("api_key")String apiKey,
            @Query("photo_id") String photoID,
            @Query("format") String format,
            @Query("nojsoncallback") String noJson);


}
