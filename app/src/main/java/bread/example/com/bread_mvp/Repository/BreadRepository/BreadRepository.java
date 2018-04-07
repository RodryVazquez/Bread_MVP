package bread.example.com.bread_mvp.Repository.BreadRepository;

import java.util.List;

import bread.example.com.bread_mvp.Model.BreadModel;
import bread.example.com.bread_mvp.Repository.BaseRepository;
import bread.example.com.bread_mvp.Repository.Criteria;

/**
 * Created by RodryVazquez on 03/04/18.
 */

public interface BreadRepository extends BaseRepository<BreadModel> {
    String setBreadTurn(int id);
    String setToken(String token, int id);
}
