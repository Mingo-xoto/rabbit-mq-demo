package com.yhq.consumer.config;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.yhq.config.RabbitConfig;
import com.yhq.consumer.listeners.QueueListener;
import com.yhq.propertys.Propertys;

/**
 * 注意import顺序，由于RabbitConfig里面的一些属性值需要由Propertys注入，因此需要先引入Propertys
 * 
 * @author HuaQi.Yang
 * @date 2017年5月22日
 */
@Configuration
@Import(value = { Propertys.class, RabbitConfig.class })
public class ConsumerConfig {

	/**
	 * 创建rabbitAdmin代理
	 * 
	 * @author HuaQi.Yang
	 * @date 2017年5月22日
	 * @return
	 */
	@Bean
	public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	/**
	 * 消息监听容器
	 * 
	 * @author HuaQi.Yang
	 * @date 2017年5月24日
	 * @param queues
	 * @param queueListener
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer listenerContainer(ConnectionFactory connectionFactory,
			ArrayList<Queue> queues, QueueListener queueListener) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addQueues(queues.toArray(new Queue[queues.size()]));
		MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(queueListener);
		Method methods[] = queueListener.getClass().getMethods();
		Map<String, String> methodNamesMap = new HashMap<>();
		for (Method method : methods) {
			methodNamesMap.put(method.getName().replaceAll("Listen", ""), method.getName());
		}
		Map<String, String> queueOrTagToMethodName = new HashMap<>();
		for (Queue queue : queues) {
			queueOrTagToMethodName.put(queue.getName(), methodNamesMap.get(queue.getName().split("-")[1]));
		}
		messageListenerAdapter.setQueueOrTagToMethodName(queueOrTagToMethodName);
		container.setMessageListener(messageListenerAdapter);
		return container;
	}
}
