package com.yg.learn.service;
import com.cn.yjrc.domain.dto.ProcessingInfo;
import com.cn.yjrc.feignClent.MyFeignClient;
import com.droideye.dto.CertificateDTO;
import com.droideye.feign_client.CertificateFeignClient;
import com.google.common.collect.Lists;
import com.yg.learn.dto.OverviewInfoDTO.NoticeBean;
import com.yg.learn.dto.OverviewInfoDTO.AuthBean;

import com.yg.learn.api.client.UnitServiceClient;
import com.yg.learn.api.client.UserServiceClient;
import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.dto.OverviewInfoDTO;
import com.yg.learn.dto.PlatformDTO;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class PlatformService {

    private final UserServiceClient userServiceClient;
    private final UnitServiceClient unitServiceClient;

    /**  证件信息业务 */
    private final CertificateFeignClient certificateFeignClient;

    /** 在办业务信息 */
    private final MyFeignClient myFeignClient;



    public PlatformDTO getAllData(Long id) {
        ResponseResult<UserOutDTO> user = userServiceClient.getUser(id);
        ResponseResult<UnitInfoDTO> unit = unitServiceClient.getUnit(id);

        // 进行封装
        PlatformDTO platformDTO = new PlatformDTO();
        platformDTO.setUnitInfoDTO(unit.getResult());
        platformDTO.setUserOutDTO(user.getResult());
        return platformDTO;
    }

    public String sync() {
        long start = System.currentTimeMillis();
        userServiceClient.sync();
        unitServiceClient.sync();
        long end = System.currentTimeMillis();
        System.out.println("同步调用两个接口" + (end - start));
        return "ok";
    }

    public String async() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(start);
        CompletableFuture<String> result1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("userServiceClient======" + Thread.currentThread().getName());
            return userServiceClient.sync();
        });

        CompletableFuture<String> result2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("unitServiceClient======" + Thread.currentThread().getName());
            return unitServiceClient.sync();
        });

        long end1 = System.currentTimeMillis();
        System.out.println(end1);
        String s = result1.get();
        String s1 = result2.get();
        long end2 = System.currentTimeMillis();
        System.out.println("使用CompletableFuture分别调用两个接口: " + (end2 - end1));
        return s + s1;
    }

    public String userasync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(start);

        CompletableFuture<String> result2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("unitServiceClient======" + Thread.currentThread().getName());
            return unitServiceClient.sync();
        });

        CompletableFuture<String> result1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("userServiceClient======" + Thread.currentThread().getName());
            return userServiceClient.sync();
        });



        long end1 = System.currentTimeMillis();
        System.out.println(end1);
        String s = result2.get();
        String s1 = result1.get();
        long end2 = System.currentTimeMillis();
        System.out.println("使用CompletableFuture分别调用两个接口: " + (end2 - end1));
        return s + s1;
    }

    public OverviewInfoDTO getOverviewInfo(String sfzh) {
        OverviewInfoDTO overviewInfoDTO = new OverviewInfoDTO();
        overviewInfoDTO.setSfzh(sfzh);
        overviewInfoDTO.setIsComplete(1);
        overviewInfoDTO.setIsRelation(1);

        NoticeBean notice = new NoticeBean();
        notice.setPolicyNotice(Lists.newArrayList(new NoticeBean.PolicyNoticeBean(1,"管理办法（试行）","【2019-10-16】")));
        notice.setSystemNotcie(Lists.newArrayList(""));
        notice.setBusinessNotice(Lists.newArrayList(new NoticeBean.BusinessNoticeBean(1,"您的工作居住证即将过期，请立即办理证件续签业务")));
        overviewInfoDTO.setNotice(notice);


        AuthBean auth = new AuthBean();
        auth.setUnitRelation(Lists.newArrayList(new AuthBean.UnitRelationBean(1, "单位名称")));
        auth.setRcpxAuth(Lists.newArrayList(new AuthBean.RcpxAuthBean(1,"人才评选","",2,"当前单位没有开通该业务的办理权限")));
        auth.setRcyjAuth(Lists.newArrayList(new AuthBean.RcyjAuthBean(1, "工作居住证", "gzjzz", 1,"success"),new AuthBean.RcyjAuthBean(2, "引进人才", "", 2,"当前单位没有开通该业务的办理权限"),new AuthBean.RcyjAuthBean(3, "干部调京", "", 5,"信息作假，被加入黑名单")));
        auth.setRczzAuth(Lists.newArrayList(new AuthBean.RczzAuthBean(1,"人才资质","",3,"不满足申请资质")));
        auth.setRcfwAuth(Lists.newArrayList(new AuthBean.RcfwAuthBean(1,"人才服务","",3,"不满足申请资质")));
        overviewInfoDTO.setAuth(auth);

        OverviewInfoDTO.PersonalInfoBean personInfo = new OverviewInfoDTO.PersonalInfoBean();
        personInfo.setKey(1);
        personInfo.setName("测试用户");
        personInfo.setPhone("13800138000");
        personInfo.setCardType("居民身份证");
        personInfo.setCardNum("110108198800000000");
        overviewInfoDTO.setPersonalInfo(Lists.newArrayList(personInfo));

        ResponseResult<List<CertificateDTO>> listResponseResult = certificateFeignClient.forUserCerInfos(1L);
        List<CertificateDTO> result = listResponseResult.getResult();
        overviewInfoDTO.setValidCertificateCard(result);

        ResponseResult<List<ProcessingInfo>> processingInfo = myFeignClient.getProcessingInfo("1");
        List<ProcessingInfo> processingInfos = processingInfo.getResult();
        overviewInfoDTO.setProcessingBusiness(processingInfos);
        return overviewInfoDTO;
    }
}
