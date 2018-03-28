package bread.example.com.bread_mvp.Presentation.Bread;

import java.util.List;

import bread.example.com.bread_mvp.Model.BreadModel;
import bread.example.com.bread_mvp.View.BreadView;

/**
 * Created by RodryVazquez on 24/03/18.
 */

public class BreadPresenterImpl implements BreadPresenter {

    private BreadView breadView;
    private List<BreadModel> breadUsers;

    public BreadPresenterImpl() {
    }

    @Override
    public void onResume() {
        fetchBreadUsers();
    }

    @Override
    public void onPause() {
    }

    @Override
    public void fetchBreadUsers() {
        //TODO
    }

    @Override
    public void setView(BreadView view) {
        this.breadView = view;
    }
}
