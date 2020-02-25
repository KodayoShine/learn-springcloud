package com.yg.learn.fallback;

import cn.hutool.http.HttpStatus;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;

public class SentinelHandler {

    /**
     * 这里必须根据byResource进行资源限流,根据url限流无法显示该信息
     * @param exception
     * @return
     */
    public static ResponseResult<UserOutDTO> handleException(BlockException exception){
        return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, String.format("限流"));
    }

}
