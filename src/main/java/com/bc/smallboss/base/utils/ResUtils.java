package com.bc.smallboss.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * 资源文件工具类
 */
public class ResUtils {
    private static final Logger logger = LoggerFactory.getLogger(ResUtils.class);

    // 获取到资源路径
    public static String getResourcePath(String resourcePath) {
        Resource resource = getResource(resourcePath);
        try {
            return resource.getFile().getAbsolutePath();
        } catch (IOException e) {
            String loggerMsg = "get ResourcePath error, the Path is " + resourcePath;
            logger.warn(loggerMsg, e);
            throw new RuntimeException(loggerMsg, e);
        }
    }

    // 获取资源文件
    public static Resource getResource(String resourcePath) {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext(new String[]{});
        return appContext.getResource("classpath:" + resourcePath);
    }


}
