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
import me.zhengjie.modules.fasttest.service.dto.DemoUserDto;
import me.zhengjie.utils.fasttest.MySQLHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ijumper
 * @date 2023-07-24
*/
@RestController
@RequiredArgsConstructor
@Api(tags = "FastTest：数据库操作")
@RequestMapping("/api/demouser")
public class DemoUserController {

    @Log("数据库操作")
    @ApiOperation("数据库操作")
    @PutMapping
    @AnonymousAccess
//    @PreAuthorize("@el.check('workflow:edit')")
    public ResponseEntity<Object> updateUser(@RequestBody DemoUserDto user){
        MySQLHelper helper = new MySQLHelper();
        JdbcTemplate jdbcTemplate = helper.connectDemoDb();
        String sql = "UPDATE user SET enabled="+user.getEnabled() + " WHERE name='" + user.getName() + "'";
        System.out.println(sql);
        jdbcTemplate.update(sql);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}