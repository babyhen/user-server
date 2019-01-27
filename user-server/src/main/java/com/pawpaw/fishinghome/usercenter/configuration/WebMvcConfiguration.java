package com.pawpaw.fishinghome.usercenter.configuration;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawpaw.common.webmvc.ApiRespMessageConventer;
import com.pawpaw.common.webmvc.PrintRequestDataInterceptor;

/**
 * 增加一些拦截器和对象转换器
 * 
 * @author liujixin
 *
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 对所有路径增加此拦截器
		registry.addInterceptor(new PrintRequestDataInterceptor()).addPathPatterns("/**");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 设置响应的公共字段
		converters.add(0, new ApiRespMessageConventer(new ObjectMapper()));

	}

}
