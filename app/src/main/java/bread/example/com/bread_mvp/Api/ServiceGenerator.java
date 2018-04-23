package bread.example.com.bread_mvp.Api;

import android.app.Application;
import android.content.Context;

import com.instabug.library.Instabug;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.logging.InstabugNetworkLog;
import com.instabug.library.okhttplogger.InstabugOkhttpInterceptor;

import java.io.IOException;
import java.net.ConnectException;

import bread.example.com.bread_mvp.Application.BreadApplication;
import bread.example.com.bread_mvp.R;
import bread.example.com.bread_mvp.Util.ConnectionUtil;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Context appContext;

    public static void setContext(Context context){
        appContext = context;
    }

    private static String BASE_URL = "https://breadnotificationservice.azurewebsites.net/";

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(new InstabugOkhttpInterceptor())
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    if(!ConnectionUtil.isConnected(appContext)){
                        throw  new ConnectException(appContext.getResources().getString(R.string.no_internet_connection_message));
                    }
                    Request request = chain.request();
                    Response response = chain.proceed(request);
                    switch (response.code()) {
                        case 500:
                        case 501:
                        case 404:
                            InstabugLog.e(response.body().toString());
                            return response;
                    }
                    return response;
                }
            }).build();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    public static Retrofit retrofit() {
        return retrofit;
    }

    public static void changeBaseUrl(String newUrl) {
        BASE_URL = newUrl;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
