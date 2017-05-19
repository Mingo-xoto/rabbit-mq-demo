package com.yhq.producer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author HuaQi.Yang
 * @date 2017年5月19日
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.yhq.producer.controllers", useDefaultFilters = false, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class) })
public class MvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * 增加默认的url跳转（无需经过controller）
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	/**
	 * 视图解析器
	 */
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/mypages/", ".jsp");
		// 启用内容裁决视图解析器
		registry.enableContentNegotiation(new MappingJackson2JsonView());
	};

	/**
	 * 配置内容裁决参数
	 */
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		/* 是否通过请求Url的扩展名来决定media type */
		configurer.favorPathExtension(true)
				/* 不检查Accept请求头 */
				.ignoreAcceptHeader(true)
				/* 请求类型参数名称 */
				.parameterName("mediaType")
				/* 设置默认的media yype */
				.defaultContentType(MediaType.TEXT_HTML)
				/* 请求以.html结尾的会被当成MediaType.TEXT_HTML */
				.mediaType("html", MediaType.TEXT_HTML)
				/* 请求以.json结尾的会被当成MediaType.APPLICATION_JSON */
				.mediaType("json", MediaType.APPLICATION_JSON);
	}

	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// super.addResourceHandlers(registry);
	// registry.addResourceHandler("/images/**").addResourceLocations("/images/");
	// }

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// 调用了enable()方法即可不用重写addResourceHandlers配置静态资源文件的映射管理
		configurer.enable();
	}
}
