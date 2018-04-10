package bread.example.com.bread_mvp.Repository.BreadRepository;

import java.util.ArrayList;
import java.util.List;

import bread.example.com.bread_mvp.Model.BreadModel;

public interface ApiCallback<T> {

    void onSuccess(List<T> ds);

    void onError(Throwable t);

    void onGenericMessage(String message);
}
