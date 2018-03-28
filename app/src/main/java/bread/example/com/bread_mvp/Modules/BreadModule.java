package bread.example.com.bread_mvp.Modules;

import bread.example.com.bread_mvp.Presentation.Bread.BreadPresenter;
import bread.example.com.bread_mvp.Presentation.Bread.BreadPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class BreadModule {
    @Provides
    public BreadPresenter provideBreadPresenter(){
        return new BreadPresenterImpl();
    }
}
