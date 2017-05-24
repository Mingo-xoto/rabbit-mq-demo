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

	@Bean
	public Jackson2JsonMessageConverter converter() {
		Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
		return jackson2JsonMessageConverter;
	}

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
		return createRabbitTemplate("my-topic-exchange", "topic-key");
	}

	@Bean
	public RabbitTemplate headTemplate() {
		return createRabbitTemplate("my-head-exchange", "head-key");
	}

	@Bean
	public RabbitTemplate headAllTemplate() {
		return createRabbitTemplate("my-head-all-exchange", "head-all-key");
	}

	@Bean
	public RabbitTemplate directTemplate() {
		return createRabbitTemplate("my-direct-exchange", "direct-key");
	}

	@Bean
	public RabbitTemplate fanoutTemplate() {
		return createRabbitTemplate("my-topic-exchange", "topic-key");
	}

	private RabbitTemplate createRabbitTemplate(String exchange, String routingKey) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		rabbitTemplate.setMessageConverter(converter());
		rabbitTemplate.setExchange(exchange);
		rabbitTemplate.setRoutingKey(routingKey);
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
}
