package com.yg.learn.domain.es;

import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessInfo implements Serializable {
    private static final long serialVersionUID = 2460630571584678046L;

    private Integer key;
    private String unitName;
    private String unitCode;
    private Integer relationStateCode;
    private String relationState;
    private String reason;


}
