package com.yg.learn.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
}
