package com.bc.smallboss.merchant.password.service;

import com.bc.smallboss.base.utils.OAuthInfo;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService {

    public void changePassword(String password) {
        new Eql().update("changePassword").params(OAuthInfo.get().getUserId(), password).execute();
    }
}
