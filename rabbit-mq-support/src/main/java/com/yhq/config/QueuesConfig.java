package com.yhq.config;

import java.util.ArrayList;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaQi.Yang
 * @date 2017年5月22日
 */
@Configuration
public class QueuesConfig {
	ArrayList<Queue> queues = new ArrayList<Queue>();

	@Bean
	public Queue queue1() {
		Queue queue = new Queue("my-topic-queue1", true);
		queues.add(queue);
		return queue;
	}

	@Bean
	public Queue queue2() {
		Queue queue = new Queue("my-topic-queue2", true);
		queues.add(queue);
		return queue;
	}

	@Bean
	public Queue queue3() {
		Queue queue = new Queue("my-head-queue1", true);
		queues.add(queue);
		return queue;
	}

	@Bean
	public Queue queue4() {
		Queue queue = new Queue("my-head-queue2", true);
		queues.add(queue);
		return queue;
	}

	@Bean
	public Queue queue5() {
		Queue queue = new Queue("my-direct-queue1", true);
		queues.add(queue);
		return queue;
	}

	@Bean
	public Queue queue6() {
		Queue queue = new Queue("my-direct-queue2", true);
		queues.add(queue);
		return queue;
	}

	@Bean
	public Queue queue7() {
		Queue queue = new Queue("my-fanout-queue1", true);
		queues.add(queue);
		return queue;
	}

	@Bean
	public Queue queue8() {
		Queue queue = new Queue("my-fanout-queue2", true);
		queues.add(queue);
		return queue;
	}

	@Bean
	public ArrayList<Queue> queues() {
		return queues;
	}
}
