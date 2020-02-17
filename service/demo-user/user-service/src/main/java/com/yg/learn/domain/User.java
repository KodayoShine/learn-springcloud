package com.yg.learn.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /*@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @GeneratedValue(generator = "paymentableGenerator")*/
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
}
