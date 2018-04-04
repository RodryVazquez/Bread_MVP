package bread.example.com.bread_mvp.Repository;

/**
 * Created by RodryVazquez on 03/04/18.
 */

public interface Mapper<From, To> {
    To map(From from);
}
