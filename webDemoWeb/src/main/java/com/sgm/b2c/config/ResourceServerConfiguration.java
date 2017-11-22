package com.sgm.b2c.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * 资源服务器
 * 可以和授权服务在同一个应用中，
 * 当然也可以分离开成为两个不同的应用程序
 * 提供一些受token令牌保护的资源，
 * Spring OAuth提供者是通过Spring Security authentication filter 即验证过滤器来实现的保护
 *
 * @author Li B
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	/**
	 * 	这个资源服务的ID，这个属性是可选的，但是推荐设置并在授权服务中进行验证
	 */
	private static final String RESOURCE_ID = "my_rest_api";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
				anonymous().disable()
				.requestMatchers().antMatchers("/user*/**")
				.and().authorizeRequests()
				.antMatchers("/user*/**").permitAll()
				.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}