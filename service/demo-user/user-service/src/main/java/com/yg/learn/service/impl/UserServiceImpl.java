package com.yg.learn.service.impl;

import com.yg.learn.api.dto.UserDTO;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.utils.BeanUtils;
import com.yg.learn.dao.UserMapper;
import com.yg.learn.domain.User;
import com.yg.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    private List<User> userList;


    @Override
    public UserOutDTO getDataSourceUser(Long id) {
        Optional<User> one = userMapper.findById(id);
        if(!one.isPresent()){
            return null;
        }
        User user = one.get();
        System.out.println(user);
        UserOutDTO userOutDTO = BeanUtils.transfrom(UserOutDTO.class, user);
        return userOutDTO;
    }



    @PostConstruct
    public void initData() {
        userList = new ArrayList<>();
        userList.add(new User(1L, "macro", "123456"));
        userList.add(new User(2L, "andy", "123456"));
        userList.add(new User(3L, "mark", "123456"));
    }
}
