
package com.yg.learn.api.dto;

import com.yg.learn.api.dto.o.UserOutDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 用户信息DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {


	private static final long serialVersionUID = 5353742449976226272L;

	private UserOutDTO user;

	private String[] permissions;

	private Integer[] roles;
}
