package com.yg.learn.test;

import com.cn.yjrc.domain.dto.ProcessingInfo;
import com.cn.yjrc.feignClent.MyFeignClient;
import com.droideye.dto.CertificateDTO;
import com.droideye.feign_client.CertificateFeignClient;
import com.yg.learn.api.client.UnitServiceClient;
import com.yg.learn.api.client.UserServiceClient;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import com.yg.learn.dto.OverviewInfoDTO;
import com.yg.learn.service.PlatformService;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OverviewInfoTest {

    private final UserServiceClient userServiceClient = mock(UserServiceClient.class);
    private final UnitServiceClient unitServiceClient = mock(UnitServiceClient.class);
    private final CertificateFeignClient certificateFeignClient = mock(CertificateFeignClient.class);

    private final MyFeignClient myFeignClient = mock(MyFeignClient.class);


    @Before
    public void before() {
        //ResponseResult<>
        ResponseResult<List<CertificateDTO>> objectResponseResult = ResponseResultManager.setResultSuccess(null);
        when(certificateFeignClient.forUserCerInfos(1L)).thenReturn(objectResponseResult);

        ResponseResult<List<ProcessingInfo>> listResponseResult = ResponseResultManager.setResultSuccess(null);
        when(myFeignClient.getProcessingInfo("1")).thenReturn(listResponseResult);


    }

    @Test
    public void test_get_data() {
        PlatformService platformService = new PlatformService(userServiceClient, unitServiceClient,certificateFeignClient,myFeignClient);
        OverviewInfoDTO overviewInfoDTO = platformService.getOverviewInfo("abs");
        Assert.assertThat(overviewInfoDTO.getIsComplete(), Is.is(1));
        Assert.assertThat(overviewInfoDTO.getIsRelation(), Is.is(1));

    }
    
}
