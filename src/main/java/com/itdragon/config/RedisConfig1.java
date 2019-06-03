package com.itdragon.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Set;
//
//@Configuration
//@EnableCaching
public class RedisConfig1 extends CachingConfigurerSupport {
    @Value("${redis.redisPoolMaxActive}")
    private int redisPoolMaxActive;
    @Value("${redis.redisPoolMaxIdle}")
    private int redisPoolMaxIdle;
    @Value("${redis.redisPoolMinIdle}")
    private int redisPoolMinIdle;
    @Value("${redis.redisPoolMaxWait}")
    private int redisPoolMaxWait;
    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    //连接池配置
    public JedisPoolConfig poolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisPoolMaxIdle);
        poolConfig.setMaxTotal(redisPoolMaxActive);
        poolConfig.setMaxWaitMillis(redisPoolMaxWait);
        poolConfig.setMinIdle(redisPoolMinIdle);
        poolConfig.setTestOnBorrow(testOnBorrow);
        return poolConfig;
    }

    //2.0版本以上需要这样配置连接池等配置
    public JedisClientConfiguration.JedisClientConfigurationBuilder getJedisClientConfigurationBuilder(JedisPoolConfig poolConfig, long connectTimeOut, long readTimeOut){
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfigurationBuilder = JedisClientConfiguration.builder();
        jedisClientConfigurationBuilder.connectTimeout(Duration.ofMillis(connectTimeOut));//  connection timeout
        jedisClientConfigurationBuilder.readTimeout(Duration.ofMillis(readTimeOut));
        jedisClientConfigurationBuilder.usePooling().poolConfig(poolConfig);
        return jedisClientConfigurationBuilder;
    }

    //2.0版本以上配置连接地址方式
    public RedisStandaloneConfiguration getRedisStandaloneConfiguration(String hostName, int port,
                                                                        String password, int index){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(hostName, port);
        if(StringUtils.isNotBlank(password)){
            redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        }
        if (index != 0) {
            redisStandaloneConfiguration.setDatabase(index);
        }
        return redisStandaloneConfiguration;
    }

    public RedisSentinelConfiguration getRedisSentinelConfiguration(String masterName, Set<String> sentinelHostAndPorts, String password, int database){
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration(masterName,sentinelHostAndPorts);
        redisSentinelConfiguration.setDatabase(database);
        redisSentinelConfiguration.setPassword(RedisPassword.of(password));
        return redisSentinelConfiguration;
    }


    //2.0以上版本配置连接工厂
    public RedisConnectionFactory connectionFactory(String hostName, int port,
                                                    String password, int index, JedisPoolConfig poolConfig, long connectTimeOut, long readTimeOut) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(getRedisStandaloneConfiguration(hostName,port,password,index), getJedisClientConfigurationBuilder(poolConfig,connectTimeOut,readTimeOut).build());
        // 初始化连接pool
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

    //2.0以上版本配置连接工厂
    public RedisConnectionFactory connectionSentinelFactory(String masterName, Set<String> sentinelHostAndPorts, String password, int database, JedisPoolConfig poolConfig, long connectTimeOut, long readTimeOut) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(getRedisSentinelConfiguration(masterName, sentinelHostAndPorts, password, database), getJedisClientConfigurationBuilder(poolConfig,connectTimeOut,readTimeOut).build());
        // 初始化连接pool
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

    //自定义keyGenerator必须实现org.springframework.cache.interceptor.KeyGenerator接口
    @Bean
    public KeyGenerator accountKeyGenerator() {
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                //first parameter is caching object
                //second paramter is the name of the method, we like the caching key has nothing to do with method name
                //third parameter is the list of parameters in the method being called
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    public ValueOperations<String, String> valueOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForValue();
    }

    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }

    public int getRedisPoolMaxActive() {
        return redisPoolMaxActive;
    }

    public void setRedisPoolMaxActive(int redisPoolMaxActive) {
        this.redisPoolMaxActive = redisPoolMaxActive;
    }

    public int getRedisPoolMaxIdle() {
        return redisPoolMaxIdle;
    }

    public void setRedisPoolMaxIdle(int redisPoolMaxIdle) {
        this.redisPoolMaxIdle = redisPoolMaxIdle;
    }

    public int getRedisPoolMinIdle() {
        return redisPoolMinIdle;
    }

    public void setRedisPoolMinIdle(int redisPoolMinIdle) {
        this.redisPoolMinIdle = redisPoolMinIdle;
    }

    public int getRedisPoolMaxWait() {
        return redisPoolMaxWait;
    }

    public void setRedisPoolMaxWait(int redisPoolMaxWait) {
        this.redisPoolMaxWait = redisPoolMaxWait;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }
}