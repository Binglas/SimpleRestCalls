package trainings.binglas.trainingsession.event;

import trainings.binglas.trainingsession.model.photos.GetPublicPhotosResponse;

/**
 * Created by joaozao on 25/09/16.
 */

public class RetrievePhotosEvent {
    private GetPublicPhotosResponse mPublicPhotosResponse;

    public RetrievePhotosEvent(GetPublicPhotosResponse pGetPublicPhotosResponse) {
        mPublicPhotosResponse = pGetPublicPhotosResponse;
    }

    public GetPublicPhotosResponse getPublicPhotosResponse() {
        return mPublicPhotosResponse;
    }
}
