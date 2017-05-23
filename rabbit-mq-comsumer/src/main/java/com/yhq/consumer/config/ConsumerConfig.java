package com.yhq.consumer.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.yhq.config.RabbitConfig;
import com.yhq.propertys.Propertys;

/**
 * 注意import顺序，由于RabbitConfig里面的一些属性值需要由Propertys注入，因此需要先引入Propertys
 * 
 * @author HuaQi.Yang
 * @date 2017年5月22日
 */
@Configuration
@Import(value = { Propertys.class, RabbitConfig.class })
public class ConsumerConfig extends RabbitConfig {

	/**
	 * 创建rabbitAdmin代理
	 * 
	 * @author HuaQi.Yang
	 * @date 2017年5月22日
	 * @return
	 */
	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}
	
	//
	// @Bean
	// public SimpleMessageListenerContainer listenerContainer() {
	// SimpleMessageListenerContainer container = new
	// SimpleMessageListenerContainer();
	// container.setConnectionFactory(connectionFactory());
	// container.addQueues(queue1());
	// container.addQueues(queue2());
	// container.addQueues(queue3());
	// container.setMessageListener(new MessageListenerAdapter(converter()));
	// return container;
	// }
}
