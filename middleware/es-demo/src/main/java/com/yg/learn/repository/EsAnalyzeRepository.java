package com.yg.learn.repository;


import com.yg.learn.domain.EsObject;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 商品ES操作类
 * Created by macro on 2018/6/19.
 */
public interface EsAnalyzeRepository extends ElasticsearchRepository<EsObject, Long> {

    List<EsObject> findByBasicsInfo_Gender(String gender);

}
