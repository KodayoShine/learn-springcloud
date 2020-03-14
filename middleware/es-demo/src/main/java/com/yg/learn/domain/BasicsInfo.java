package com.yg.learn.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
public class BasicsInfo implements Serializable {
    private static final long serialVersionUID = -4691842052126982674L;


    private Integer age;

    private String gender;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Keyword)
    private String degree;



}
