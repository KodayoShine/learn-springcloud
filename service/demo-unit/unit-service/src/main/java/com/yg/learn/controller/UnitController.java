package com.yg.learn.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpStatus;
import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.api.dto.e.UnitEnterDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import com.yg.learn.service.UnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/unit")
@RefreshScope
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


    @GetMapping("/async")
    public CompletableFuture<String> async() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                return "async";
        });
    }

    @GetMapping("/sync")
    public String sync() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sync";
    }


    @GetMapping("/save")
    public ResponseResult<UnitInfoDTO> save() {
        UnitEnterDTO unitEnterDTO = new UnitEnterDTO();
        unitEnterDTO.setCode("测试code" + RandomUtil.randomNumbers(2));
        unitEnterDTO.setUnitname("单位" + RandomUtil.randomNumbers(2));
        unitEnterDTO.setUsername("姓名" + RandomUtil.randomNumbers(2));
        UnitInfoDTO userOutDTO = unitService.insertData(unitEnterDTO);
        return ResponseResultManager.setResultSuccess(userOutDTO);
    }


    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }


}
