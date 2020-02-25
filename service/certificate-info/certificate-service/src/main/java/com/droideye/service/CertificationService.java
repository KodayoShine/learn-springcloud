package com.droideye.service;

import com.droideye.dto.CertificateDTO;

import java.util.List;

public interface CertificationService {

    List<CertificateDTO> forCertificatedStateByUserIdNum(Long userIdNum);
}
