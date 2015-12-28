package com.bc.smallboss.base.spring;

import com.bc.smallboss.base.utils.Config;
import com.bc.smallboss.base.utils.OAuthInfo;
import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.common.service.UserService;
import com.github.bingoohuang.utils.net.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OAuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        User user = (User)session.getAttribute("user");
        if(null == user && Config.getString("testMode").equals("true")) {
            user = userService.queryUserByUserId(Config.getString("testUserId"));
        }
        OAuthInfo.set(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (Http.isAjax(request))  return;
        modelAndView.addObject("user", OAuthInfo.get());
    }
}
