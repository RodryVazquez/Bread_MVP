package bread.example.com.bread_mvp.Application;

import android.app.Application;
import android.content.Context;

import com.instabug.library.Instabug;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import bread.example.com.bread_mvp.Api.ServiceGenerator;
import bread.example.com.bread_mvp.Components.BreadComponent;
import bread.example.com.bread_mvp.Components.DaggerBreadComponent;
import bread.example.com.bread_mvp.Modules.BreadModule;

/**
 * Created by Rodrigo Vazquez on 24/03/2018.
 */

public class BreadApplication extends Application {

    private BreadComponent breadComponent;
    public RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        breadComponent = DaggerBreadComponent.builder().breadModule(new BreadModule(this)).build();

        new Instabug.Builder(this, "eea7fdfd427201eb8dea57403d6daeac")
                .setInvocationEvent(InstabugInvocationEvent.SHAKE)
                .build();

        if(LeakCanary.isInAnalyzerProcess(this)){return;}
        refWatcher = LeakCanary.install(this);

        ServiceGenerator.setContext(this);
    }

    public BreadComponent getBreadComponent(){
        return breadComponent;
    }
}
