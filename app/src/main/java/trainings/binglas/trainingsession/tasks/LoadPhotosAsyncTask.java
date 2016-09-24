/*
package trainings.binglas.trainingsession.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import trainings.binglas.trainingsession.model.ModelPhoto;

*/
/**
 * Created by joaozao on 24/09/16.
 *//*


class LoadPhotosAsyncTask extends AsyncTask<String, Integer, List> {
    private Activity mActivity;
    private ProgressDialog progressDialog;
    private Integer totalCount, currentIndex;

    public LoadPhotosAsyncTask(Activity pActivity) {
        this.mActivity = pActivity;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("Loading images from Flickr. Please wait...");
        progressDialog.show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setMessage(String.format("Loading images from Flickr %s/%s. Please wait...", values[0], values[1]));
    }

    @Override
    protected List doInBackground(String... params) {
        Flickr flickr = new Flickr(ConstantValues.FLICKR_API_KEY, ConstantValues.FLICKR_FORMAT);
        List photos = flickr.getPhotoSets().getPhotos(ConstantValues.PHOTOSET_ID);
        List result = new ArrayList();
        totalCount = photos.size();
        currentIndex = 0;
        for (Photo photo : photos) {
            currentIndex++;
            List sizes = flickr.getPhotos().getSizes(photo.getId());
            String thumbnailUrl = sizes.get(0).getSource();
            String mediumUrl = sizes.get(4).getSource();
            InputStream inputStreamThumbnail = null,inputStreamMedium=null;
            try {
                inputStreamThumbnail = new URL(thumbnailUrl).openStream();
                inputStreamMedium = new URL(mediumUrl).openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Bitmap bitmapThumbnail = BitmapFactory.decodeStream(inputStreamThumbnail);
            Bitmap bitmapMedium = BitmapFactory.decodeStream(inputStreamMedium);
            result.add(new ImageInfo(photo.getTitle(),bitmapThumbnail ,bitmapMedium ));
            publishProgress(currentIndex, totalCount);
//                if (currentIndex>3)
//                    break;
        }
        currentAppData.setImageInfos(result);
        return result;
    }

    @Override
    protected void onPostExecute(List s) {
        progressDialog.dismiss();
        imageGridViewAdapter = new ImageGridViewAdapter(MainActivity.this);
        gridView.setAdapter(imageGridViewAdapter);
        super.onPostExecute(s);
    }
}*/
