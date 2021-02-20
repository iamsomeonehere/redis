package com.example.redis.practice.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author rishi - created on 08/02/21
 **/
@Configuration
public class RedisConfig {

  @Bean
  @Primary
  public CacheManager cacheManager(LettuceConnectionFactory redisConnectionFactory) {
    RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration
        .defaultCacheConfig()
        .serializeValuesWith(RedisSerializationContext
            .SerializationPair
            .fromSerializer(new GenericJackson2JsonRedisSerializer()))
        .entryTtl(Duration.ofHours(2));
    return RedisCacheManager
        .builder(redisConnectionFactory)
        .cacheDefaults(cacheConfiguration)
        .build();
  }

  @Bean("cacheManager1")
  public CacheManager cacheManager1(LettuceConnectionFactory redisConnectionFactory) {
    RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration
        .defaultCacheConfig()
        .serializeValuesWith(RedisSerializationContext
            .SerializationPair
            .fromSerializer(new GenericJackson2JsonRedisSerializer()))
        .entryTtl(Duration.ofSeconds(10));
    return RedisCacheManager
        .builder(redisConnectionFactory)
        .cacheDefaults(cacheConfiguration)
        .build();
  }

  @Bean
  @ConditionalOnMissingBean(name = "redisTemplate")
  @Primary
  public <K, V> RedisTemplate<K, V> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
    RedisTemplate<K, V> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    return template;
  }

  @Bean(value = "customKeyGenerator")
  public KeyGenerator keyGenerator() {
    return new CustomKeyGenerator();
  }
}
