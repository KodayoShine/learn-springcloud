package com.yg.learn.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.yg.learn.dao.AnalysisMapper;
import com.yg.learn.domain.es.BasicsInfo;
import com.yg.learn.domain.es.BusinessInfo;
import com.yg.learn.domain.es.EsObject;
import com.yg.learn.domain.oracle.AnalysisTest;
import com.yg.learn.repository.EsAnalyzeRepository;
import lombok.AllArgsConstructor;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EsAnalyzeService {

    private EsAnalyzeRepository esAnalyzeRepository;

    private ElasticsearchTemplate elasticsearchTemplate;

    private AnalysisMapper analysisMapper;


    public void getOracleToEs(){

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0;i< 10;i++){
            Pageable pageable = PageRequest.of(i,200);
            Page<AnalysisTest> analysisTests = analysisMapper.findAll(pageable);


            List<EsObject> list = new ArrayList<>();
            for (AnalysisTest analysisTest : analysisTests.getContent()) {
                EsObject esObject = new EsObject();
                esObject.setId(analysisTest.getId());
                esObject.setBasicsInfo(JSON.parseObject(analysisTest.getBasicinfo(), BasicsInfo.class));
                esObject.setBusinessInfo(JSON.parseObject(analysisTest.getBusinessinfo(), BusinessInfo.class));
                list.add(esObject);
            }
            esAnalyzeRepository.saveAll(list);
        }


        stopWatch.stop();
        System.out.println("处理时间" + stopWatch.getTotalTimeSeconds());
    }

    public EsObject create(EsObject esObject) {
        EsObject save = esAnalyzeRepository.save(esObject);
        return save;
    }

    public List<EsObject> showGender(String gender,String nationCode) {
        // 这种是无效的
        // List<EsObject> esObjects = esAnalyzeRepository.findByBasicsInfo_Gender(gender);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        QueryBuilder nestedQuery = QueryBuilders.nestedQuery("basicsInfo", QueryBuilders.matchQuery("basicsInfo.genderCode", gender),ScoreMode.None);
        queryBuilder.must(nestedQuery);

        QueryBuilder nestedQuery2 = QueryBuilders.nestedQuery("basicsInfo", QueryBuilders.matchQuery("basicsInfo.nationCode", nationCode),ScoreMode.None);
        queryBuilder.must(nestedQuery2);
        // 分页跟data别的封装是一样的
        // 这块需要有一点要注意的
        // 需要将所要进行排序的字段进行单独的抽取出去,跟id一层层级,做一层的冗余数据,方便排序
        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.ASC,"id"));
        Iterable<EsObject> search = esAnalyzeRepository.search(queryBuilder,pageRequest);
        return Lists.newArrayList(search);
    }



}
