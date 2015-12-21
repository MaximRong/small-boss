package com.bc.smallboss.merchant.index.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/merchant/home")
public class IndexController {

    @RequestMapping(value = "/show")
    public String staffEdit() {
        return "merchant/home-page";
    }
}
