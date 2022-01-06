package cn.enilu.flash.dao.atool;

import cn.enilu.flash.bean.entity.tool.WorkFlow;
import cn.enilu.flash.dao.BaseRepository;

public interface ApsWrkFlwRepository extends BaseRepository<WorkFlow, Integer> {

    WorkFlow findByFlowId(Integer flowId);


}