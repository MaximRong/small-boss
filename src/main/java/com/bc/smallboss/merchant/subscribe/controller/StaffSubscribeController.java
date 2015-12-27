package com.bc.smallboss.merchant.subscribe.controller;

import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.member.booking.bean.BookingDate;
import com.bc.smallboss.merchant.index.bean.StaffSubscribe;
import com.bc.smallboss.merchant.staff.bean.Staff;
import com.bc.smallboss.merchant.subscribe.service.StaffSubscribeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/merchant/staff-subscribe")
public class StaffSubscribeController {

    @Autowired
    private StaffSubscribeService service;

    @RequestMapping(value = "/show")
    public ModelAndView show() {
        return getModelAndView(null);
    }

    @RequestMapping(value = "/show/{staffId}")
    public ModelAndView show(@PathVariable String staffId) {
        return getModelAndView(staffId);
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

    private ModelAndView getModelAndView(String staffId) {
        ModelAndView mav = new ModelAndView();

        List<Staff> staffs = service.queryStaffs();
        List<BookingDate> dates = service.createBookingDates();

        String queryStaffId = StringUtils.isEmpty(staffId) ? getFirstStaff(staffs) : staffId;
        List<StaffSubscribe> subscribes = service.queryStaffSubscribes(queryStaffId);
        mav.addObject("staffs", staffs);
        mav.addObject("subscribes", subscribes);
        mav.addObject("dates", dates);
        mav.addObject("staffId", queryStaffId + "");

        mav.setViewName("merchant/staff-subscribe");
        return mav;
    }

    private String getFirstStaff(List<Staff> staffs) {
        return staffs.get(0).getStaffId() + "";
    }


}
