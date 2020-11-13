package com.bytecode.rediscache.rediscache.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Component
public class ClearCache {
    private static final Log logger = LogFactory.getLog(ClearCache.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    CacheManager cacheManager;

    @Scheduled(fixedRate = 5000)
    public void clear(){
        logger.info("The time is now " + dateFormat.format(new Date()) );
        cacheManager.getCache("libros").clear();
    }
}
