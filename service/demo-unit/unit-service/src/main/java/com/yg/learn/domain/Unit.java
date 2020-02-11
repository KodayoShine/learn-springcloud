package com.yg.learn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unit {
    @Id
    private Long id;
    private String unitname;
    private String code;
}
