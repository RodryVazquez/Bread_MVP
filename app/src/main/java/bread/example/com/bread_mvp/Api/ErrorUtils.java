package bread.example.com.bread_mvp.Api;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by RodryVazquez on 15/04/18.
 */

public class ErrorUtils {

    public static ApiError parseError(Response<?> response) {
        ApiError error;

        Converter<ResponseBody, ApiError> converter =
                ServiceGenerator.retrofit()
                        .responseBodyConverter(ApiError.class, new Annotation[0]);

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            e.printStackTrace();
            return new ApiError();
        }
        return error;
    }
}
