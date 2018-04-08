package bread.example.com.bread_mvp.Repository;

import java.util.List;

/**
 * Created by RodryVazquez on 24/03/18.
 */

public interface BaseRepository<T> {

    void add(T item) throws Exception;

    void add(Iterable<T> items) throws Exception;

    void update(T item) throws  Exception;

    void remove(T item) throws  Exception;

    void remove(Criteria criteria) throws  Exception;

    List<T> query(Criteria criteria) throws Exception;
}
