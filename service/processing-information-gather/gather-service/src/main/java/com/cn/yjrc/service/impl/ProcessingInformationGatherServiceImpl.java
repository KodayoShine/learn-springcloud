package com.cn.yjrc.service.impl;

import com.cn.yjrc.domain.ProcessingInfo;
import com.cn.yjrc.service.ProcessingInformationGatherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjdking
 * 2020/2/25 0025.
 * @version 1.0
 */
@Service
public class ProcessingInformationGatherServiceImpl implements ProcessingInformationGatherService {

    @Override
    public List<ProcessingInfo> getProcessingInfo(String cardId) {
        List<ProcessingInfo> list= new ArrayList<>();
        if("1".equals(cardId)){

            list.add(new ProcessingInfo(1,"1000000"
                    ,1
                    ,"工作居住证"
                    ,"北京市工作居住证"
                    ,"证件业务信息变更"
                    ,"2019-01-06"
                    ,"退回个人修改"));
            list.add(new ProcessingInfo(1,"1000001"
                    ,0
                    ,"引进人才"
                    ,"外埠人才引进"
                    ,"引进人才申请"
                    ,"2019-03-11"
                    ,"市局审批通过，待完善落户信息"));


        }

        return list;
    }
}
