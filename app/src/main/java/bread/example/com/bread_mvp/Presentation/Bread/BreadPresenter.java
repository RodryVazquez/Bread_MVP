package bread.example.com.bread_mvp.Presentation.Bread;

import bread.example.com.bread_mvp.Presentation.LifeCyclesPresenter;
import bread.example.com.bread_mvp.View.BreadView;

/**
 * Created by Rodrigo Vazquez on 26/03/2018.
 */

public interface BreadPresenter extends LifeCyclesPresenter {
    void fetchBreadUsers();
    void setView(BreadView view);
}
