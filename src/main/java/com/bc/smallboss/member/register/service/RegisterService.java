package com.bc.smallboss.member.register.service;

import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.register.bean.Member;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.n3r.idworker.Id;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class RegisterService {

    public Map register(Member member, HttpSession session) {
        if(mobileExist(member)) {
            return RMap.asMap("result", "error", "msg", "电话号码已经存在");
        }

        member.setMemberId(Id.next());
        User user = createUser(member);
        member.setUserId(user.getUserId());

        EqlTran tran = new Eql().newTran();
        try {
            tran.start();
            new Eql().insert("insertUser").useTran(tran).params(user).execute();
            new Eql().insert("insertMember").useTran(tran).params(member).execute();
            new Eql().insert("insertStaffMessage").useTran(tran).params(member).execute();
            tran.commit();
        } catch (Exception ex) {
            tran.rollback();
            throw new RuntimeException("注册会员失败", ex);
        } finally {
            Closes.closeQuietly(tran);
        }
        session.setAttribute("user", user);
        return RMap.asMap("result", "ok");
    }

    private boolean mobileExist(Member member) {
        Long count = new Eql().selectFirst("mobileExist").params(member.getMobile()).execute();
        return count > 0;
    }

    private User createUser(Member member) {
        User user = new User();
        user.setType(2);
        user.setPasswd(member.getPassword());
        user.setMobile(member.getMobile());
        user.setName(member.getName());
        user.setSex(member.getSex());
        user.setUserId(Id.next());
        user.setMemberId(member.getMemberId());
        return user;
    }
}
