package com.bc.smallboss.merchant.staff.service;

import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.merchant.staff.bean.Staff;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.n3r.idworker.Id;
import org.springframework.stereotype.Service;

@Service
public class StaffEditService {


    public void staffSave(Staff staff) {
        Long isStaffExist = new Eql().selectFirst("isStaffExist").params(staff.getMobile()).execute();
        if(0 < isStaffExist) {
            updateStaff(staff);
            return;
        }
        addStaff(staff);
    }

    private void updateStaff(Staff staff) {
        User user = createUser(staff);

        EqlTran tran = new Eql().newTran();
        try {
            tran.start();
            new Eql().insert("updateUser").useTran(tran).params(user).execute();
            new Eql().insert("updateStaff").useTran(tran).params(staff).execute();
            tran.commit();
        } catch (Exception ex) {
            tran.rollback();
            throw new RuntimeException("新增员工失败", ex);
        } finally {
            Closes.closeQuietly(tran);
        }
    }

    private void addStaff(Staff staff) {
        User user = createUser(staff);

        staff.setUserId(user.getUserId());
        staff.setStaffId(Id.next());
        EqlTran tran = new Eql().newTran();
        try {
            tran.start();
            new Eql().insert("insertUser").useTran(tran).params(user).execute();
            new Eql().insert("insertStaff").useTran(tran).params(staff).execute();
            tran.commit();
        } catch (Exception ex) {
            tran.rollback();
            throw new RuntimeException("新增员工失败", ex);
        } finally {
            Closes.closeQuietly(tran);
        }
    }

    private User createUser(Staff staff) {
        User user = new User();
        user.setUserId(Id.next());
        user.setName(staff.getName());
        user.setMobile(staff.getMobile());
        user.setSex(staff.getSex());
        user.setType(1);
        user.setPasswd("123456");

        return user;
    }
}
