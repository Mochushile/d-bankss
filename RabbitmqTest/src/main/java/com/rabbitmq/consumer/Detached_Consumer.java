package com.rabbitmq.consumer;

public class Detached_Consumer {
	public void listen(String foo){
		System.out.println("detached_consumer 接受消息是："+foo);
	}
}
