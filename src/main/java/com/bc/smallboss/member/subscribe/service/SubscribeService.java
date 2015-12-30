package com.bc.smallboss.member.subscribe.service;

import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.booking.bean.Subscribe;
import com.bc.smallboss.member.register.bean.Member;
import org.joda.time.DateTime;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeService {

    public Member queryMember(User user) {
        return new Eql().selectFirst("queryMemberIdByUserId").returnType(Member.class).params(user.getUserId()).execute();
    }

    public List<Subscribe> querySubscibes(long memberId) {
        List<Subscribe> subscribes = new Eql().select("querySubscribes").params(memberId).returnType(Subscribe.class).execute();
        for (Subscribe subscribe : subscribes) {
            long millis = subscribe.getMillis();
            DateTime now = DateTime.now();
            boolean after = now.isAfter(millis);
            subscribe.setIsPassed(after); // 131306745034909696
        }

        return subscribes;
    }

    public static void main(String[] args) {
        DateTime now = DateTime.now();
        System.out.println(now.isAfter(131306745034909696l));
    }

    public void subscribeCancel(String subscribeId, User user) {
        new Eql().selectFirst("subscribeCancel").params(subscribeId, user.getUserId()).execute();
    }
}