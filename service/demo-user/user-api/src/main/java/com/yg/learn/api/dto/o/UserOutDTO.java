package com.yg.learn.api.dto.o;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOutDTO implements Serializable {

    private static final long serialVersionUID = 1264178941913834213L;
    private Long id;

    private String username;

}
