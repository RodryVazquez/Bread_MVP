package bread.example.com.bread_mvp.Application;

import android.app.Application;

import com.instabug.library.Instabug;
import com.instabug.library.invocation.InstabugInvocationEvent;

import bread.example.com.bread_mvp.Components.BreadComponent;
import bread.example.com.bread_mvp.Components.DaggerBreadComponent;
import bread.example.com.bread_mvp.Modules.BreadModule;

/**
 * Created by Rodrigo Vazquez on 24/03/2018.
 */

public class BreadApplication extends Application {

    private BreadComponent breadComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        breadComponent = DaggerBreadComponent.builder().breadModule(new BreadModule()).build();

        new Instabug.Builder(this, "eea7fdfd427201eb8dea57403d6daeac")
                .setInvocationEvent(InstabugInvocationEvent.SHAKE)
                .build();
    }
    public BreadComponent getBreadComponent(){
        return breadComponent;
    }
}
