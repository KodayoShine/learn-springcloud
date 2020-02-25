package com.droideye.service.impl;

import com.droideye.dao.CertificationMapper;
import com.droideye.domain.Certificate;
import com.droideye.dto.CertificateDTO;
import com.droideye.service.CertificationService;
import com.yg.learn.common.utils.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CertificationServiceImpl implements CertificationService {

    private final CertificationMapper certificationMapper;

    @Override
    public List<CertificateDTO> forCertificatedStateByUserIdNum(Long userIdNum) {
        Optional<List<Certificate>> certificatesOptional = certificationMapper.forCertificatedStateByUserIdNum(userIdNum);

        if (!certificatesOptional.isPresent()) {
            log.info("未找到用户证件号为{}的证件信息", userIdNum);
            return new ArrayList<>();
        }
        List<Certificate> certificates = certificatesOptional.get();
        List<CertificateDTO> result = certificates.stream()
                .map(certificate -> {
                    CertificateDTO transfrom = BeanUtils.transfrom(CertificateDTO.class, certificate);
                    transfrom.setCertificateType(transfrom.getCertificateType() + " of " + userIdNum);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                    transfrom.setIssuanceDate(simpleDateFormat.format(certificate.getIssuanceDate()));
                    transfrom.setValidityDate(simpleDateFormat.format(certificate.getValidityDate()));
                    return transfrom;
                })
                .collect(Collectors.toList());

        log.info("找到用户证件号为{}的证件信息，共{}条", userIdNum, result.size());
        return result;
    }
}
