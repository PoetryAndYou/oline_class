package com.yantumeijing.oline_class.utils;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 缓存
 */
@Component
public class BaseCache {

    /**
     * 　　1. 大小的设置：CacheBuilder.maximumSize(long) CacheBuilder.weigher(Weigher) CacheBuilder.maxumumWeigher(long)
     * 　　2. 时间：expireAfterAccess(long, TimeUnit) expireAfterWrite(long, TimeUnit)
     * 　　3. 引用：CacheBuilder.weakKeys() CacheBuilder.weakValues() CacheBuilder.softValues()
     * 　　4. 明确的删除：invalidate(key) invalidateAll(keys) invalidateAll()
     * 　　5. 删除监听器：CacheBuilder.removalListener(RemovalListener)
     */
    private Cache<Object, Object> tenMinuteCache = CacheBuilder.newBuilder()
            //初始大小
            .initialCapacity(10)
            //最大值
            .maximumSize(100)
            //并发数
            .concurrencyLevel(5)
            //过期时间
            .expireAfterWrite(600, TimeUnit.SECONDS)
            //命中率
            .recordStats()
            .build();

    public Cache<Object, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }

    public void setTenMinuteCache(Cache<Object, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }
}

