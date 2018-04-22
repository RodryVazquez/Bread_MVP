package bread.example.com.bread_mvp.View.Fragments;

import android.support.v4.app.Fragment;

import bread.example.com.bread_mvp.Application.BreadApplication;

public class BaseFragment extends Fragment {

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((BreadApplication)getActivity().getApplication()).refWatcher.watch(this);
    }
}
