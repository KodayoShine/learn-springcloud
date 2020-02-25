package com.droideye.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "certification_info")
@Entity
public class Certificate implements Serializable {
    private static final long serialVersionUID = -1729263975303975701L;

    // 主键
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    // 证件类型（名称）
    @Column(name = "certificate_type")
    private String certificateType;

    // 证件编号
    @Column(name="certificate_number")
    private String certificateNumber;

    // 发布日期
    @Column(name="issuance_date")
    private Date issuanceDate;

    // 有效期
    @Column(name = "validity_date")
    private Date validityDate;

    // 用户证件号
    @Column(name = "user_id_number")
    private Long userIdNumber;
}
