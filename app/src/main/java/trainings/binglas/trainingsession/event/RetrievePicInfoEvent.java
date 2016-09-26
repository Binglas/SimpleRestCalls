package trainings.binglas.trainingsession.event;

import trainings.binglas.trainingsession.model.infos.RetrievePhotoInfo;
import trainings.binglas.trainingsession.model.photos.Photo;

/**
 * Created by joaozao on 25/09/16.
 */

public class RetrievePicInfoEvent {
    private final Photo mPhoto;

    private RetrievePhotoInfo mRetrievePhotoInfo;
    public RetrievePicInfoEvent(RetrievePhotoInfo pRetrievePhotoInfo, Photo pPhoto) {
        mRetrievePhotoInfo = pRetrievePhotoInfo;
        mPhoto = pPhoto;
    }

    public RetrievePhotoInfo retrievePhotoInfo() {
        return mRetrievePhotoInfo;
    }

    public Photo getPhoto() {
        return mPhoto;
    }

}
