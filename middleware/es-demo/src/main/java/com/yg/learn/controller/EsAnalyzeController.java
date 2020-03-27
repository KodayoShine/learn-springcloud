package com.yg.learn.controller;

import com.yg.learn.domain.es.EsObject;
import com.yg.learn.service.EsAnalyzeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "es分析层")
@RequestMapping("/esAnalyze")
public class EsAnalyzeController {

    @Autowired
    private EsAnalyzeService esAnalyzeService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody EsObject esObject) {
        EsObject result = esAnalyzeService.create(esObject);
        return result;
    }

    // http://localhost:15001/esAnalyze/gender?gender=1&nationCode=1
    // http://localhost:15001/esAnalyze/gender?gender=1&nationCode=0
    @RequestMapping(value = "/gender", method = RequestMethod.GET)
    @ResponseBody
    public Object create(String gender,String nationCode) {
        List<EsObject> results = esAnalyzeService.showGender(gender,nationCode);
        return results;
    }

    @RequestMapping(value = "/oracleToEs", method = RequestMethod.GET)
    @ResponseBody
    public Object getOracleToEs(String gender) {
        esAnalyzeService.getOracleToEs();
        return "results";
    }

}
