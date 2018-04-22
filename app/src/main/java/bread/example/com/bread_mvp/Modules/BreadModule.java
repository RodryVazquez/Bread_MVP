package bread.example.com.bread_mvp.Modules;

import android.content.Context;
import android.os.Environment;

import javax.inject.Named;
import javax.inject.Singleton;

import bread.example.com.bread_mvp.Presentation.Bread.BreadPresenter;
import bread.example.com.bread_mvp.Presentation.Bread.BreadPresenterImpl;
import bread.example.com.bread_mvp.Repository.BreadRepository.ApiBreadRepositoryImpl;
import bread.example.com.bread_mvp.Repository.BreadRepository.BreadRepository;
import bread.example.com.bread_mvp.Repository.BreadRepository.RealmBreadRepositoryImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class BreadModule {

    Context context;

    public BreadModule(Context context){ this.context = context;}

    @Provides
    @Singleton
    @Named("ApiImpl")
    BreadRepository provideBreadApiRepository() {
        return new ApiBreadRepositoryImpl();
    }

    @Provides
    @Singleton
    @Named("RealmImpl")
    BreadRepository provideBreadRealmRepository() {
        return new RealmBreadRepositoryImpl();
    }

    @Provides
    public BreadPresenter provideBreadPresenter(@Named("ApiImpl") BreadRepository breadRepository) {
        return new BreadPresenterImpl(breadRepository);
    }
}
