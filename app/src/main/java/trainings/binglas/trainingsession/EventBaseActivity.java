package trainings.binglas.trainingsession;

import android.util.Log;
import android.widget.ProgressBar;

import de.greenrobot.event.EventBus;
import trainings.binglas.trainingsession.event.HideProgressEvent;
import trainings.binglas.trainingsession.event.ShowProgressEvent;
import trainings.binglas.trainingsession.utils.Defines;


/**
 * Created by joaozao on 25/09/16.
 */

public abstract class EventBaseActivity extends BaseActivity{
    private ProgressBar mLoading;

    //register/unregister for events from the EventBus
    @Override
    protected void onPause() {
        super.onPause();
        Log.e(Defines.TAG, "unregister Event");
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(Defines.TAG, "register Event");
        EventBus.getDefault().register(this);
    }

    public void onEvent(ShowProgressEvent event) {
        // TODO use this events to show and hide the progress bar
    }

    public void onEvent(HideProgressEvent event) {
        // TODO use this events to show and hide the progress bar
    }
}
