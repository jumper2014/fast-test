/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package me.zhengjie.modules.fasttest.service.impl;

import lombok.RequiredArgsConstructor;
import me.zhengjie.exception.EntityExistException;
import me.zhengjie.modules.fasttest.domain.Workflow;
import me.zhengjie.modules.fasttest.repository.WorkflowRepository;
import me.zhengjie.modules.fasttest.service.WorkflowService;
import me.zhengjie.modules.fasttest.service.dto.WorkflowDto;
import me.zhengjie.modules.fasttest.service.dto.WorkflowQueryCriteria;
import me.zhengjie.modules.fasttest.service.mapstruct.WorkflowMapper;
import me.zhengjie.utils.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
* @author Zheng Jie
* @date 2019-03-29
*/
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "workflow")
public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowRepository workflowRepository;
    private final WorkflowMapper workflowMapper;
    private final RedisUtils redisUtils;

    @Override
    public PageResult<WorkflowDto> queryAll(WorkflowQueryCriteria criteria, Pageable pageable) {
        Page<Workflow> page = workflowRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(workflowMapper::toDto).getContent(),page.getTotalElements());
    }

    @Override
    public List<WorkflowDto> queryAll(WorkflowQueryCriteria criteria) {
        List<Workflow> list = workflowRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));
        return workflowMapper.toDto(list);
    }

    @Override
    @Cacheable(key = "'id:' + #p0")
    public WorkflowDto findById(Long id) {
        Workflow workflow = workflowRepository.findById(id).orElseGet(Workflow::new);
        ValidationUtil.isNull(workflow.getId(),"Workflow","id",id);
        return workflowMapper.toDto(workflow);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Workflow resources) {
        Workflow workflow = workflowRepository.findByName(resources.getName());
        if(workflow != null){
            throw new EntityExistException(Workflow.class,"name",resources.getName());
        }
        workflowRepository.save(resources);
    }

    @Override
    @CacheEvict(key = "'id:' + #p0.id")
    @Transactional(rollbackFor = Exception.class)
    public void update(Workflow resources) {
        Workflow workflow = workflowRepository.findById(resources.getId()).orElseGet(Workflow::new);
        Workflow old = workflowRepository.findByName(resources.getName());
        if(old != null && !old.getId().equals(resources.getId())){
            throw new EntityExistException(Workflow.class,"name",resources.getName());
        }
        ValidationUtil.isNull( workflow.getId(),"Workflow","id",resources.getId());
        resources.setId(workflow.getId());
        workflowRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        workflowRepository.deleteAllByIdIn(ids);
    }

    @Override
    public void download(List<WorkflowDto> workflowDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (WorkflowDto workflowDTO : workflowDtos) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("流程名称", workflowDTO.getName());
            map.put("流程编号", workflowDTO.getFlowId());
            map.put("流程状态", workflowDTO.getEnabled() ? "启用" : "停用");
            map.put("创建日期", workflowDTO.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }


}
