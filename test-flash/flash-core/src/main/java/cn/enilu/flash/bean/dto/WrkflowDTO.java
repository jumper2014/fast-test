package cn.enilu.flash.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// For APS tool

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WrkflowDTO {
    Integer flowId;
    String flowDesc;
    Integer stepCount;
    String flowStatus;
    String defaultResult;

}
