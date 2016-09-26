package trainings.binglas.trainingsession;


import android.content.Context;

import dagger.ObjectGraph;

/**
 * Created by joaozao on 24/09/16.
 */

public class MyApplication extends android.app.Application{
    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        mObjectGraph = ObjectGraph.create(new InjectorModule(this));
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public final void inject(Object object) {
        mObjectGraph.inject(object);
    }

}
