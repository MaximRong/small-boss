package com.bc.smallboss.base.spring.advice;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by liolay on 15-7-27.
 */
@ControllerAdvice
public class ControllerExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleIOException(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
        logger.error("系统异常", ex);
        if (isAjaxRequest(request)) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            PrintWriter writer = response.getWriter();
            Map<String, Object> errorMsg = Maps.newHashMap();
            errorMsg.put("sysErrorClass", ClassUtils.getShortName(ex.getClass()));
            errorMsg.put("sysErrorMsg", ex.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,errorMsg.toString());
            writer.write(JSON.toJSONString(Maps.newHashMap(errorMsg)));
            writer.flush();
            return null;
        }
        return "common/error";
    }

    /**
     * 判断是否异步请求.
     *
     * @return true异步.
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        return header != null && "XMLHttpRequest".equals(header);
    }
}
