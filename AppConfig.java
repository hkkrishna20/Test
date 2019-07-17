package com.concretepage; 
import java.util.Arrays;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
  
@Configuration
@ComponentScan("com.concretepage")
@EnableCaching
public class AppConfig  {
    @Bean
    public CacheManager cacheManager() {
       SimpleCacheManager cacheManager = new SimpleCacheManager();
       Cache cache = new ConcurrentMapCache("mycache");
       cacheManager.setCaches(Arrays.asList(cache));
       return cacheManager;
    }
}  
 