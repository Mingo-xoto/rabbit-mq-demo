package com.yhq.comsumer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;

/**
 * @author HuaQi.Yang
 * @date 2017年5月19日
 */
@Configuration
@ComponentScan(basePackages = "com.yhq.comsumer", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class))
@ImportResource({ "classpath:comsumer.xml" })
public class RootConfig {

}
