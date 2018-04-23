package bread.example.com.bread_mvp.Api.Exceptions;

/**
 * Created by RodryVazquez on 23/04/18.
 */

public class ConnectionException extends Exception {

    public ConnectionException() {
        super();
    }

    public ConnectionException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
