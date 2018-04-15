package com.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.utils.ConnectUtil;

public class Producer_Work {
	private static String QUEUE_NAME = "test_queue_work";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//获得连接
		Connection con =  ConnectUtil.getConnection();
		//获得通道
		Channel channel = con.createChannel();
		//声明创建队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		//同一时刻只给消费者发送一条
//		channel.basicQos(1);
		//消息内容
		int i = 0;
		while(i<50){
			String message = "hello "+i;
			//发送消息队列
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			//发送成功，打印发送信息
			System.out.println("生产者发送消息是："+message);
			i++;
			Thread.sleep(i*10);
		}
		//关闭通道和连接
		channel.close();
		con.close();
	}

}
