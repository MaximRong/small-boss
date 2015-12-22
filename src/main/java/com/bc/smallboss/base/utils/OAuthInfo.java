package com.bc.smallboss.base.utils;


import com.bc.smallboss.common.bean.User;

public class OAuthInfo {
    public static final ThreadLocal userThreadLocal = new ThreadLocal();

    public static boolean set(User user) {
        userThreadLocal.set(user);
        return true;
    }

    public static void unset() {
        userThreadLocal.remove();
    }

    public static User get() {
        User user = (User) userThreadLocal.get();
        if(null == user) {
            user = new User();
            user.setUserId(131306720934438912l);
        }
        return  user;
    }
}
