package com.bc.smallboss.merchant.staff.controller;


import com.bc.smallboss.merchant.staff.bean.Staff;
import com.bc.smallboss.merchant.staff.service.StaffListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/merchant/staff")
public class StaffListController {

    @Autowired
    private StaffListService service;

    @RequestMapping(value = "/list")
    public ModelAndView staffEdit() {
        ModelAndView mav = new ModelAndView();

        List<Staff> staffs = service.queryStaffList();
        mav.addObject("staffs", staffs);

        mav.setViewName("merchant/staff-list");
        return mav;
    }
}
