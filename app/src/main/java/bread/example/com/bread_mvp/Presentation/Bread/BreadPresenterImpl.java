package bread.example.com.bread_mvp.Presentation.Bread;

import java.util.List;

import bread.example.com.bread_mvp.Model.BreadModel;
import bread.example.com.bread_mvp.Repository.BreadRepository.BreadRepository;
import bread.example.com.bread_mvp.View.BreadView;

/**
 * Created by RodryVazquez on 24/03/18.
 */

public class BreadPresenterImpl implements BreadPresenter {

    private BreadView breadView;
    BreadRepository breadRepository;

    public BreadPresenterImpl(BreadRepository repository) {
        this.breadRepository = repository;
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
        try {
            this.breadView.showProgress();
            List<BreadModel> ds = breadRepository.query(null);
            this.breadView.displayBreadUsers(ds);
            this.breadView.hideProgress();
        } catch (Exception e) {
            System.out.println(e);
            this.breadView.hideProgress();
            this.breadView.showErrorMessage(e);
        }
    }

    @Override
    public void setView(BreadView view) {
        this.breadView = view;
    }
}
