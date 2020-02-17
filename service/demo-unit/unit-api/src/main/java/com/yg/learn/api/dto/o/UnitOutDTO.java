package com.yg.learn.api.dto.o;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitOutDTO implements Serializable {
    private static final long serialVersionUID = 5517234530139929398L;

    private Long id;

    private String unitname;

    private String code;

}
