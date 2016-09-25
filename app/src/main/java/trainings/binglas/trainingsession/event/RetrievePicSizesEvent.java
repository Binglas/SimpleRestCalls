package trainings.binglas.trainingsession.event;

import trainings.binglas.trainingsession.model.RetrievePhotosSizesResponse;

/**
 * Created by joaozao on 25/09/16.
 */

public class RetrievePicSizesEvent {
    private RetrievePhotosSizesResponse mPicsSizesResponse;

    public RetrievePicSizesEvent(RetrievePhotosSizesResponse pRetrievePhotosSizesResponse) {
        mPicsSizesResponse = pRetrievePhotosSizesResponse;
    }

    public RetrievePhotosSizesResponse getPublicPhotosResponse() {
        return mPicsSizesResponse;
    }
}
