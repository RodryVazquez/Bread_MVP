package bread.example.com.bread_mvp.Modules;

import javax.inject.Singleton;

import bread.example.com.bread_mvp.Presentation.Bread.BreadPresenter;
import bread.example.com.bread_mvp.Presentation.Bread.BreadPresenterImpl;
import bread.example.com.bread_mvp.Repository.BreadRepository.BreadRepository;
import bread.example.com.bread_mvp.Repository.BreadRepository.RealmBreadRepositoryImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class BreadModule {

    @Provides
    @Singleton
    public BreadRepository provideBreadRepository(){return new RealmBreadRepositoryImpl();}

    @Provides
    public BreadPresenter provideBreadPresenter(){
        return new BreadPresenterImpl();
    }
}
