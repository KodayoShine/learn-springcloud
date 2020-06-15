package com.yg.learn.dao;

import com.yg.learn.domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitMapper extends JpaRepository<Unit, Long> {

    public Optional<Unit> findById(Long id);

    @Query(value = "SELECT u FROM Unit u WHERE unitname=:name")//HQL语法
    public Unit findName(@Param("name") String name);


    @Modifying
    @Query(value = "update Unit u set u.unitname=:name where u.id = :id")//HQL语法
    Integer updateName(@Param("name") String name,@Param("id") Long id);
}
