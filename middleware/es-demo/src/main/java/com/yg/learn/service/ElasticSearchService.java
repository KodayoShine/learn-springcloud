package com.yg.learn.service;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ElasticSearchService {

    private TransportClient transportClient;

    public void insertById(String index, String type, String id, String jsonStr) {
        transportClient.prepareIndex(index, type,id).setSource(jsonStr, XContentType.JSON).get();
    }

    public void updateById(String index, String type, String id, String jsonStr) {
        transportClient.prepareUpdate(index, type,id)
                .setDoc(jsonStr, XContentType.JSON)
                .get();
    }

    public void deleteById(String index, String type, String id) {
        transportClient.prepareDelete(index, type, id).get();
    }

}
