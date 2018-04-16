package bread.example.com.bread_mvp.Api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static String BASE_URL = "https://breadnotificationservice.azurewebsites.net/";

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static  <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    public static Retrofit retrofit(){
        return retrofit;
    }

    public static void changeBaseUrl(String newUrl){
        BASE_URL = newUrl;
    }

    public static String getBaseUrl(){return BASE_URL;}
}
