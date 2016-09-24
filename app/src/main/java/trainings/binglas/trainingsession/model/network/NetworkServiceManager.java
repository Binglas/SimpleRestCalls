package trainings.binglas.trainingsession.model.network;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import trainings.binglas.trainingsession.model.GetPublicPhotosResponse;
import trainings.binglas.trainingsession.model.ModelPhoto;
import trainings.binglas.trainingsession.model.Photo;
import trainings.binglas.trainingsession.utils.Defines;

/**
 * Created by joaozao on 24/09/16.
 */

public class NetworkServiceManager {
    private ApiServiceGenerator mApiServiceGenerator;
    private ModelPhoto mModelPhoto;


    public NetworkServiceManager(ApiServiceGenerator pApiServiceGenerator, ModelPhoto pModelPhoto) {
        mApiServiceGenerator = pApiServiceGenerator;
        mModelPhoto = pModelPhoto;
    }

    public void getPublicPhotos() {
        PicturesAPI publicPicService = mApiServiceGenerator.createService(PicturesAPI.class);
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
                    /*sendImagesToAdapter();
                    ImageAdapter imageAdapter = new ImageAdapter(ItemListActivity.this, mPhotoList);
                    mRecyclerView.setAdapter(imageAdapter);*/
                    Log.d(Defines.TAG, "" + mPhotoList);
                    //progressDialog.hide();
                            /*JsonObject result = response.body();
                            final JsonObject data = result.getAsJsonObject(Defines.SKY_DATA);
                            Integer offset = data.get(Defines.SKY_OFFSET).getAsInt();
                            final JsonArray files = data.getAsJsonArray(Defines.FILES);

                            if (files.size() >= 0) {
                                mIsGettingImages = Boolean.FALSE;
                                if (mGettingImagesLl != null) {
                                    mGettingImagesLl.setVisibility(View.GONE);
                                }
                            }

                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    for (int i = 0; i < files.size(); i++) {
                                        JsonObject file = files.get(i).getAsJsonObject();
                                        ModelItem item = new ModelItem(file);
                                        mAdapter.addItemAtTail(item);
                                    }
                                }
                            }).start();


                            if (offset != 0) {
                                getAllImagesCloud(service,query,offset);
                            }*/
                }
            }

            @Override
            public void onFailure(Call<GetPublicPhotosResponse> call, Throwable t) {

            }


        });
    }
}
