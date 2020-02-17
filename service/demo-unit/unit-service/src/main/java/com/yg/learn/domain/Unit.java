package com.yg.learn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="unit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unit {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Long id;
    private String unitname;
    private String code;
    private String username;
}
