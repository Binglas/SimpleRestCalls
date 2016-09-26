package trainings.binglas.trainingsession;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by joaozao on 24/09/16.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.get(this).inject(this);
    }
}
