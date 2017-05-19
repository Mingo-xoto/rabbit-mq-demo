package com.yhq.mq;

import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * xml配置获取rabbitTemplate映射集:可以自定义key值
 * 
 * @author HuaQi.Yang
 * @date 2017年5月18日
 */
public class RabbitTemplateUtil {

	private Map<String, RabbitTemplate> rabbitTemplateMap;

	public RabbitTemplate get(String key) {
		RabbitTemplate template = rabbitTemplateMap.get(key);
		return template;
	}

	public Map<String, RabbitTemplate> getRabbitTemplateMap() {
		return rabbitTemplateMap;
	}

	public void setRabbitTemplateMap(Map<String, RabbitTemplate> rabbitTemplateMap) {
		this.rabbitTemplateMap = rabbitTemplateMap;
	}

}
