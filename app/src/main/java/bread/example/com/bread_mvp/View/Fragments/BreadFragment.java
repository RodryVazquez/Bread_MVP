package bread.example.com.bread_mvp.View.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import bread.example.com.bread_mvp.Application.BreadApplication;
import bread.example.com.bread_mvp.Model.BreadModel;
import bread.example.com.bread_mvp.Presentation.Bread.BreadPresenter;
import bread.example.com.bread_mvp.View.BreadView;

/**
 * Created by Rodrigo Vazquez on 26/03/2018.
 */

public class BreadFragment extends Fragment implements BreadView {

    @Inject
    BreadPresenter breadPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((BreadApplication) getActivity().getApplication()).getBreadComponent().inject(this);
        breadPresenter.setView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        breadPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        breadPresenter.onPause();
    }

    @Override
    public void displayBreadUsers(List<BreadModel> ds) {
        //TODO recycler view
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }
}
