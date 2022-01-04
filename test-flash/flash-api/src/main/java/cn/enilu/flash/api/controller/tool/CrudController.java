package cn.enilu.flash.api.controller.tool;


import cn.enilu.flash.api.annotation.DSource;
import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.dto.WrkflowDTO;
import cn.enilu.flash.api.factory.WrkFlowFactory;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.atool.ApsWrkFlw;
import cn.enilu.flash.bean.enumeration.BizExceptionEnum;
import cn.enilu.flash.bean.exception.ApplicationException;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.atool.ApsWrkFlwService;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * 测试工具
 */
@RestController
@RequestMapping("/crud")
public class CrudController extends BaseController {
    @Autowired
    ApsWrkFlwService apsWrkFlwService;

    @DSource(value = "crud")
    @GetMapping("/list")
    public Object listRule(
            @RequestParam(required = false) String flowId,
            @RequestParam(required = false) String flowDesc) {
        Page page = new PageFactory().defaultPage();
        page.addFilter("flowId", SearchFilter.Operator.LIKE, flowId);
        page.addFilter("flowDesc", SearchFilter.Operator.LIKE, flowDesc);
        page.setSort(Sort.by(Sort.Direction.DESC, "flowId"));
        page = apsWrkFlwService.queryPage(page);
        List list = (List) new UserWrapper(BeanUtil.objectsToMaps(page.getRecords())).warp();
        page.setRecords(list);
        return Rets.success(page);
    }

    @DSource(value = "crud")
    @PostMapping("/add")
    public Object save(@Valid WrkflowDTO wrkflowDTO, BindingResult result) {
        System.out.println("/add");
        if (wrkflowDTO.getFlowId() != null) {
            // 判断是否重复
            ApsWrkFlw flow = apsWrkFlwService.findByFlowId(wrkflowDTO.getFlowId());
            if (flow != null) {
                apsWrkFlwService.update(wrkflowDTO);
            } else {
                apsWrkFlwService.insert(WrkFlowFactory.createWrkFlow(wrkflowDTO, new ApsWrkFlw()));
            }

        }
        return Rets.success();
    }

        @DSource(value = "crud")
        @DeleteMapping("/delete")
        public Object remove(@RequestParam Integer flowId) {
            if (flowId == null) {
                throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
            }
            apsWrkFlwService.delete(flowId);
            return Rets.success();
        }

    }