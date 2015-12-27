package com.bc.smallboss.member.subscribe.controller;


import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.booking.bean.Subscribe;
import com.bc.smallboss.member.register.bean.Member;
import com.bc.smallboss.member.subscribe.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member/subscribe")
public class SubscribeController {
    @Autowired
    private SubscribeService service;


    @RequestMapping(value = "/show")
    public ModelAndView subscribeShow(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Member member = service.queryMember((User)session.getAttribute("user"));
        List<Subscribe> subscribes = service.querySubscibes(member.getMemberId());
        mav.addObject("member", member);
        mav.addObject("subscribes", subscribes);
        mav.setViewName("member/subscribe");
        return mav;
    }

    @RequestMapping(value = "/cancel")
    @ResponseBody
    public Map subscribeCancel(@RequestParam(value = "subscribeId") String subscribeId,
                               HttpSession session) {
        Map ret ;
        try {
            service.subscribeCancel(subscribeId, (User) session.getAttribute("user"));
            ret = RMap.asMap("result", "ok");
        } catch (Exception e) {
            ret = RMap.asMap("result", "error");
        }

        return ret;
    }



}
