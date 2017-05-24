package com.yhq.consumer.listeners;

import java.util.LinkedHashMap;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.yhq.config.QueuesConfig;
import com.yhq.dto.MyMessage;

/**
 * @author HuaQi.Yang
 * @date 2017年5月18日
 */
@Component
@Import(QueuesConfig.class)
public class QueueListener {

	public void headListen(Object body) {
		String prefix = "headListen:";
		show(prefix, body);
	}

	public void topicListen(Object body) {
		String prefix = "topicListen:";
		show(prefix, body);
	}

	public void fanoutListen(Object body) {
		String prefix = "fanoutListen:";
		show(prefix, body);
	}

	public void directListen(Object body) {
		String prefix = "directListen:";
		show(prefix, body);
	}

	private void show(String prefix, Object body) {
		if (body instanceof byte[]) {
			System.out.println(prefix + new String(((byte[]) body)));
		} else if (body instanceof LinkedHashMap) {
			System.out.println(prefix + body);
		} else {
			MyMessage myMessage = (MyMessage) body;
			System.out.println(prefix + new String(myMessage.toString()));
		}
	}

}
