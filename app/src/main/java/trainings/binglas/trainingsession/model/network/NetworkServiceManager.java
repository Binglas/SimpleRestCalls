package trainings.binglas.trainingsession.model.network;

import android.util.Log;

import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import trainings.binglas.trainingsession.event.RetrievePhotosEvent;
import trainings.binglas.trainingsession.event.RetrievePicSizesEvent;
import trainings.binglas.trainingsession.model.GetPublicPhotosResponse;
import trainings.binglas.trainingsession.model.ModelPhoto;
import trainings.binglas.trainingsession.model.ModelSize;
import trainings.binglas.trainingsession.model.Photo;
import trainings.binglas.trainingsession.model.RetrievePhotosSizesResponse;
import trainings.binglas.trainingsession.model.Size;
import trainings.binglas.trainingsession.utils.Defines;

/**
 * Created by joaozao on 24/09/16.
 */

public class NetworkServiceManager {
    private ApiServiceGenerator mApiServiceGenerator;
    private ModelPhoto mModelPhoto;
    private ModelSize mModelSize;


    public NetworkServiceManager(ApiServiceGenerator pApiServiceGenerator, ModelPhoto pModelPhoto, ModelSize pModelSize) {
        mApiServiceGenerator = pApiServiceGenerator;
        mModelPhoto = pModelPhoto;
        mModelSize = pModelSize;
    }

    public void retrievePublicPhotos() {
        UserAPI publicPicService = mApiServiceGenerator.createService(UserAPI.class);
        Call<GetPublicPhotosResponse> getPublicPics = publicPicService.getPublicPictures(
                Defines.GET_PUBLIC_PICTURES_METHOD,
                Defines.API_KEY,
                Defines.DEFAULT_USER_ID,
                Defines.JSON_FORMAT,
                "1");
        getPublicPics.enqueue(new Callback<GetPublicPhotosResponse>() {
            @Override
            public void onResponse(Call<GetPublicPhotosResponse> call, Response<GetPublicPhotosResponse> response) {
                Log.d(Defines.TAG, "response : " + response.code());
                if (response.isSuccessful()) {
                    List<Photo> mPhotoList = response.body().getPhotos().getPhoto();
                    mModelPhoto.setPhotos(mPhotoList);
                    EventBus.getDefault().post(new RetrievePhotosEvent(response.body()));
                    Log.d(Defines.TAG, "" + mPhotoList);
                }
            }

            @Override
            public void onFailure(Call<GetPublicPhotosResponse> call, Throwable t) {

            }


        });
    }

    public void retrievePhotosSizes(final Photo photo) {
        PicturesAPI picSizesService = mApiServiceGenerator.createService(PicturesAPI.class);
        Call<RetrievePhotosSizesResponse> getPicSizes = picSizesService.getPicturesSizes(
                Defines.GET_SIZES_METHOD,
                Defines.API_KEY,
                photo.getId(),
                Defines.JSON_FORMAT,
                "1");
        getPicSizes.enqueue(new Callback<RetrievePhotosSizesResponse>() {
            @Override
            public void onResponse(Call<RetrievePhotosSizesResponse> call, Response<RetrievePhotosSizesResponse> response) {
                Log.d(Defines.TAG, "response : " + response.code());
                if (response.isSuccessful()) {
                    //Log.d(Defines.TAG, "response body syze : " + response.body().getSizes().getSize());
                    List<Size> mSizeList = response.body().getSizes().getSize();
                    photo.setThumbnailListSize(mSizeList.get(0).getSource());
                    photo.setThumbnailGridSize(mSizeList.get(4).getSource());
                    mModelSize.setSizes(mSizeList);
                    //mModelPhoto.setPhotos(mPhotoList);
                    EventBus.getDefault().post(new RetrievePicSizesEvent(response.body()));
                    Log.d(Defines.TAG, "" + mSizeList);
                }
            }

            @Override
            public void onFailure(Call<RetrievePhotosSizesResponse> call, Throwable t) {

            }
        });
    }
}
