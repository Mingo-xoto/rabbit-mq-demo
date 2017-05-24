package com.yhq.consumer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author HuaQi.Yang
 * @date 2017年5月19日
 */
@Configuration
@ComponentScan(basePackages = "com.yhq.consumer", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class))
// @ImportResource({ "classpath:consumer.xml" })
@Import(ConsumerConfig.class)
public class RootConfig {

}
