package com.bc.smallboss.merchant.staff.service;

import com.bc.smallboss.merchant.staff.bean.Staff;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffListService {

    public List<Staff> queryStaffList() {
        return new Eql().returnType(Staff.class).execute();
    }
}
