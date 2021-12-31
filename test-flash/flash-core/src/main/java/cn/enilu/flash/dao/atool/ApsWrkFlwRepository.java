package cn.enilu.flash.dao.atool;

import cn.enilu.flash.bean.entity.atool.ApsWrkFlw;
import cn.enilu.flash.bean.entity.system.User;
import cn.enilu.flash.dao.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ApsWrkFlwRepository extends BaseRepository<ApsWrkFlw, Integer> {

    ApsWrkFlw findByFlowId(Integer flowId);


}