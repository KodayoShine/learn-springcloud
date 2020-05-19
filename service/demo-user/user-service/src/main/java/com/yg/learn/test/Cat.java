package com.yg.learn.test;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Cat {

    public Dog dog;

}
