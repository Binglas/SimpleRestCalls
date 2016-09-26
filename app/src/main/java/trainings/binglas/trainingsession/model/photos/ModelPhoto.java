package trainings.binglas.trainingsession.model.photos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaozao on 24/09/16.
 */

public class ModelPhoto {

    List<Photo> mPhotos = new ArrayList<Photo>();

    public List<Photo> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(List<Photo> photos) {
        mPhotos = photos;
    }

}
