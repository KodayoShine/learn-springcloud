package com.cn.yjrc.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zjdking
 * 2020/2/25 0025.
 * @version 1.0
 */
@ApiModel("在办信息类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessingInfo {
    @ApiModelProperty("这是一个key")
    private int key;
    private String opid;
    private int isChange;
    private String systemName;
    private String businessName;
    private String businessType;
    private String date;
    private String processing;
}
