package com.bc.smallboss.merchant.index.controller;


import com.bc.smallboss.base.utils.OAuthInfo;
import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.booking.bean.BookingDate;
import com.bc.smallboss.merchant.index.bean.StaffSubscribe;
import com.bc.smallboss.merchant.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/merchant/home")
public class IndexController {

    @Autowired
    private IndexService service;

    @RequestMapping(value = "/show")
    public ModelAndView staffEdit() {
        ModelAndView mav = new ModelAndView();
        User user = OAuthInfo.get();

        List<StaffSubscribe> subscribes = service.querySubscribes(user);
        List<BookingDate> dates = service.createBookingDates();
        mav.addObject("subscribes", subscribes);
        mav.addObject("dates", dates);

        mav.setViewName("merchant/home-page");
        return mav;
    }

    @RequestMapping(value = "/cancel")
    @ResponseBody
    public Map subscribeCancel(@RequestParam(value = "subscribeId") String subscribeId) {
        Map ret ;
        try {
            service.subscribeCancel(subscribeId);
            ret = RMap.asMap("result", "ok");
        } catch (Exception e) {
            ret = RMap.asMap("result", "error");
        }

        return ret;
    }


}
