package com.bc.smallboss.member.subscribe.controller;


import com.bc.smallboss.member.booking.bean.Subscribe;
import com.bc.smallboss.member.register.bean.Member;
import com.bc.smallboss.member.subscribe.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/member/subscribe")
public class SubscribeController {
    @Autowired
    private SubscribeService service;


    @RequestMapping(value = "/show")
    public ModelAndView subscribeShow() {
        ModelAndView mav = new ModelAndView();
        Member member = service.queryMember();
        List<Subscribe> subscribes = service.querySubscibes(member.getMemberId());
        mav.addObject("member", member);
        mav.addObject("subscribes", subscribes);
        mav.setViewName("member/subscribe");
        return mav;
    }

}
