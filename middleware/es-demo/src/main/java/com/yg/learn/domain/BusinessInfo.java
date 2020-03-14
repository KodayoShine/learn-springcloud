package com.yg.learn.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessInfo implements Serializable {
    private static final long serialVersionUID = 2460630571584678046L;

    private String hireUnit;

    private String infoOne;

    private Integer infoTwo;


}
