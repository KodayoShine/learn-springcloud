package com.yg.learn.service;

import com.google.common.collect.Lists;
import com.yg.learn.domain.EsObject;
import com.yg.learn.repository.EsAnalyzeRepository;
import lombok.AllArgsConstructor;
import org.apache.lucene.document.Field;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EsAnalyzeService {

    private EsAnalyzeRepository esAnalyzeRepository;

    private ElasticsearchTemplate elasticsearchTemplate;

    public EsObject create(EsObject esObject) {
        EsObject save = esAnalyzeRepository.save(esObject);
        return save;
    }

    public List<EsObject> showGender(String gender) {
       // List<EsObject> esObjects = esAnalyzeRepository.findByBasicsInfo_Gender(gender);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        QueryBuilder nestedQuery = QueryBuilders.nestedQuery("basicsInfo", QueryBuilders.matchQuery("basicsInfo.gender",gender),ScoreMode.None);
        QueryBuilder nestedQuery2 = QueryBuilders.nestedQuery("basicsInfo", QueryBuilders.rangeQuery("basicsInfo.age").lt(20).gt(10),ScoreMode.None);

        queryBuilder.must(nestedQuery);
        queryBuilder.must(nestedQuery2);
        Iterable<EsObject> search = esAnalyzeRepository.search(queryBuilder);
        return Lists.newArrayList(search);
    }
}
