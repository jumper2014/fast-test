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
package me.zhengjie.modules.fasttest.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.zhengjie.base.BaseDTO;

import java.io.Serializable;

/**
* @author ijumper
* @date 2023-07-24
*/
@Getter
@Setter
@NoArgsConstructor
public class WorkflowDto extends BaseDTO implements Serializable {

    private Long id;

    private String name;

    private Boolean enabled;

    public WorkflowDto(String name, Boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }
}