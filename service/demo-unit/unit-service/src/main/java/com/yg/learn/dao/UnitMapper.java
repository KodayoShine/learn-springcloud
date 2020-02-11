package com.yg.learn.dao;

import com.yg.learn.domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitMapper extends JpaRepository<Unit, Long> {

    public Optional<Unit> findById(Long id);

    @Query(value = "SELECT u FROM Unit u WHERE unitname=:name")//HQL语法
    public Unit findName(@Param("name") String name);
}
