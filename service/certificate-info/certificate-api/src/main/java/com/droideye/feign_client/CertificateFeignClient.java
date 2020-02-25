package com.droideye.feign_client;

import com.droideye.dto.CertificateDTO;
import com.yg.learn.common.core.basic.ResponseResult;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("CERTIFICATION-INFO-SERVICE")
@RequestMapping("/certificate")
public interface CertificateFeignClient {
    @GetMapping("/forUserCerInfos/{idNumber}")
    ResponseResult<List<CertificateDTO>> forUserCerInfos(@PathVariable Long idNumber);
}
