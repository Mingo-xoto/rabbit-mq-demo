package com.yhq.consumer.controllers;

import java.util.Collection;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yhq.support.RabbitTemplateUtil;

/**
 * @author HuaQi.Yang
 * @date 2017年5月19日
 */
@Controller
@RequestMapping("/receiver/")
public class MessageReceiverController {

	@Autowired
	RabbitTemplateUtil rabbitTemplateUtil;

	@RequestMapping("receive")
	public void receive() {
		System.out.println("--receive--");
	}

	@RequestMapping("receiveMsg")
	public ModelMap receiveMsg(@RequestParam String exchange, @RequestParam(required = false) String queue) {
		ModelMap map = new ModelMap();
		RabbitTemplate template = rabbitTemplateUtil.get(exchange);
		if (queue == null) {
			Collection<String> queueNames = template.expectedQueueNames();
			if (queueNames == null) {
				return map;
			}
			for (String queueName : queueNames) {
				map.put(queueName, template.receive(queueName));
			}
		} else {
			map.put(queue, template.receive(queue));
		}
		return map;
	}
}
