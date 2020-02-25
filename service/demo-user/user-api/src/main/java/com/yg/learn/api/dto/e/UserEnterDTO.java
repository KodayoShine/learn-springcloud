
package com.yg.learn.api.dto.e;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * UserEnterDTO 用户入参的DTO.
 *
 */
@Data
@ToString
public class UserEnterDTO implements Serializable {


	private static final long serialVersionUID = 3641151735582060951L;

	@JsonAlias(value={"name","user"})
	private String username;
	
	private String password;

}