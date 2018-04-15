package com.rabbitmq.consumer;

public class Foo_Consumer {
	public void listen(String foo){
		System.out.println("spring 接受消息是："+foo);
	}
}
