package com.yg.learn.domain.oracle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ANALYSIS_TEST")
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisTest {

    @Id
    private Long id;

    private String basicinfo;

    private String businessinfo;

}
