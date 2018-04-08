package bread.example.com.bread_mvp.View;

import java.util.List;

import bread.example.com.bread_mvp.Model.BreadModel;

/**
 * Created by Rodrigo Vazquez on 26/03/2018.
 */

public interface BreadView extends  BaseView{
    void displayBreadUsers(List<BreadModel> ds);
}
