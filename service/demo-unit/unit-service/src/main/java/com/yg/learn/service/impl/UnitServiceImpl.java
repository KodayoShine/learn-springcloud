package com.yg.learn.service.impl;

import com.yg.learn.api.client.UserServiceClient;
import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.utils.BeanUtils;
import com.yg.learn.dao.UnitMapper;
import com.yg.learn.domain.Unit;
import com.yg.learn.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitMapper unitMapper;

    @Autowired
    private UserServiceClient userService;

    @Override
    public UnitInfoDTO getDataSourceUnit(Long id) {
        Optional<Unit> unitOptional = unitMapper.findById(id);
        if(!unitOptional.isPresent()) {
            return null;
        }

        UnitInfoDTO unitInfoDTO = BeanUtils.transfrom(UnitInfoDTO.class, unitOptional.get());
        ResponseResult<UserOutDTO> user = userService.getUser(id);
        UserOutDTO result = user.getResult();
        unitInfoDTO.setUser(result);
        return unitInfoDTO;
    }
}
