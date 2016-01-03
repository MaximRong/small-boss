package com.bc.smallboss.member.register.controller;

import com.bc.smallboss.member.register.bean.Member;
import com.bc.smallboss.member.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/member/register")
public class RegisterController {

    @Autowired
    private RegisterService service;

    @RequestMapping(value = "/show")
    public String registerShow() {
        return "member/register";
    }

    @RequestMapping(value = "/register")
    public @ResponseBody
    Map register(@RequestBody Member member, HttpSession session) {
        return service.register(member, session);
    }
}
