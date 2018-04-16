package bread.example.com.bread_mvp.Api;

/**
 * Created by RodryVazquez on 15/04/18.
 */

public class ApiError {

    private int statusCode;
    private String message;

    public ApiError(){}

    public int getStatusCode(){
        return statusCode;
    }

    public String getMessage(){
        return message;
    }
}
