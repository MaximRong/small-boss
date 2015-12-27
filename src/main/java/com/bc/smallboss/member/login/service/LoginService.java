package com.bc.smallboss.member.login.service;

import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.common.bean.User;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class LoginService {

    public Map login(String mobile, String password, String type, HttpSession session) {
        User user = new Eql().selectFirst("queryUserByMobile").params(RMap.asMap("mobile", mobile, "type", type)).returnType(User.class).execute();
        if(null == user) {
            return RMap.asMap("result", "null");
        }
        if(!password.equals(user.getPasswd())) {
            return RMap.asMap("result", "notRight");
        }
        session.setAttribute("user", user);
//        OAuthInfo.set(user);
        return RMap.asMap("result", "ok");
    }
}
