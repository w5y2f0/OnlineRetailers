package com.mr.utils;

import java.util.concurrent.TimeUnit;


import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisServer {
	// 注入redis模板
	@Resource(name = "redisTemplate")
	RedisTemplate<String, Object> redisTemplate;

	/**
	 * 从缓存中根据key查找
	 *
	 * @param cacheKey
	 * @return
	 */
	public Object getCacheValue(final String cacheKey) {
		// 使用redistemplate 提供的回调函数去操作缓存-对事务支持
		return redisTemplate.execute(new RedisCallback<Object>() {

			public Object doInRedis(RedisConnection con) throws DataAccessException {
				return con.get(cacheKey.getBytes());
			}
		});

	}

	public Object getCacheObj(final String cacheKey) {
		// 使用redistemplate 提供的回调函数去操作缓存-对事务支持


		Object obj=redisTemplate.execute(new RedisCallback<Object>() {

			public Object doInRedis(RedisConnection con) throws DataAccessException {
				return con.get(cacheKey.getBytes());
			}
		});

		obj= SerializeUtil.deserialize((byte[])obj);


		return obj;

	}

	/**
	 * 设置缓存值
	 *
	 * @param key
	 * @param value
	 */
	public void setCacheValue(final String key, final  byte[] value) {
		// 使用redistemplate 提供的回调函数 获得的 redis连接 去操作缓存-对事务支持
		redisTemplate.execute(new RedisCallback<Object>() {

			public Object doInRedis(RedisConnection con) throws DataAccessException {
				// TODO Auto-generated method stub
				con.set(key.getBytes(), value);
				return null;
			}
		});
	}



	public void setCacheObj(final String key, final  Object obj) {
		// 使用redistemplate 提供的回调函数 获得的 redis连接 去操作缓存-对事务支持
		redisTemplate.execute(new RedisCallback<Object>() {

			public Object doInRedis(RedisConnection con) throws DataAccessException {
				// TODO Auto-generated method stub
				con.set(key.getBytes(), SerializeUtil.serialize(obj));
				return null;
			}
		});
	}


	/**
	 * 设置缓存值并设置有效期
	 *
	 * @param key
	 * @param value
	 */
	public void setCacheValueForTime(final String key,final byte[] value,final long time) {
		redisTemplate.execute(new RedisCallback<Object>() {

			public Object doInRedis(RedisConnection con) throws DataAccessException {
				// TODO Auto-generated method stub
				con.setEx(key.getBytes(), time, value);
				return null;
			}
		});
	}

	/**
	 * 删除key值
	 *
	 * @param key
	 */
	public void delCacheByKey(final String key) {
		redisTemplate.opsForValue().getOperations().delete(key);
		redisTemplate.opsForHash().delete("");
	}

	/**
	 * 获取token的有效期
	 *
	 * @param key
	 */
	public long getExpireTime(final String key) {
		long time = redisTemplate.getExpire(key);
		return time;
	}

	/**
	 * 指定时间类型---秒
	 *
	 * @param key
	 * @return
	 */
	public long getExpireTimeType( String key) {
		long time = redisTemplate.getExpire(key, TimeUnit.SECONDS);
		return time;
	}

	/**
	 *
	 * @param key---分
	 * @return
	 */
	public long getExpireTimeTypeForMin( String key) {
		long time = redisTemplate.getExpire(key, TimeUnit.MINUTES);
		return time;
	}

	/**
	 * 设置一个自增的数据
	 *
	 * @param key
	 * @param growthLength
	 */
	public void testInc(String key, Long growthLength) {
		redisTemplate.opsForValue().increment(key, growthLength);
	}
}
