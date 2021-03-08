package com.lzz.middleware.listener;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentCacheEventLogger implements CacheEventListener<Object,Object> {

    private static final Logger logger = LoggerFactory.getLogger(StudentCacheEventLogger.class);

    @Override
    public void onEvent(CacheEvent cacheEvent) {
        logger.info("student caching event {} {} {} {}",
                cacheEvent.getType(), cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}