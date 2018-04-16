package bread.example.com.bread_mvp.Repository.BreadRepository;

import android.app.Service;

import java.util.ArrayList;
import java.util.List;

import bread.example.com.bread_mvp.Api.ApiError;
import bread.example.com.bread_mvp.Api.BreadService;
import bread.example.com.bread_mvp.Api.ErrorUtils;
import bread.example.com.bread_mvp.Api.ServiceGenerator;
import bread.example.com.bread_mvp.Model.BreadModel;
import bread.example.com.bread_mvp.Repository.Criteria;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class ApiBreadRepositoryImpl implements BreadRepository {

    @Override
    public void add(BreadModel item) {
    }

    @Override
    public void add(Iterable<BreadModel> items) {
    }

    @Override
    public void update(BreadModel item) {
    }

    @Override
    public void remove(BreadModel item) {
    }

    @Override
    public void remove(Criteria criteria) {
    }

    @Override
    public List<BreadModel> query(Criteria criteria){
       return null;
    }

    @Override
    public void setBreadTurn(int id, final ApiCallback callback) {
        BreadService breadService = ServiceGenerator.createService(BreadService.class);
        Call<ResponseBody> call = breadService.SetBreadTurn(id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    callback.onGenericMessage(response.body().toString());
                } else {
                    ApiError error = ErrorUtils.parseError(response);
                    callback.onGenericMessage(error.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    @Override
    public void setToken(String token, int id, final ApiCallback callback) {
        BreadService breadService = ServiceGenerator.createService(BreadService.class);
        Call<ResponseBody> call = breadService.SetUserToken(token, id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    callback.onGenericMessage(response.body().toString());
                } else {
                    ApiError error = ErrorUtils.parseError(response);
                    callback.onGenericMessage(error.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    @Override
    public void fetchBreadUsers(final ApiCallback callback) {

        BreadService breadService = ServiceGenerator.createService(BreadService.class);
        Call<List<BreadModel>> response = breadService.GetBreadUsers();
        response.enqueue(new Callback<List<BreadModel>>() {
            @Override
            public void onResponse(Call<List<BreadModel>> call, Response<List<BreadModel>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    ApiError error = ErrorUtils.parseError(response);
                    callback.onGenericMessage(error.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<BreadModel>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
