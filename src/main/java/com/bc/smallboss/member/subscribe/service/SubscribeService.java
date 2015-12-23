package com.bc.smallboss.member.subscribe.service;

import com.bc.smallboss.base.utils.OAuthInfo;
import com.bc.smallboss.member.booking.bean.Subscribe;
import com.bc.smallboss.member.register.bean.Member;
import org.joda.time.DateTime;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeService {

    public Member queryMember() {
        return new Eql().selectFirst("queryMemberIdByUserId").returnType(Member.class).params(OAuthInfo.get().getUserId()).execute();
    }

    public List<Subscribe> querySubscibes(long memberId) {
        List<Subscribe> subscribes = new Eql().select("querySubscribes").params(memberId).returnType(Subscribe.class).execute();
        for (Subscribe subscribe : subscribes) {
            long millis = subscribe.getMillis();
            DateTime now = DateTime.now();
            boolean after = now.isAfter(millis);
            System.out.println(after);
            subscribe.setIsPassed(after); // 131306745034909696
        }

        return subscribes;
    }

    public static void main(String[] args) {
        DateTime now = DateTime.now();
        System.out.println(now.isAfter(131306745034909696l));
    }
}
