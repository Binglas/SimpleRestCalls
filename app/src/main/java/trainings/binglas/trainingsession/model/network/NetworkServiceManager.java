package trainings.binglas.trainingsession.model.network;

import android.util.Log;

import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import trainings.binglas.trainingsession.event.RetrievePhotosEvent;
import trainings.binglas.trainingsession.event.RetrievePicInfoEvent;
import trainings.binglas.trainingsession.event.RetrievePicSizesEvent;
import trainings.binglas.trainingsession.model.infos.PhotoInfo;
import trainings.binglas.trainingsession.model.infos.RetrievePhotoInfo;
import trainings.binglas.trainingsession.model.photos.GetPublicPhotosResponse;
import trainings.binglas.trainingsession.model.photos.ModelPhoto;
import trainings.binglas.trainingsession.model.photos.Photo;
import trainings.binglas.trainingsession.model.sizes.ModelSize;
import trainings.binglas.trainingsession.model.sizes.RetrievePhotosSizesResponse;
import trainings.binglas.trainingsession.model.sizes.Size;
import trainings.binglas.trainingsession.utils.Defines;
import trainings.binglas.trainingsession.utils.Utils;

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
        // Using this event to show the progress bar in the begining of the call
        //EventBus.getDefault().post(new ShowProgressEvent());
        //
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
                // After get the response hide the progress using this event
                // EventBus.getDefault().post(new HideProgressEvent());
                //
                Log.d(Defines.TAG, "response : " + response.code());
                if (response.isSuccessful()) {
                    List<Photo> mPhotoList = response.body().getPhotos().getPhoto();
                    mModelPhoto.setPhotos(mPhotoList);
                    EventBus.getDefault().post(new RetrievePhotosEvent(response.body()));
                    Log.d(Defines.TAG, "" + mPhotoList);
                }else {
                    switch (response.code()) {
                        //TODO ERROR HANDLING
                        case 1:
                            break;
                        case 100:
                            break;
                        case 105:
                            break;
                        case 106:
                            break;
                        case 111:
                            break;
                        case 112:
                            break;
                        case 114:
                            break;
                        case 115:
                            break;
                        case 116:
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<GetPublicPhotosResponse> call, Throwable t) {
            }


        });
    }

    public void retrievePhotoSizes(final Photo photo) {
        PicturesAPI picSizesService = mApiServiceGenerator.createService(PicturesAPI.class);
        Call<RetrievePhotosSizesResponse> getPicSizes = picSizesService.getPictureSizes(
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
                    photo.setImageViewSize(mSizeList.get(6).getSource());
                    mModelSize.setSizes(mSizeList);
                    //mModelPhoto.setPhotos(mPhotoList);
                    EventBus.getDefault().post(new RetrievePicSizesEvent(response.body()));
                    Log.d(Defines.TAG, "" + mSizeList);
                }else {
                    switch (response.code()) {
                        //TODO ERROR HANDLING
                        case 1:
                            break;
                        case 2:
                            break;
                        case 100:
                            break;
                        case 105:
                            break;
                        case 106:
                            break;
                        case 111:
                            break;
                        case 112:
                            break;
                        case 114:
                            break;
                        case 115:
                            break;
                        case 116:
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<RetrievePhotosSizesResponse> call, Throwable t) {

            }
        });
    }

    public void retrievePhotoInfo(final Photo photo) {
        PicturesAPI picInfoService = mApiServiceGenerator.createService(PicturesAPI.class);
        Call<RetrievePhotoInfo> getPicSizes = picInfoService.getPictureInfo(
                Defines.GET_INFO_METHOD,
                Defines.API_KEY,
                photo.getId(),
                Defines.JSON_FORMAT,
                "1");
        getPicSizes.enqueue(new Callback<RetrievePhotoInfo>() {
            @Override
            public void onResponse(Call<RetrievePhotoInfo> call, Response<RetrievePhotoInfo> response) {
                Log.d(Defines.TAG, "response : " + response.code());
                Log.d(Defines.TAG, "response body: " + response.body());
                if (response.isSuccessful()) {
                    //Log.d(Defines.TAG, "response body syze : " + response.body().getSizes().getSize());
                    PhotoInfo photoInfo = response.body().getPhoto();
                    Utils utils = new Utils();
                    photo.setUsername(photoInfo.getOwner().getUsername());
                    photo.setPostedDateHR(utils.getHRDate(photoInfo.getDates().getPosted()));
                    photo.setLastUpdatedHR(utils.getHRDate(photoInfo.getDates().getLastupdate()));
                    photo.setDescription(photoInfo.getDescription().getContent());
                    photo.setOriginalFormat(photoInfo.getOriginalformat());
                    photo.setPostedDate(photoInfo.getDates().getPosted());
                    photo.setTakenDate(photoInfo.getDates().getTaken());
                    photo.setLastUpdated(photoInfo.getDates().getLastupdate());
                    photo.setLocation(photoInfo.getOwner().getLocation());
                    Log.d(Defines.TAG, "photo info : " + photo);
                    //mModelSize.setSizes(mSizeList);
                    //mModelPhoto.setPhotos(mPhotoList);
                    EventBus.getDefault().post(new RetrievePicInfoEvent(response.body(), photo));
                } else {
                    switch (response.code()) {
                        //TODO ERROR HANDLING
                        /**
                         *
                         * 1: Photo not found.
                         The photo id was either invalid or was for a photo not viewable by the calling user.
                         100: Invalid API Key
                         The API key passed was not valid or has expired.
                         105: Service currently unavailable
                         The requested service is temporarily unavailable.
                         106: Write operation failed
                         The requested operation failed due to a temporary issue.
                         111: Format "xxx" not found
                         The requested response format was not found.
                         112: Method "xxx" not found
                         The requested method was not found.
                         114: Invalid SOAP envelope
                         The SOAP envelope send in the request could not be parsed.
                         115: Invalid XML-RPC Method Call
                         The XML-RPC request document could not be parsed.
                         116: Bad URL found
                         One or more arguments contained a URL that has been used for abuse on Flickr.
                         */
                        case 1:
                            break;
                        case 100:
                            break;
                        case 105:
                            break;
                        case 106:
                            break;
                        case 111:
                            break;
                        case 112:
                            break;
                        case 114:
                            break;
                        case 115:
                            break;
                        case 116:
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<RetrievePhotoInfo> call, Throwable t) {

            }
        });
    }
}
