package com.bc.smallboss.member.login.controller;

import com.bc.smallboss.member.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/member/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping(value = "/show")
    public String bookingShow() {
        return "member/login";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map bookingSave(@RequestParam(value = "mobile") String mobile,
                            @RequestParam(value = "password") String password) {
        return service.login(mobile, password);
    }


}
