package bread.example.com.bread_mvp.Repository;

import java.util.List;

/**
 * Created by RodryVazquez on 24/03/18.
 */

public interface BaseRepository<T> {

    void add(T item);

    void add(Iterable<T> items);

    void update(T item);

    void remove(T item);

    void remove(Criteria criteria);

    List<T> query(Criteria criteria);
}
