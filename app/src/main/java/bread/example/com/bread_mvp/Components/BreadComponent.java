package bread.example.com.bread_mvp.Components;

import javax.inject.Singleton;

import bread.example.com.bread_mvp.Modules.BreadModule;
import bread.example.com.bread_mvp.Repository.BreadRepository.ApiBreadRepositoryImpl;
import bread.example.com.bread_mvp.View.Fragments.BreadFragment;
import dagger.Component;

/**
 * Created by RodryVazquez on 24/03/18.
 */

@Singleton
@Component(modules = {BreadModule.class})
public interface BreadComponent {
    void inject(BreadFragment breadFragment);
}
