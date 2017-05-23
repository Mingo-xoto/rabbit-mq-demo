package com.yhq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaQi.Yang
 * @date 2017年5月22日
 */
@Configuration
public class QueuesConfig {
	@Bean
	public Queue queue1() {
		return new Queue("my-topic-queue1", true);
	}

	@Bean
	public Queue queue2() {
		return new Queue("my-topic-queue2", true);
	}

	@Bean
	public Queue queue3() {
		return new Queue("my-head-queue1", true);
	}

	@Bean
	public Queue queue4() {
		return new Queue("my-head-queue2", true);
	}

	@Bean
	public Queue queue5() {
		return new Queue("my-direct-queue1", true);
	}

	@Bean
	public Queue queue6() {
		return new Queue("my-direct-queue2", true);
	}

	@Bean
	public Queue queue7() {
		return new Queue("my-fanout-queue1", true);
	}

	@Bean
	public Queue queue8() {
		return new Queue("my-fanout-queue2", true);
	}
}
