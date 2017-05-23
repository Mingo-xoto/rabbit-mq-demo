package com.yhq.producer.controllers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yhq.support.RabbitTemplateUtil;

/**
 * @author HuaQi.Yang
 * @date 2017年5月19日
 */
@Controller
@RequestMapping("/publish/")
public class MessagePublishController {

	@Autowired
	RabbitTemplateUtil rabbitTemplateUtil;

	@RequestMapping("send")
	public void send() {
		System.out.println("--send--");
	}

	@RequestMapping("sendMsg")
	public void sendMsg(@RequestParam String exchange, @RequestParam(required = false) String routingKey) {
		publish(rabbitTemplateUtil.get(exchange), routingKey, exchange);
	}

	private void publish(RabbitTemplate amqpTemplate, String routingKey, String exchange) {
		String body = "Hello World!";
		// 指定消息发送到的转发器,绑定键值对headers键值对:头交换机
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setHeader("head1", "faker");
		messageProperties.setHeader("head2", "fader");
		Message message = new Message(body.getBytes(), messageProperties);
		amqpTemplate.convertAndSend(exchange, routingKey, message);
	}
}
