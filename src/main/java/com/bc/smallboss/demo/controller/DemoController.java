package com.bc.smallboss.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
