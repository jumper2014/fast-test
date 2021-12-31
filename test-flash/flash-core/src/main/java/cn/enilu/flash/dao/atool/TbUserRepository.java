package cn.enilu.flash.dao.atool;


import cn.enilu.flash.bean.entity.atool.TbUser;
import cn.enilu.flash.dao.BaseRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created  on 2018/3/21 0021.
 *
 * @author enilu
 */
public interface TbUserRepository extends BaseRepository<TbUser, Long> {
    @Query(value = "select * from tb_user where user_id = 1", nativeQuery = true)
    TbUser findByName();
}
