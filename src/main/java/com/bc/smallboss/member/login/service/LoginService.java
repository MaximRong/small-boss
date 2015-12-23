package com.bc.smallboss.member.login.service;

import com.bc.smallboss.base.utils.OAuthInfo;
import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.common.bean.User;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {

    public Map login(String mobile, String password) {
        User user = new Eql().selectFirst("queryUserByMobile").params(mobile).returnType(User.class).execute();
        if(null == user) {
            return RMap.asMap("result", "null");
        }
        if(!password.equals(user.getPasswd())) {
            return RMap.asMap("result", "notRight");
        }
        OAuthInfo.set(user);
        return RMap.asMap("result", "ok");
    }
}
