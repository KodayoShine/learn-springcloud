
package com.yg.learn.api.client;

import com.yg.learn.api.constant.UnitServerNameConstant;
import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * SysUserServiceClient
 */
@FeignClient(contextId = "unitServiceClient",value = UnitServerNameConstant.BLACK_SHOP_USER_SERVICE)
public interface UnitServiceClient {

	@GetMapping("/unit/{id}")
	ResponseResult<UnitInfoDTO> getUser(@PathVariable Long id);

}
