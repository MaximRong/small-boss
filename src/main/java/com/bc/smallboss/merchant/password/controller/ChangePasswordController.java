package com.bc.smallboss.merchant.password.controller;

import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.merchant.password.service.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/merchant/change-password")
public class ChangePasswordController {

    @Autowired
    private ChangePasswordService service;

    @RequestMapping(value = "/show")
    public String show() {
        return "merchant/change-password";
    }

    @RequestMapping(value = "/change")
    @ResponseBody
    public Map changePassword(@RequestParam String password) {
        service.changePassword(password);
        return RMap.of("result", "ok");
    }


}