package trainings.binglas.trainingsession;

import android.app.ProgressDialog;
import android.util.Log;

import de.greenrobot.event.EventBus;
import trainings.binglas.trainingsession.event.HideDialogEvent;
import trainings.binglas.trainingsession.event.ShowDialogEvent;
import trainings.binglas.trainingsession.utils.Defines;


/**
 * Created by joaozao on 25/09/16.
 */

public abstract class EventBaseActivity extends BaseActivity{
    private ProgressDialog mLoading;

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


    public void onEvent(ShowDialogEvent event) {
        mLoading = ProgressDialog.show(this, "Loading", "loading...", true);
    }

    public void onEvent(HideDialogEvent event) {
        if (mLoading == null) {
            return;
        }
        mLoading.dismiss();
        mLoading = null;
    }
}
