package com.yg.learn.domain.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;


@Document(indexName = "demo", type = "obj",shards = 1,replicas = 0)
@Data
public class EsObject implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    private Long id;

    @Field(type = FieldType.Nested)
    private BasicsInfo basicsInfo;

    @Field(type = FieldType.Nested)
    private BusinessInfo businessInfo;


}
