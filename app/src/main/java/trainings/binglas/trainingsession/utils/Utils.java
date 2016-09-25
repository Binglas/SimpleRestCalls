package trainings.binglas.trainingsession.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by joaozao on 25/09/16.
 */

public class Utils {

    /**
     * Verify if user has connection to internet.
     *
     * @param context - the current context of application.
     * @return true if user has connection to internet, false otherwise.
     */
    public static boolean verifyConnection(Context context) {

        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }
}
