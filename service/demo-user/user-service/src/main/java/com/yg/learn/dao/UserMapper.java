package com.yg.learn.dao;

import com.yg.learn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMapper extends JpaRepository<User, Long> {

    public Optional<User> findById(Long id);

   // public User findByUsernameAndCatAge(String name,int age);

    @Query(value = "SELECT u FROM User u WHERE username=:name")//HQL语法
    public User findName(@Param("name") String name);
}
