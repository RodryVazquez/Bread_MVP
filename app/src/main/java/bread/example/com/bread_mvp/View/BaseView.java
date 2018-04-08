package bread.example.com.bread_mvp.View;

/**
 * Created by RodryVazquez on 07/04/18.
 */

public interface BaseView {

    void showMessage(String message);

    void showOfflineMessage(boolean isCritical);

    void showErrorMessage(Throwable throwable);

    void showProgress();

    void hideProgress();
}
