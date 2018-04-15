package com.rabbitmq.producer;

import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Spring_Producer {
	private ApplicationContext applicationContext;
	@Before
	public void init (){
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/rabbitmq-context.xml");
	}
	@Test
	public void redisClient1() throws Exception{
		//获取RabbitMq模板
		RabbitTemplate template = applicationContext.getBean(RabbitTemplate.class);
		//发送消息
		for(int i = 0 ; i < 20 ; i++){
		template.convertAndSend("Spring,hello!!!"+i);
		Thread.sleep(1000);
		}
	}
}
