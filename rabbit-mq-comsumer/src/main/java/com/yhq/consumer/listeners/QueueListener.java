package com.yhq.consumer.listeners;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.yhq.config.QueuesConfig;

/**
 * @author HuaQi.Yang
 * @date 2017年5月18日
 */
@Component
@Import(QueuesConfig.class)
public class QueueListener {

	public void headListen(Object body) {
		byte[] messages = (byte[]) body;
		System.out.println("headListen:" + new String(messages));
	}

	public void topicListen(Object body) {
		byte[] messages = (byte[]) body;
		System.out.println("topicListen:" + new String(messages));
	}

	public void fanoutListen(Object body) {
		byte[] messages = (byte[]) body;
		System.out.println("fanoutListen:" + new String(messages));
	}

	public void directListen(Object body) {
		byte[] messages = (byte[]) body;
		System.out.println("directListen:" + new String(messages));
	}

}
