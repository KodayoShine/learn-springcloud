package com.yg.learn.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldDefinition {
    /**
     * 查询参数
     */
    private String key;

    /**
     * 查询类型
     */
    private QueryTypeEnum queryType;

    /**
     * 查询参数对应的文档中的字段
     */
    private String queryField;

    /**
     * from后缀
     */
    private String fromSuffix;

    /**
     * to后缀
     */
    private String toSuffix;

    /**
     * 分隔符
     */
    private String separator;

    /**
     * 嵌套查询的路径
     */
    private String nestedPath;

}
