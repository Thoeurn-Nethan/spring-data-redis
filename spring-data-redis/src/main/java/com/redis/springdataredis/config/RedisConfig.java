package com.redis.springdataredis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
@EnableCaching
@EnableRedisRepositories
public class RedisConfig{

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration= new RedisStandaloneConfiguration();
        // redis cloud url (full url also include port : redis-13738.c8.us-east-1-4.ec2.cloud.redislabs.com:13738)
        // redisStandaloneConfiguration.setHostName("redis-13738.c8.us-east-1-4.ec2.cloud.redislabs.com");
        // redisStandaloneConfiguration.setPort(13738);// redis cloud port 
        // redisStandaloneConfiguration.setPassword("v32QwpFeUsqTHKjqxVuEvexwHRh0zLhi");

        redisStandaloneConfiguration.setHostName("172.30.15.74");
        redisStandaloneConfiguration.setPort(16993);
        redisStandaloneConfiguration.setPassword("4t50Q5Na");
        JedisConnectionFactory jedisConnectionFactory= new JedisConnectionFactory(redisStandaloneConfiguration);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(){

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        
        // set connection to redis server
        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        // set key serializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        
         redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}