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
	
	@Bean
	public ArrayList<Queue> queues(){
		ArrayList<Queue> queues = new ArrayList<Queue>();
		queues.add(queue1());
		queues.add(queue2());
		queues.add(queue3());
		queues.add(queue4());
		queues.add(queue5());
		queues.add(queue6());
		queues.add(queue7());
		queues.add(queue8());
		return queues;
	}
}
