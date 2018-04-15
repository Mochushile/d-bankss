package com.rabbitmq.utils;

import java.io.IOException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectUtil {
	public static Connection getConnection() throws Exception{
		//设置连接
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setPort(5672);
		factory.setVirtualHost("/taotao");
		factory.setUsername("taotao");
		factory.setPassword("taotao");
		Connection con = factory.newConnection();
		return con;
	}
}
