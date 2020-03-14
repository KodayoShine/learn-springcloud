package com.yg.learn.controller;

import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import com.yg.learn.domain.EsObject;
import com.yg.learn.service.EsAnalyzeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "es分析层")
@RequestMapping("/esAnalyze")
public class EsAnalyzeController {

    @Autowired
    private EsAnalyzeService esAnalyzeService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult create(@RequestBody EsObject esObject) {
        EsObject result = esAnalyzeService.create(esObject);
        return ResponseResultManager.setResultSuccess(result);
    }

    @RequestMapping(value = "/gender", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult create(String gender) {
        List<EsObject> results = esAnalyzeService.showGender(gender);
        return ResponseResultManager.setResultSuccess(results);
    }

}
