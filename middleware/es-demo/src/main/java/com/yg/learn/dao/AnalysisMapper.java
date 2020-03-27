package com.yg.learn.dao;

import com.yg.learn.domain.oracle.AnalysisTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnalysisMapper extends JpaRepository<AnalysisTest, Long> {


}
