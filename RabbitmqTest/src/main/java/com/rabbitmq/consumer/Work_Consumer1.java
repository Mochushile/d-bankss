package com.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.utils.ConnectUtil;

public class Work_Consumer1 {
	private static String QUEUE_NAME = "test_queue_work";
	public static void main(String[] argv) throws Exception{
		//获得连接
		Connection con =  ConnectUtil.getConnection();
		//获得通道
		Channel channel = con.createChannel();
		//声明创建队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		//同一时刻只给消费者发送一条
		channel.basicQos(2);
		//创建消息者
		QueueingConsumer consumer = new QueueingConsumer(channel); 
		//发送消息队列
		channel.basicConsume(QUEUE_NAME, false, consumer);
		while(true){
			Delivery delivery= consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println("g 消费者接受的消息是："+message);
			Thread.sleep(1000);
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
	}
}
