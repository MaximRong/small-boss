package com.bc.smallboss.base.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Logger logger = LoggerFactory.getLogger(ResUtils.class);

    private static final LoadingCache<String, String> configCache = CacheBuilder.newBuilder().build(
            new CacheLoader<String, String>() {
                @Override
                public  String load(String key) {
                    // 获取配置文件
                    Resource resource = ResUtils.getResource("config.properties");
                    Properties properties = new Properties();
                    try {
                        // 加载配置文件
                        properties.load(resource.getInputStream());
                        properties.getProperty(key);

                    } catch (IOException e) {
                        logger.error("load config key " + key+ " failed " , e);
                    }
                    return properties.getProperty(key);
                }
            });

    // 获取配置文件
    public static String getString(String key) {
        // 根据key返回对应的value值
        return configCache.getUnchecked(key);
    }
}
