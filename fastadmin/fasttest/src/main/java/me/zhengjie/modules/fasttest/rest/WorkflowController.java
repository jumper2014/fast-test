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
package me.zhengjie.modules.fasttest.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.annotation.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.fasttest.domain.Workflow;
import me.zhengjie.modules.fasttest.service.WorkflowService;
import me.zhengjie.modules.fasttest.service.dto.WorkflowDto;
import me.zhengjie.modules.fasttest.service.dto.WorkflowQueryCriteria;
import me.zhengjie.utils.PageResult;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author ijumper
 * @date 2023-07-24
*/
@RestController
@RequiredArgsConstructor
@Api(tags = "FastTest：流程管理")
@RequestMapping("/api/workflow")
public class WorkflowController {

    private final WorkflowService workflowService;
    private static final String ENTITY_NAME = "workflow";

    @ApiOperation("导出流程数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('workflow:list')")
    public void exportWorkflow(HttpServletResponse response, WorkflowQueryCriteria criteria) throws IOException {
        workflowService.download(workflowService.queryAll(criteria), response);
    }

    @ApiOperation("查询流程")
    @GetMapping
//    @PreAuthorize("@el.check('workflow:list','user:list')")
    @AnonymousAccess
    public ResponseEntity<PageResult<WorkflowDto>> queryWorkflow(WorkflowQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(workflowService.queryAll(criteria, pageable),HttpStatus.OK);
    }

    @Log("新增流程")
    @ApiOperation("新增流程")
    @PostMapping
    @PreAuthorize("@el.check('workflow:add')")
    public ResponseEntity<Object> createWorkflow(@Validated @RequestBody Workflow resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        workflowService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改流程")
    @ApiOperation("修改流程")
    @PutMapping
    @PreAuthorize("@el.check('workflow:edit')")
    public ResponseEntity<Object> updateWorkflow(@Validated(Workflow.Update.class) @RequestBody Workflow resources){
        workflowService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除流程")
    @ApiOperation("删除流程")
    @DeleteMapping
    @PreAuthorize("@el.check('workflow:del')")
    public ResponseEntity<Object> deleteWorkflow(@RequestBody Set<Long> ids){
        // 验证是否被用户关联
        workflowService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}