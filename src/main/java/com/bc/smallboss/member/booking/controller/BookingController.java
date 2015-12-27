package com.bc.smallboss.member.booking.controller;


import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.booking.bean.BookingDate;
import com.bc.smallboss.member.booking.service.BookingService;
import com.bc.smallboss.merchant.merchant.bean.Merchant;
import com.bc.smallboss.merchant.staff.bean.Staff;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member/booking")
public class BookingController {
    @Autowired
    private BookingService service;

    @RequestMapping(value = "/show")
    public ModelAndView bookingShow() {
        return getModelAndView(null);
    }

    @RequestMapping(value = "/show/{staffId}")
    public ModelAndView bookingShow(@PathVariable String staffId) {
        return getModelAndView(staffId);
    }

    @RequestMapping(value = "/booking")
    @ResponseBody
    public Map bookingSave(@RequestParam(value = "staffId") String staffId,
                                    @RequestParam(value = "millis") String millis,
                           HttpSession session) {
        Map ret ;
        try {
            service.bookingSave(staffId, millis, (User)session.getAttribute("user"));
            ret = RMap.asMap("result", "ok");
        } catch (Exception e) {
            ret = RMap.asMap("result", "error");
        }

        return ret;
    }

    private ModelAndView getModelAndView(String staffId) {
        ModelAndView mav = new ModelAndView();
        Merchant merchant = service.queryMerchant();
        List<Staff> staffs = service.queryStaffs();
        List<BookingDate> dates = service.createBookingDates(getStaffIdFromUrlOrDb(staffId, staffs));
        mav.addObject("merchant", merchant);
        mav.addObject("staffs", staffs);
        mav.addObject("dates", dates);

        mav.setViewName("member/booking");
        return mav;
    }

    private String getStaffIdFromUrlOrDb(String staffId, List<Staff> staffs) {
        return StringUtils.isEmpty(staffId) ? getFirstStaffIdOrEmpty(staffs) : staffId;
    }

    private String getFirstStaffIdOrEmpty(List<Staff> staffs) {
        return CollectionUtils.isEmpty(staffs) ? "emptyStaffId" : (staffs.get(0).getStaffId() + "");
    }
}
