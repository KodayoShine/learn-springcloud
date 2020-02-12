package com.yg.learn.service;

import com.yg.learn.api.client.UnitServiceClient;
import com.yg.learn.api.client.UserServiceClient;
import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.dto.PlatformDTO;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlatformService {

    private final UserServiceClient userServiceClient;
    private final UnitServiceClient unitServiceClient;


    public PlatformDTO getAllData(Long id) {
        ResponseResult<UserOutDTO> user = userServiceClient.getUser(id);
        ResponseResult<UnitInfoDTO> unit = unitServiceClient.getUnit(id);

        // 进行封装
        PlatformDTO platformDTO = new PlatformDTO();
        platformDTO.setUnitInfoDTO(unit.getResult());
        platformDTO.setUserOutDTO(user.getResult());
        return platformDTO;
    }
}
