package com.yg.learn.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpStatus;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.yg.learn.api.dto.e.UserEnterDTO;
import com.yg.learn.api.dto.o.HomePage2DTO;
import com.yg.learn.api.dto.o.HomePageDTO;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import com.yg.learn.domain.User;
import com.yg.learn.fallback.SentinelHandler;
import com.yg.learn.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Api(tags = "UserController", value = "用户管理")
@RestController
@RequestMapping("/user")
@RefreshScope
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息",notes = "查询数据库中用户的信息(详细一些)")
    @GetMapping("/{id}")
    public ResponseResult<UserOutDTO> getUser(@PathVariable Long id) {
        UserOutDTO user = userService.getDataSourceUser(id);
        if(user == null){
            return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, String.format("ID输入错误 %s", id));
        }
        log.info("根据id获取用户信息，用户名称为：{}", user.getUsername());
        return ResponseResultManager.setResultSuccess(user);
    }


    @PostMapping("/post")
    @ApiOperation(value = "post根据对象获取用户信息",notes = "11post查询数据库中用户的信息(详细一些)")
    // 必须加入@RequestBody
    public ResponseResult<UserOutDTO> getUserModel(@RequestBody UserEnterDTO userEnterDTO) {
        UserOutDTO user = userService.getDataSourceUser(1L);
        if(user == null){
            return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, String.format("ID输入错误 %s", 1L));
        }
        log.info("根据id获取用户信息，用户名称为：{}", user.getUsername());
        return ResponseResultManager.setResultSuccess(user);
    }

    @ApiOperation("获取首页信息")
    @GetMapping("/homepage")
    public ResponseResult<HomePageDTO> homePage() {
        HomePageDTO home = userService.gethomePage();
        return ResponseResultManager.setResultSuccess(home);
    }


    @ApiOperation("获取最新首页信息")
    @GetMapping("/newhomepage")
    public ResponseResult<HomePage2DTO> newhomepage() {
        HomePage2DTO home = userService.gethomePage2();
        return ResponseResultManager.setResultSuccess(home);
    }


    @GetMapping("/async")
    public CompletableFuture<String> async() {
        return CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "async";
            }
        );
    }

    @GetMapping("/sync")
    public String sync() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sync";
    }



    @GetMapping("/sentinel")
    @SentinelResource(value = "byResource",blockHandler = "handleException", blockHandlerClass = SentinelHandler.class)
    // 如果使用url 提示不友好
    // 最好使用sentinel的资源进行流量控制
    public ResponseResult<UserOutDTO> getSentinelUser() {
        UserOutDTO user = userService.getDataSourceUser(1L);
        if(user == null){
            return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, String.format("1有问题"));
        }
        log.info("根据id获取用户信息，用户名称为：{}", user.getUsername());
        return ResponseResultManager.setResultSuccess(user);
    }



    @ApiOperation("保存用户信息")
    @GetMapping("/save")
    public ResponseResult<UserOutDTO> save() {
        UserEnterDTO userEnterDTO = new UserEnterDTO();
        userEnterDTO.setUsername("测试" + RandomUtil.randomNumbers(2));
        userEnterDTO.setPassword("密码" + RandomUtil.randomString(2));
        UserOutDTO userOutDTO = userService.insertData(userEnterDTO);
        return ResponseResultManager.setResultSuccess(userOutDTO);
    }


        /**
         * 这里必须根据byResource进行资源限流,根据url限流无法显示该信息
         * @param exception
         * @return
         */
        public ResponseResult<UserOutDTO> handleException(BlockException exception){
            return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, String.format("限流"));
        }

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }



    @RequestMapping("/webAsyncTask")
    public WebAsyncTask<String> webAsyncTask(){
        log.info("请求线程：" + Thread.currentThread().getName());
        // 初始化时指定超时时间
        WebAsyncTask<String> result = new WebAsyncTask<>(3 * 1000L, new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("异步线程：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                    // int t = 1/0;
                } catch (Exception e) {
                    log.error("task exception", e);
                    return "task error";
                }
                return "task finished";
            }
        });
        // 任务超时后回调
        result.onTimeout(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("Web async task timed out");
                return "task timeout";
            }
        });
        // 超时后也会执行该回调
        result.onCompletion(new Runnable() {
            @Override
            public void run() {
                log.info("Web async task completed");
            }
        });
        // // spring5.0新增 暂不知如何回调
        result.onError(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.error("Web async task error");
                return "task error";
            }
        });

        return result;
    }


    @RequestMapping("/callable")
    public Callable<String> callable(){
        log.info("请求线程：" + Thread.currentThread().getName());
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("异步线程：" + Thread.currentThread().getName());
                return "callable";
            }
        };
    }

}
