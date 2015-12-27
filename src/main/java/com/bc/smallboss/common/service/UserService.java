package com.bc.smallboss.common.service;

import com.bc.smallboss.common.bean.User;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User queryUserByUserId(String userId) {
        return new Eql().selectFirst("queryUserByUserId").params(userId).returnType(User.class).execute();
    }
}
