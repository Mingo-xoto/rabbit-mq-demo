package com.yhq.mq;

import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自动注解获取rabbitTemplate映射集:key值为对应rabbitTemplate的id
 * 
 * @author HuaQi.Yang
 * @date 2017年5月18日
 */
@Component
public class AutoWriteRabbitUtil {

	@Autowired
	private Map<String, RabbitTemplate> autoMap;

	public RabbitTemplate get(String key) {
		RabbitTemplate template = autoMap.get(key);
		return template;
	}

}
