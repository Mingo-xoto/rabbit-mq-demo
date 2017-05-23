package com.yhq.propertys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * property配置文件
 * 
 * @author HuaQi.Yang
 * @date 2017年5月22日
 */
@Configuration
@PropertySource("classpath:rabbitmq.properties")
public class Propertys {

	@Bean
	public PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
