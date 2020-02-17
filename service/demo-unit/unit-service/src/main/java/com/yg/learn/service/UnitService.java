package com.yg.learn.service;


import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.api.dto.e.UnitEnterDTO;

public interface UnitService {

    UnitInfoDTO getDataSourceUnit(Long id);

    UnitInfoDTO insertData(UnitEnterDTO unitEnterDTO);
}
