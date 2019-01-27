package com.pawpaw.fishinghome.usercenter.controller.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pawpaw.common.webmvc.ApiRespFeignDeocder;
import com.pawpaw.fishinghome.usercenter.controller.IUserWebService;

import feign.Client;
import feign.Feign;
import feign.Feign.Builder;

@Configuration
public class UserCenterConfiguration {
	/**
	 * 实现此服务名的服务设置的 spring.application.name的值
	 */
	public static final String SERVICE_NAME = "user-center";

	@Bean
	@ConditionalOnMissingBean
	public IUserWebService getWebService(@Autowired Client client) {
		Builder builder = Feign.builder();
		builder.decoder(new ApiRespFeignDeocder());
		builder.client(client);
		builder.contract(new SpringMvcContract());
		IUserWebService service = builder.target(IUserWebService.class, "http://" + SERVICE_NAME + "/");
		return service;
	}

}
