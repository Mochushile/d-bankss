package com.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.utils.ConnectUtil;

public class Publish_Producer {
	private static String EXCHANGE_NAME = "test_exchange_fanout";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//获得连接
		Connection con =  ConnectUtil.getConnection();
		//获得通道
		Channel channel = con.createChannel();
		//声明创建exchange
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		//同一时刻只给消费者发送一条
//		channel.basicQos(1);
		//消息内容
		int i = 0;
		while(i<50){
			String message = "hello "+i;
			//发送消息到交换机
			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
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
