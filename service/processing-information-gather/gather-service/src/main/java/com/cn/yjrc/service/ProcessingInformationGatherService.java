package com.cn.yjrc.service;

import com.cn.yjrc.domain.ProcessingInfo;

import java.util.List;

/**
 * @author zjdking
 * 2020/2/25 0025.
 * @version 1.0
 */

public interface ProcessingInformationGatherService {
    List<ProcessingInfo> getProcessingInfo(String cardId);
}
