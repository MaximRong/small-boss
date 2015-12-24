package com.bc.smallboss.merchant.login.controller;

import com.bc.smallboss.member.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/merchant/login")
public class MerchantLoginController {

    @Autowired
    private LoginService service;

    @RequestMapping(value = "/show")
    public String loginShow() {
        return "merchant/login";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map loginSave(@RequestParam(value = "mobile") String mobile,
                         @RequestParam(value = "password") String password,
                         HttpSession session) {
        return service.login(mobile, password, "B", session);
    }


}
