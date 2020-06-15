package com.yg.learn.service.impl;

import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.api.dto.e.UnitEnterDTO;
import com.yg.learn.api.dto.o.UnitOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.utils.BeanUtils;
import com.yg.learn.dao.UnitMapper;
import com.yg.learn.domain.Unit;
import com.yg.learn.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public UnitInfoDTO getDataSourceUnit(Long id) {
        Optional<Unit> unitOptional = unitMapper.findById(id);
        if (!unitOptional.isPresent()) {
            return null;
        }

        UnitInfoDTO unitInfoDTO = BeanUtils.transfrom(UnitInfoDTO.class, unitOptional.get());
        return unitInfoDTO;
    }

    @Override
    public UnitInfoDTO insertData(UnitEnterDTO unitEnterDTO) {
        Unit unit = new Unit();
        unit.setCode(unitEnterDTO.getCode());
        unit.setUnitname(unitEnterDTO.getUnitname());
        unit.setUsername(unitEnterDTO.getUsername());
        Unit save = unitMapper.save(unit);
        UnitInfoDTO unitInfoDTO = BeanUtils.transfrom(UnitInfoDTO.class, save);
        return unitInfoDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUnit(Long id) {
        unitMapper.updateName("unitName111", id);
    }
}
