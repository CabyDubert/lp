package com.lp.core.cache;


import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MybatisRedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    //这里需要静态注入
    private static JedisConnectionFactory jedisConnectionFactory;

    private final String id;
    // 读写锁
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug("MybatisRedisCache:id=" + id);
        this.id = id;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
//      logger.info("id是：" + this.id);
//      logger.info(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"="+value);
        RedisConnection connection = jedisConnectionFactory.getConnection();
        //借用spring_data_redis.jar中的JdkSerializationRedisSerializer.class
        RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
        //利用其序列化方法将数据写入redis服务的缓存中
        connection.set(Objects.requireNonNull(serializer.serialize(key)), Objects.requireNonNull(serializer.serialize(value)));
        connection.close();
    }

    @Override
    public Object getObject(Object key) {
        RedisConnection connection = jedisConnectionFactory.getConnection();
        //借用spring_data_redis.jar中的JdkSerializationRedisSerializer.class
        RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
        //利用其反序列化方法获取值
        Object result = serializer.deserialize(connection.get(Objects.requireNonNull(serializer.serialize(key))));
        connection.close();
        return result;
    }

    @Override
    public Object removeObject(Object key) {
        RedisConnection connection = jedisConnectionFactory.getConnection();
        RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
        Object result = connection.expire(Objects.requireNonNull(serializer.serialize(key)), 0);
        connection.close();
        return result;
    }

    @Override
    public void clear() {
        RedisConnection connection = jedisConnectionFactory.getConnection(); //连接清除数据
        connection.flushDb();
        connection.flushAll();
        connection.close();
    }

    @Override
    public int getSize() {
        RedisConnection connection = jedisConnectionFactory.getConnection();
        int result = Integer.parseInt(Objects.requireNonNull(connection.dbSize()).toString());
        connection.close();
        return result;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        MybatisRedisCache.jedisConnectionFactory = jedisConnectionFactory;
        int a = 1;
    }
}
