package com.bc.smallboss.merchant.subscribe.service;

import com.bc.smallboss.base.utils.OAuthInfo;
import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.booking.bean.BookingDate;
import com.bc.smallboss.merchant.index.bean.StaffSubscribe;
import com.bc.smallboss.merchant.staff.bean.Staff;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffSubscribeService {

    public List<StaffSubscribe> queryStaffSubscribes(String staffId) {
        List<StaffSubscribe> subscribes = new Eql().select("querySubscribes").params(staffId).returnType(StaffSubscribe.class).execute();
        for (StaffSubscribe subscribe : subscribes) {
            long millis = subscribe.getMillis();
            DateTime now = DateTime.now();
            subscribe.setIsPassed(now.isAfter(millis));

            DateTime subscribeDate = new DateTime(millis);
            int dayOfYear = subscribeDate.getDayOfYear();
            subscribe.setDayOfYear(dayOfYear + ""); // 获取当天
            subscribe.setIsToday(dayOfYear == now.getDayOfYear()); // 是否今天
            subscribe.setEndTime(subscribeDate.plusHours(1).toDate());
        }

    return subscribes;
    }

    public List<Staff> queryStaffs() {
        User user = OAuthInfo.get();
        new Eql().delete("deleteUserMessage").params(user.getUserId()).execute();
        return new Eql().select("queryStaffs").params(user).returnType(Staff.class).execute();
    }

    public List<BookingDate> createBookingDates() {
        List<BookingDate> bookingDates = Lists.newArrayList();
        DateTime startTime = DateTime.now();
        for (int i = 0; i < 7; i++) {
            DateTime bookingDateTime = 0 < i ? startTime.plusDays(i).withMillisOfDay(0) : startTime.plusDays(i).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
            BookingDate bookingDate = new BookingDate(bookingDateTime);
            bookingDates.add(bookingDate);
        }
        return bookingDates;
    }

    public void subscribeCancel(String subscribeId) {
        new Eql().selectFirst("subscribeCancel").params(subscribeId, OAuthInfo.get().getUserId()).execute();
    }
}
