package com.bc.smallboss.merchant.index.service;

import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.booking.bean.BookingDate;
import com.bc.smallboss.member.booking.bean.Subscribe;
import com.bc.smallboss.merchant.staff.bean.Staff;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {


    public List<Subscribe> querySubscribes(User user) {
        Staff staff = new Eql().selectFirst("queryStaffByUserId").returnType(Staff.class).params(user.getUserId()).execute();
        List<Subscribe> subscribes = new Eql().select("querySubscribes").params(staff.getStaffId()).returnType(Subscribe.class).execute();
        for (Subscribe subscribe : subscribes) {
            long millis = subscribe.getMillis();
            DateTime now = DateTime.now();
            boolean after = now.isAfter(millis);
            subscribe.setIsPassed(after); // 131306745034909696
        }
        return subscribes;
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
}
