package com.bjsxt.redis;

import redis.clients.jedis.Jedis;

public class JedisTest {

	public static void main(String[] args) {
		//创建客户端 设置ip和端口号
		Jedis jedis = new Jedis("127.0.0.1",6379);
		//设置密码
//		jedis.auth("");
		//设置值
		jedis.set("name", "java知识分享网");
		//获取值
		String value = jedis.get("name");
		System.out.println(value);
		//释放连接资源
		jedis.close();
	}
}
