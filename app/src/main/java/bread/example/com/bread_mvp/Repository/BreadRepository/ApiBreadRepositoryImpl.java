package bread.example.com.bread_mvp.Repository.BreadRepository;

import java.util.List;

import bread.example.com.bread_mvp.Api.BreadService;
import bread.example.com.bread_mvp.Api.ServiceGenerator;
import bread.example.com.bread_mvp.Model.BreadModel;
import bread.example.com.bread_mvp.Repository.Criteria;
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
    public List<BreadModel> query(Criteria criteria) {
        ApiSpecification filter = (ApiSpecification)criteria;
        BreadService breadService = ServiceGenerator.createService(BreadService.class);
        List<BreadModel> response = breadService.GetBreadUsers();
        //Apply filters in response
        if(filter != null){}
        return response;
    }

    public String setBreadTurn(int id)  {
        final StringBuilder error = new StringBuilder();
        BreadService breadService = ServiceGenerator.createService(BreadService.class);
        Call<Body> call = breadService.SetBreadTurn(id);
        call.enqueue(new Callback<Body>() {
            @Override
            public void onResponse(Call<Body> call, Response<Body> response) {
                if(response.isSuccessful()){
                    error.append(":)");
                }else{
                    error.append(response.message());
                }
            }

            @Override
            public void onFailure(Call<Body> call, Throwable t) {

            }
        });
        return error.toString();
    }


    public String setToken(String token, int id) {
        final StringBuilder error = new StringBuilder();
        BreadService breadService = ServiceGenerator.createService(BreadService.class);
        Call<Body> call = breadService.SetUserToken(token, id);
        call.enqueue(new Callback<Body>() {
            @Override
            public void onResponse(Call<Body> call, Response<Body> response) {
                if(response.isSuccessful()){
                    error.append(":)");
                }else{
                    error.append(response.message());
                }
            }

            @Override
            public void onFailure(Call<Body> call, Throwable t) {

            }
        });
        return error.toString();
    }
}
