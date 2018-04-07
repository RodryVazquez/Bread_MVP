package bread.example.com.bread_mvp.Api;

import java.util.List;

import bread.example.com.bread_mvp.Model.BreadModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BreadService {

    String URL_GET_BREAD_USERS = "/api/breadusers";
    String URL_SET_BREAD_TURN = "/api/breadusers/{id}";
    String URL_SET_USER_TOKEN = "/api/breadusers/{token}";

    @GET(URL_GET_BREAD_USERS)
    List<BreadModel> GetBreadUsers();

    @PUT(URL_SET_BREAD_TURN)
    Call<Body> SetBreadTurn(@Path("id") int id);

    @PUT(URL_SET_USER_TOKEN)
    Call<Body> SetUserToken(@Path("token") String token, @Query("id") int id);
}
