package com.bc.smallboss.merchant.staff.controller;

import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.merchant.staff.bean.Staff;
import com.bc.smallboss.merchant.staff.service.StaffEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/merchant/staff")
public class StaffEditController {

    @Autowired
    private StaffEditService service;

    @RequestMapping(value = "/edit")
    public String staffEdit() {
        return "merchant/staff-edit";
    }


    @RequestMapping(value = "/save")
    public @ResponseBody Map staffSave(@RequestBody Staff staff) {
        service.staffSave(staff);
        return RMap.of("result", "ok");
    }


}
