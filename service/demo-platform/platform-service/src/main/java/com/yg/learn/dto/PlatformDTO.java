package com.yg.learn.dto;

import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.api.dto.o.UserOutDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlatformDTO implements Serializable {

    private static final long serialVersionUID = -6419837300101418926L;
    private UnitInfoDTO unitInfoDTO;

    private UserOutDTO userOutDTO;
}
