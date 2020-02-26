package com.droideye.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.droideye.dto.CertificateDTO;
import com.droideye.service.CertificationService;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import cn.hutool.http.HttpStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/certificate")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "证件信息业务", tags = "证件信息业务的Controller")
public class CertificateController {

    private final CertificationService certificationService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/forUserCerInfos/{idNumber}")
    @ApiOperation(value = "获取证件状态信息", notes = "根据持证人证件号码，查询证件信息记录中，证件状态为有效状态的证件状态信息内容")
    @SentinelResource(value = "/certificate/forUserCerInfos/1", blockHandler = "handleException")
    public ResponseResult<List<CertificateDTO>> forUserCerInfos(@PathVariable Long idNumber) {
        List<CertificateDTO> certificateDTOS = certificationService.forCertificatedStateByUserIdNum(idNumber);
        certificateDTOS.forEach(certificateDTO -> certificateDTO.setServerPort(serverPort));

        return ResponseResultManager.setResultSuccess(certificateDTOS);
    }

    public ResponseResult<List<CertificateDTO>> handleException(BlockException exception) {
        return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, String.format("限流"));
    }

}
