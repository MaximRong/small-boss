package com.bc.smallboss.member.register.service;

import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.register.bean.Member;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.n3r.idworker.Id;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    public void register(Member member) {
        User user = createUser(member);

        member.setUserId(user.getUserId());
        member.setMemberId(Id.next());


        EqlTran tran = new Eql().newTran();
        try {
            tran.start();
            new Eql().insert("insertUser").useTran(tran).params(user).execute();
            new Eql().insert("insertMember").useTran(tran).params(member).execute();
            tran.commit();
        } catch (Exception ex) {
            tran.rollback();
            throw new RuntimeException("注册会员失败", ex);
        } finally {
            Closes.closeQuietly(tran);
        }
    }

    private User createUser(Member member) {
        User user = new User();
        user.setType(2);
        user.setPasswd(member.getPassword());
        user.setMobile(member.getMobile());
        user.setName(member.getName());
        user.setSex(member.getSex());
        user.setUserId(Id.next());
        return user;
    }
}
