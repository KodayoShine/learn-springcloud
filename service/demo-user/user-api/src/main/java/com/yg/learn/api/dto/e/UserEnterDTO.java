
package com.yg.learn.api.dto.e;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * UserEnterDTO 用户入参的DTO.
 */

@Data
@ToString
public class UserEnterDTO implements Serializable {


	private static final long serialVersionUID = 3641151735582060951L;

	private String username;
	
	private String password;

}