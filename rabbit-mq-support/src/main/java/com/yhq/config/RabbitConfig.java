package com.yhq.config;

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
@ComponentScan(basePackages = "com.yhq.**", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class))
@ImportResource({ "classpath:rabbitMq.xml" })
public class RabbitConfig {

}
