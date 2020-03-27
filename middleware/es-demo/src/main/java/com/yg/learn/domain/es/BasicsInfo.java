package com.yg.learn.domain.es;

import lombok.Data;

import java.io.Serializable;


@Data
public class BasicsInfo implements Serializable {
    private static final long serialVersionUID = -4691842052126982674L;

    private String perName;
    private Integer genderCode;
    private String perPhone;
    private Integer perTypeCode;
    private String perCode;
    private Integer nationCode;
    private Integer maritalStatusCode;
    private Integer politicalStatusCode;
    private Integer provinceCode;
    private Integer cityCode;
    private Integer districtCode;
    private String address;




}
