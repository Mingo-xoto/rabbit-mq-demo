package com.yhq.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaQi.Yang
 * @date 2017年5月22日
 */
@Configuration
public class ExchangeConfig {

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("my-topic-exchange");
	}

	@Bean
	public HeadersExchange headExchange() {
		return new HeadersExchange("my-head-exchange");
	}

	@Bean
	public HeadersExchange headAllExchange() {
		return new HeadersExchange("my-head-all-exchange");
	}

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("my-direct-exchange");
	}

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("my-fanout-exchange");
	}
}
