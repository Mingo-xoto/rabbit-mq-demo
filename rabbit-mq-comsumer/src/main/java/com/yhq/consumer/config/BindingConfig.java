package com.yhq.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.HeadersExchangeMapConfigurer.HeadersExchangeMapBindingCreator;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.yhq.config.ExchangeConfig;
import com.yhq.config.QueuesConfig;

/**
 * @author HuaQi.Yang
 * @date 2017年5月22日
 */
@Configuration
@Import({ QueuesConfig.class, ExchangeConfig.class })
public class BindingConfig {

	@Bean
	public Binding bind1(Queue queue1, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue1).to(topicExchange).with("#.my-topic-queue1.#");
	}

	@Bean
	public Binding bind2(Queue queue2, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue2).to(topicExchange).with("#.my-topic-queue2.#");
	}

	@Bean
	public HeadersExchangeMapBindingCreator bind3(Queue queue3, HeadersExchange headExchange) {
		Map<String, Object> headerValues = new HashMap<>();
		headerValues.put("head1", "faker");
		headerValues.put("head2", "fader");
		return BindingBuilder.bind(queue3).to(headExchange).whereAll(headerValues);
	}

	@Bean
	public HeadersExchangeMapBindingCreator bind4(Queue queue4, HeadersExchange headExchange) {
		Map<String, Object> headerValues = new HashMap<>();
		headerValues.put("head2", "saber");
		return BindingBuilder.bind(queue4).to(headExchange).whereAll(headerValues);
	}

	@Bean
	public HeadersExchangeMapBindingCreator bindAll3(Queue queue3, HeadersExchange headAllExchange) {
		Map<String, Object> headerValues = new HashMap<>();
		headerValues.put("head1", "faker");
		headerValues.put("head2", "fader");
		return BindingBuilder.bind(queue3).to(headAllExchange).whereAll(headerValues);
	}

	@Bean
	public HeadersExchangeMapBindingCreator bindAll4(Queue queue4, HeadersExchange headAllExchange) {
		Map<String, Object> headerValues = new HashMap<>();
		headerValues.put("head2", "saber");
		return BindingBuilder.bind(queue4).to(headAllExchange).whereAll(headerValues);
	}

	@Bean
	public Binding bind5(Queue queue5, DirectExchange directExchange) {
		return BindingBuilder.bind(queue5).to(directExchange).with("my-head-queue-key1");
	}

	@Bean
	public Binding bind6(Queue queue6, DirectExchange directExchange) {
		return BindingBuilder.bind(queue6).to(directExchange).with("my-head-queue-key2");
	}

	@Bean
	public Binding bind7(Queue queue7, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queue7).to(fanoutExchange);
	}

	@Bean
	public Binding bind8(Queue queue8, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queue8).to(fanoutExchange);
	}
}
