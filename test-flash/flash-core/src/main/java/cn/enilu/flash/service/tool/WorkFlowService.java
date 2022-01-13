package cn.enilu.flash.service.tool;

import cn.enilu.flash.bean.dto.WrkflowDTO;
import cn.enilu.flash.bean.entity.tool.WorkFlow;
import cn.enilu.flash.cache.CacheDao;
import cn.enilu.flash.dao.atool.ApsWrkFlwRepository;
import cn.enilu.flash.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created  on 2018/3/23 0023.
 *
 * @author enilu
 */
@Service
public class WorkFlowService extends BaseService<WorkFlow, Integer, ApsWrkFlwRepository> {
    private Logger logger = LoggerFactory.getLogger(WorkFlowService.class);
    @Autowired
    private ApsWrkFlwRepository apsWrkFlwRepository;
    @Autowired
    private CacheDao cacheDao;
    @Value("${jwt.token.expire.time}")
    private Long tokenExpireTime;


    public WorkFlow findByFlowId(Integer flowId) {
        //由于：@Cacheable标注的方法，如果其所在的类实现了某一个接口，那么该方法也必须出现在接口里面，否则cache无效。
        //具体的原因是， Spring把实现类装载成为Bean的时候，会用代理包装一下，所以从Spring Bean的角度看，只有接口里面的方法是可见的，其它的都隐藏了，自然课看不到实现类里面的非接口方法，@Cacheable不起作用。
        //所以这里手动控制缓存
        WorkFlow apsWrkFlw = cacheDao.hget(CacheDao.SESSION, flowId, WorkFlow.class);
        if (apsWrkFlw != null) {
            return apsWrkFlw;
        }
        apsWrkFlw = apsWrkFlwRepository.findByFlowId(flowId);
        cacheDao.hset(CacheDao.SESSION, flowId, apsWrkFlw);
        return apsWrkFlw;
    }


    @Override
    public WorkFlow update(WorkFlow record) {
        WorkFlow workFlow = super.update(record);
        cacheDao.hset(CacheDao.SESSION, workFlow.getFlowId(), workFlow);
        return workFlow;
    }


    public WorkFlow update(WrkflowDTO wrkflowDTO) {
        WorkFlow workFlow = apsWrkFlwRepository.findByFlowId(wrkflowDTO.getFlowId());
        workFlow.setFlowDesc(wrkflowDTO.getFlowDesc());
        workFlow.setDefaultResult(wrkflowDTO.getDefaultResult());
        workFlow.setFlowStatus(wrkflowDTO.getFlowStatus());
        workFlow.setStepCount(Integer.valueOf(wrkflowDTO.getStepCount()));
        update(workFlow);
        return workFlow;
    }


}
