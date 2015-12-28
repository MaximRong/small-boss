package com.bc.smallboss.merchant.staff.controller;

import com.bc.smallboss.base.utils.OAuthInfo;
import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.merchant.staff.bean.Staff;
import com.bc.smallboss.merchant.staff.service.StaffModifyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/merchant/staff")
public class StaffModifyController {

    @Autowired
    private StaffModifyService service;

    @RequestMapping(value = "/modify-show")
    public ModelAndView show() {
        return getModelAndView(null);
    }

    private ModelAndView getModelAndView(String staffId) {
        ModelAndView mav = new ModelAndView();
        Staff staff = StringUtils.isEmpty(staffId) ? service.queryStaffByUserId(OAuthInfo.get().getUserId()) : service.queryStaffByStaffId(staffId);
        mav.addObject("staff", staff);
        mav.addObject("canRemove", StringUtils.isNotEmpty(staffId));

        mav.setViewName("merchant/staff-modify");
        return mav;
    }


    @RequestMapping(value = "/modify")
    public @ResponseBody Map staffModify(@RequestBody Staff staff) {
        return service.modifyStaff(staff);
    }


}
