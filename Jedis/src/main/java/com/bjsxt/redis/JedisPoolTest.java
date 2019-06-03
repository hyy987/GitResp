package com.bjsxt.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {

	public static void main(String[] args) {
		JedisPoolConfig cf = new JedisPoolConfig();
		//设置最大连接数
		cf.setMaxTotal(100);
		//设置最大空闲连接数
		cf.setMaxIdle(10);
		JedisPool jp = new JedisPool(cf,"127.0.0.1",6379);
		
		Jedis jedis = null;
		try {
			jedis=jp.getResource();
			jedis.set("name", "这是一个神奇的东西");
			String value = jedis.get("name");
			System.out.println(value);
		
		}catch (Exception e) {
			
		}finally {
			jedis.close();
			jp.close();
		}
		
	}
}
