package trainings.binglas.trainingsession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import trainings.binglas.trainingsession.model.ModelPhoto;
import trainings.binglas.trainingsession.model.network.ApiServiceGenerator;
import trainings.binglas.trainingsession.model.network.NetworkServiceManager;

/**
 * Created by joaozao on 24/09/16.
 */
@Module(injects = {ItemListActivity.class,}, complete = true)
public class InjectorModule {
    private MyApplication mMyApplication;

    public InjectorModule(MyApplication pMyApplication) {
        mMyApplication = pMyApplication;
    }

    @Provides
    public ApiServiceGenerator provideApiServiceGenerator() {
        return new ApiServiceGenerator();
    }


    @Provides
    public NetworkServiceManager provideFlickrFetchrServiceManager(ApiServiceGenerator pApiServiceGenerator, ModelPhoto pModelPhoto) {
        return new NetworkServiceManager(pApiServiceGenerator, pModelPhoto);
    }

    @Provides
    @Singleton
    public ModelPhoto providePhotoManager() {
        return new ModelPhoto();
    }
}
