package com.sgm.b2c.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;


/**
 * 认证服务器配置
 * @author Li B
 *
 * 2017年2月17日上午10:50:04
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private static String REALM="MY_OAUTH_REALM";
	
	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private UserApprovalHandler userApprovalHandler;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Autowired
	@Qualifier("secondDatasource")
	private DataSource dataSource;


	/**
	 * 用来配置客户端详情服务（ClientDetailsService），
	 * 客户端详情信息在这里进行初始化，
	 * 你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
	 * authorization_code：授权码类型。
	 * implicit：隐式授权类型。
	 * password：资源所有者（即用户）密码类型。
	 * client_credentials：客户端凭据（客户端ID以及Key）类型。
	 * refresh_token：通过以上授权获得的刷新令牌来获取新的令牌。
     * clientId：（必须的）用来标识客户的Id。
	 * secret：（需要值得信任的客户端）客户端安全码，如果有的话。
	 * scope：用来限制客户端的访问范围，如果为空（默认）的话，那么客户端拥有全部的访问范围。
	 * authorizedGrantTypes：此客户端可以使用的授权类型，默认为空。
	 * authorities：此客户端可以使用的权限（基于Spring Security authorities）。
	 * @param clients
	 * @throws Exception
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource);
//		.inMemory()
//	        .withClient("my-trusted-client")
//            .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//            .scopes("read", "write", "trust")
//            .secret("secret")
//            .accessTokenValiditySeconds(120).
//            refreshTokenValiditySeconds(600);
	}

	/**
	 * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
	 * @param endpoints
	 * @throws Exception
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
				.authenticationManager(authenticationManager);
	}

	/**
	 * 用来配置令牌端点(Token Endpoint)的安全约束.
	 * @param oauthServer
	 * @throws Exception
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.realm(REALM+"/client");
	}

}