package com.yg.learn.dto.o;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OverviewEnterDTO implements Serializable {
    private static final long serialVersionUID = 7965794063576273949L;

    private String sfzh;

}
