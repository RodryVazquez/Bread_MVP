package bread.example.com.bread_mvp.Application;

import android.app.Application;

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
    }

    public BreadComponent getBreadComponent(){
        return breadComponent;
    }
}
