package com.yg.learn.test;

import com.yg.learn.api.client.UnitServiceClient;
import com.yg.learn.api.client.UserServiceClient;
import com.yg.learn.dto.OverviewInfoDTO;
import com.yg.learn.service.PlatformService;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class OverviewInfoTest {

    private final UserServiceClient userServiceClient = mock(UserServiceClient.class);
    private final UnitServiceClient unitServiceClient = mock(UnitServiceClient.class);

    
    @Test
    public void test_get_data() {
        PlatformService platformService = new PlatformService(userServiceClient, unitServiceClient,null);
        OverviewInfoDTO overviewInfoDTO = platformService.getOverviewInfo("abs");
        Assert.assertThat(overviewInfoDTO.getIsComplete(), Is.is(1));
        Assert.assertThat(overviewInfoDTO.getIsRelation(), Is.is(1));

    }
    
}
