package com.yhq.consumer.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author HuaQi.Yang
 * @date 2017年5月18日
 */
@Component
@RabbitListener(queues = { "my-head-queue1", "my-head-queue2", "my-topic-queue1", "my-topic-queue2",
		"my-fanout-queue1" })
public class QueueListener {

	public void listen1(Object body) {
		byte[] messages = (byte[]) body;
		System.out.println("listen1:" + new String(messages));
	}

	public void listen2(Object body) {
		byte[] messages = (byte[]) body;
		System.out.println("listen2:" + new String(messages));
	}

	public void listen3(Object body) {
		byte[] messages = (byte[]) body;
		System.out.println("listen3:" + new String(messages));
	}

	public void listen4(Object body) {
		byte[] messages = (byte[]) body;
		System.out.println("listen4:" + new String(messages));
	}
}
