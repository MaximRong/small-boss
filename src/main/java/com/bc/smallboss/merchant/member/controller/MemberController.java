package com.bc.smallboss.merchant.member.controller;

import com.bc.smallboss.member.register.bean.Member;
import com.bc.smallboss.merchant.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/merchant/member")
public class MemberController {

    @Autowired
    private MemberService service;

    @RequestMapping(value = "/show")
     public ModelAndView show() {
        ModelAndView mav = new ModelAndView();
        List<Member> members = service.queryMembers();
        mav.addObject("members", members);
        mav.setViewName("merchant/member");
        return mav;
    }

    @RequestMapping(value = "/add-show")
    public String addMemberShow() {
        return "merchant/member-add";
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Map addMember(@RequestBody Member member) {
        return service.addMember(member);
    }

}
