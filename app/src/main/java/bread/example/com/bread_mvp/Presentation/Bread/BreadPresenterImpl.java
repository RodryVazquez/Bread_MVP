package bread.example.com.bread_mvp.Presentation.Bread;

import java.util.List;

import bread.example.com.bread_mvp.Model.BreadModel;
import bread.example.com.bread_mvp.Repository.BreadRepository.ApiCallback;
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
        this.breadView.showProgress();
        breadRepository.fetchBreadUsers(new ApiCallback<BreadModel>() {
            @Override
            public void onSuccess(List<BreadModel> ds) {
                breadView.displayBreadUsers(ds);
                breadView.hideProgress();
            }

            @Override
            public void onError(Throwable t) {
                breadView.showErrorMessage(t);
                breadView.hideProgress();
            }

            @Override
            public void onGenericMessage(String message) {
                breadView.showMessage(message);
                breadView.hideProgress();
            }
        });
    }

    @Override
    public void setView(BreadView view) {
        this.breadView = view;
    }
}
