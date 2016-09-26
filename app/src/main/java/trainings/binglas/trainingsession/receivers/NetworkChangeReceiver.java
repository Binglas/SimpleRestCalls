package trainings.binglas.trainingsession.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import trainings.binglas.trainingsession.utils.Utils;

/**
 * Created by joaozao on 26/09/16.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        boolean status = Utils.verifyConnection(context);

        //TODO HANDLE OFFLINE BEHAVIORS

    }

}

