
package com.yg.learn.api.client;

import com.yg.learn.api.constant.UnitServerNameConstant;
import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.CompletableFuture;

/**
 * SysUserServiceClient
 */
@FeignClient(contextId = "unitServiceClient",value = UnitServerNameConstant.UNIT_SERVICE)
public interface UnitServiceClient {

	@GetMapping("/unit/{id}")
	ResponseResult<UnitInfoDTO> getUnit(@PathVariable Long id);


	@GetMapping("/unit/async")
	CompletableFuture<String> async();

	@GetMapping("/unit/sync")
	String sync();

}
