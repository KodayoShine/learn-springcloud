package com.yg.learn.common.core.constants;

/**
 * 安全认证的常量.
 */
public interface SecurityConstants {

	/** The client fields. */
	String CLIENT_FIELDS = "client_id, CONCAT('{noop}',client_secret) as client_secret, resource_ids, scope, "
			+ "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
			+ "refresh_token_validity, additional_information, autoapprove";

	/** JdbcClientDetailsService 查询语句. */
	String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS + " from bs_oauth_details";

	/** 默认的查询语句. */
	String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

	/** 按条件client_id 查询. */
	String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";
}
