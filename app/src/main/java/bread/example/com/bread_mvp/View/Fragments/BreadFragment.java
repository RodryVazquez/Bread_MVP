package bread.example.com.bread_mvp.View.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import bread.example.com.bread_mvp.Adapter.BreadUsersAdapter;
import bread.example.com.bread_mvp.Application.BreadApplication;
import bread.example.com.bread_mvp.Model.BreadModel;
import bread.example.com.bread_mvp.Presentation.Bread.BreadPresenter;
import bread.example.com.bread_mvp.R;
import bread.example.com.bread_mvp.View.BreadView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rodrigo Vazquez on 26/03/2018.
 */

public class BreadFragment extends BaseFragment implements BreadView {

    @Inject
    BreadPresenter breadPresenter;

    @BindView(R.id.lstBreadUsers)
    RecyclerView lstBreadUsers;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout refreshLayout;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.lst_bread_users_fragment, container, false);
        ButterKnife.bind(this, root);
        lstBreadUsers.setHasFixedSize(true);
        lstBreadUsers.setLayoutManager(new LinearLayoutManager(getContext()));

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                breadPresenter.onResume();
            }
        });
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BreadApplication) getActivity().getApplication()).getBreadComponent().inject(this);
        
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
        if (ds.size() > 0) {
            BreadUsersAdapter breadUsersAdapter = new BreadUsersAdapter(getContext(), ds);
            lstBreadUsers.setAdapter(breadUsersAdapter);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOfflineMessage(boolean isCritical) {
        if (isCritical) {
            Toast.makeText(getContext(), getContext().getResources().getString(R.string.no_internet_connection_message), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showErrorMessage(Throwable throwable) {
        Log.e(getTag(), throwable.getMessage());
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        refreshLayout.setRefreshing(false);
    }
}
