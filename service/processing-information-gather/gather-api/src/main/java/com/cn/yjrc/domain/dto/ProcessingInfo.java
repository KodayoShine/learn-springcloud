package com.cn.yjrc.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zjdking
 * 2020/2/26 0026.
 * @version 1.0
 */
@ApiModel("在办信息类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessingInfo implements Serializable {

    private static final long serialVersionUID = 7516743470386571064L;
    @JsonProperty("key123")
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
