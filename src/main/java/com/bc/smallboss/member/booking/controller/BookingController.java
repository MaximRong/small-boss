package com.bc.smallboss.member.booking.controller;


import com.bc.smallboss.member.booking.bean.BookingDate;
import com.bc.smallboss.member.booking.service.BookingService;
import com.bc.smallboss.merchant.merchant.bean.Merchant;
import com.bc.smallboss.merchant.staff.bean.Staff;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/member/booking")
public class BookingController {
    @Autowired
    private BookingService service;

    @RequestMapping(value = "/show")
    public ModelAndView merchantEdit() {
        ModelAndView mav = new ModelAndView();
        Merchant merchant = service.queryMerchant();
        List<Staff> staffs = service.queryStaffs();
        List<BookingDate> dates = service.createBookingDates(CollectionUtils.isEmpty(staffs) ? "emptyStaffId" : (staffs.get(0).getStaffId() + ""));
        mav.addObject("merchant", merchant);
        mav.addObject("staffs", staffs);
        mav.addObject("dates", dates);

        mav.setViewName("member/booking");
        return mav;
    }
}
