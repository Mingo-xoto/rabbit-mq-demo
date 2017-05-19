package com.yhq.producer.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.yhq.config.RabbitConfig;

/**
 * @author HuaQi.Yang
 * @date 2017年5月19日
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 应用上下文，除web部分
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class, RabbitConfig.class };
	}

	/**
	 * web上下文
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MvcConfig.class };
	}

	/**
	 * DispatcherServlet的映射路径
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * 注册过滤器，映射路径与DispatcherServlet一致，
	 * 路径不一致的过滤器需要注册到另外的WebApplicationInitializer中
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter };
	}
}
