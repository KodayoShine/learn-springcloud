package com.yg.learn.controller;

import cn.hutool.http.HttpStatus;
import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import com.yg.learn.service.UnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unit")
public class UnitController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UnitService unitService;

    @GetMapping("/{id}")
    public ResponseResult<UnitInfoDTO> getUnit(@PathVariable Long id) {
        UnitInfoDTO unit = unitService.getDataSourceUnit(id);
        if(unit == null){
            return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, String.format("ID输入错误 %s", id));
        }
        LOGGER.info("根据id获取用户信息，单位名称为：{}", unit.getUnitname());
        return ResponseResultManager.setResultSuccess(unit);
    }


}
