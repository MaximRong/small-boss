package com.bc.smallboss.merchant.index.controller;


import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.booking.bean.BookingDate;
import com.bc.smallboss.member.booking.bean.Subscribe;
import com.bc.smallboss.merchant.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/merchant/home")
public class IndexController {

    @Autowired
    private IndexService service;

    @RequestMapping(value = "/show")
    public ModelAndView staffEdit(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        List<Subscribe> subscribes = service.querySubscribes((User) session.getAttribute("user"));
        List<BookingDate> dates = service.createBookingDates();
        mav.addObject("subscribes", subscribes);
        mav.addObject("dates", dates);

        mav.setViewName("merchant/home-page");
        return mav;
    }
}
