package com.yg.learn.repository;


import com.yg.learn.domain.es.EsObject;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface EsAnalyzeRepository extends ElasticsearchRepository<EsObject, Long> {


}
