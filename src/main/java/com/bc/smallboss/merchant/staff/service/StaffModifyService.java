package com.bc.smallboss.merchant.staff.service;

import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.merchant.staff.bean.Staff;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StaffModifyService {

    public Staff queryStaffByUserId(long userId) {
        return new Eql().selectFirst("queryStaffByUserId").params(userId).returnType(Staff.class).execute();
    }

    public Staff queryStaffByStaffId(String staffId) {
        return new Eql().selectFirst("queryStaffByStaffId").params(staffId).returnType(Staff.class).execute();
    }

    public Map modifyStaff(Staff staff) {
//        if (mobileExist(staff)) {
//            return RMap.asMap("result", "error", "msg", "电话号码已经存在");
//        }
        new Eql().update("modifyStaff").params(staff).execute();
        return RMap.asMap("result", "ok");
    }

}
