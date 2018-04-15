package com.rabbitmq.producer;

import com.rabbitmq.client.Connection;
import com.rabbitmq.utils.ConnectUtil;
import com.rabbitmq.client.Channel;
public class Producer1 {
    //队列名称
	private static String QUEUE_NAME = "test_queue";
	public static void main(String[] argv) throws Exception{
		//获得连接
		Connection con =  ConnectUtil.getConnection();
		//获得通道
		Channel channel = con.createChannel();
		//声明创建队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		//消息内容
		String message = "hello world!";
		//发送消息队列
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		//发送成功，打印发送信息
		System.out.println("生产者发送消息是："+message);
		//关闭通道和连接
		channel.close();
		con.close();
		
	}
}
