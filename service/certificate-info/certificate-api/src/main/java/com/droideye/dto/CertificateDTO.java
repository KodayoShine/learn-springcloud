package com.droideye.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "证书信息DTO类", description = "属性与实际传递名称不同，使用Jacoson注解进行了替换")
public class CertificateDTO implements Serializable {

    private static final long serialVersionUID = -1877291332421919989L;


    /**
     * key : 1
     * gzjzzType : 北京市工作居住证
     * gzjzzNum : 201701010001
     * issuanceDate : 2017年01月01日
     * validityDate : 2020年01月01日
     */

    // 主键
    // @JsonAlias 为字段起别名，当传入其中设置的key时同样可以为属性赋值
    @JsonAlias(value = {"key"})
    // @JsonProerty 为字段返回的key设置名称，不直接返回属性名称
    @JsonProperty("key")
    @ApiModelProperty(value = "主键", name = "id",example = "1")
    private Integer id;

    // 证件类型（名称）
    @JsonAlias({"gzjzzType", "certificateType"})
    @JsonProperty("gzjzzType")
    @ApiModelProperty(value = "证件类型", name = "certificateType", example = "北京市工作居住证")
    private String certificateType;

    // 证件编号
    @JsonAlias({"gzjzzNum", "certificateNumber"})
    @JsonProperty("gzjzzNum")
    @ApiModelProperty(value = "证件编号",name = "certificateNumber",example = "201701010001")
    private String certificateNumber;

    // 发布日期
    @ApiModelProperty(value = "发布日期",name = "issuanceDate",example = "2017年01月01日")
    private String issuanceDate;

    // 有效期
    @ApiModelProperty(value = "有效期",name = "validityDate",example = "2020年01月01日")
    private String validityDate;
}
