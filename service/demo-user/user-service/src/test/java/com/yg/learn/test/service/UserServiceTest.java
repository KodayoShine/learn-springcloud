package com.yg.learn.test.service;

import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.dao.UserMapper;
import com.yg.learn.domain.User;
import com.yg.learn.service.impl.UserServiceImpl;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.Optional;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class UserServiceTest {

    UserMapper userMapper = mock(UserMapper.class);

    @Before
    public void before(){
        User user = new User();
        user.setId(1L);
        user.setUsername("test1");
        user.setPassword("123456");
        when(userMapper.findById(1L)).thenReturn(Optional.of(user));
    }
    
    @Test
    public void test_get_user_info() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserMapper(userMapper);

        UserOutDTO dataSourceUser = userService.getDataSourceUser(1L);
        Assert.assertThat(dataSourceUser.getId(), Is.is(1L));
        Assert.assertThat(dataSourceUser.getUsername(), Is.is("test1"));
    }
    
}
