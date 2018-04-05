package bread.example.com.bread_mvp.Modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rodrigo Vazquez on 24/03/2018.
 */

@Module
public class APIModule {

    private Application application;

    public APIModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return application;
    }
}
