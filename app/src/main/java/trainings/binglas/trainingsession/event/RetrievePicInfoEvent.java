package trainings.binglas.trainingsession.event;

import trainings.binglas.trainingsession.model.infos.RetrievePhotoInfo;

/**
 * Created by joaozao on 25/09/16.
 */

public class RetrievePicInfoEvent {
    private RetrievePhotoInfo mRetrievePhotoInfo;

    public RetrievePicInfoEvent(RetrievePhotoInfo pRetrievePhotoInfo) {
        mRetrievePhotoInfo = pRetrievePhotoInfo;
    }

    public RetrievePhotoInfo retrievePhotoInfo() {
        return mRetrievePhotoInfo;
    }
}
