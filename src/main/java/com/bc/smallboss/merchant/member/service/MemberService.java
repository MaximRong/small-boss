package com.bc.smallboss.merchant.member.service;

import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.booking.bean.Subscribe;
import com.bc.smallboss.member.register.bean.Member;
import org.joda.time.DateTime;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.n3r.idworker.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    public List<Member> queryMembers() {
        return new Eql().select("queryMembers").returnType(Member.class).execute();
    }

    public Map addMember(Member member) {
        if(mobileExist(member)) {
            return RMap.asMap("result", "error", "msg", "电话号码已经存在");
        }

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
            throw new RuntimeException("添加会员失败", ex);
        } finally {
            Closes.closeQuietly(tran);
        }
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
        return user;
    }

    public Member queryMember(String memberId) {
        return new Eql().selectFirst("queryMember").params(memberId).returnType(Member.class).execute();
    }

    public List<Subscribe> querySubscibes(String memberId) {
        List<Subscribe> subscribes = new Eql().select("querySubscribes").params(memberId).returnType(Subscribe.class).execute();
        for (Subscribe subscribe : subscribes) {
            long millis = subscribe.getMillis();
            DateTime now = DateTime.now();
            boolean after = now.isAfter(millis);
            subscribe.setIsPassed(after); // 131306745034909696
        }

        return subscribes;
    }

    public void deleteMember(String memberId) {
        new Eql().update("deleteMember").params(memberId).execute();
    }
}
