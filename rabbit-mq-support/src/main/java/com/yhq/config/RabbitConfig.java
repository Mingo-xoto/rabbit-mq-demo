package com.yhq.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.rabbitmq.client.AMQP;
import com.yhq.support.RabbitTemplateUtil;

/***
 * 
 * @author HuaQi.Yang
 * @date 2017年5月19日
 */
@Configuration
@Import(QueuesConfig.class)
public class RabbitConfig {

	@Value("${rabbit.host}")
	private String host;
	@Value("${rabbit.username}")
	private String username;
	@Value("${rabbit.password}")
	private String password;
	@Value("${rabbit.port}")
	private String port;

	/**
	 * 连接工厂
	 *
	 * @author HuaQi.Yang
	 * @date 2017年5月22日
	 * @return
	 */
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setPort(AMQP.PROTOCOL.PORT);
		return connectionFactory;
	}

	@Bean
	public RabbitTemplate topicTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		rabbitTemplate.setRoutingKey("topic-key");
		rabbitTemplate.setExchange("my-topic-exchange");
		return rabbitTemplate;
	}

	@Bean
	public RabbitTemplate headTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		rabbitTemplate.setRoutingKey("head-key");
		rabbitTemplate.setExchange("my-head-exchange");
		return rabbitTemplate;
	}

	@Bean
	public RabbitTemplate headAllTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		rabbitTemplate.setRoutingKey("head-all-key");
		rabbitTemplate.setExchange("my-head-all-exchange");
		return rabbitTemplate;
	}

	@Bean
	public RabbitTemplate directTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		rabbitTemplate.setRoutingKey("direct-key");
		rabbitTemplate.setExchange("my-direct-exchange");
		return rabbitTemplate;
	}

	@Bean
	public RabbitTemplate fanoutTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		rabbitTemplate.setRoutingKey("topic-key");
		rabbitTemplate.setExchange("my-topic-exchange");
		return rabbitTemplate;
	}

	@Bean
	public RabbitTemplateUtil rabbitTemplateUtil() {
		Map<String, RabbitTemplate> rabbitTemplateMap = new HashMap<String, RabbitTemplate>();
		rabbitTemplateMap.put("my-direct-exchange", directTemplate());
		rabbitTemplateMap.put("my-topic-exchange", topicTemplate());
		rabbitTemplateMap.put("my-head-exchange", headTemplate());
		rabbitTemplateMap.put("my-head-all-exchange", headAllTemplate());
		rabbitTemplateMap.put("my-fanout-exchange", fanoutTemplate());
		RabbitTemplateUtil rabbitTemplateUtil = new RabbitTemplateUtil();
		rabbitTemplateUtil.setRabbitTemplateMap(rabbitTemplateMap);
		return rabbitTemplateUtil;
	}

	@Bean
	public Jackson2JsonMessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
}
