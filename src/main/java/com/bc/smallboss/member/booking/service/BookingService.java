package com.bc.smallboss.member.booking.service;

import com.bc.smallboss.common.bean.User;
import com.bc.smallboss.member.booking.bean.BookingDate;
import com.bc.smallboss.member.booking.bean.BookingTime;
import com.bc.smallboss.member.booking.bean.Subscribe;
import com.bc.smallboss.member.register.bean.Member;
import com.bc.smallboss.merchant.merchant.bean.Merchant;
import com.bc.smallboss.merchant.staff.bean.Staff;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.joda.time.DateTime;
import org.n3r.eql.Eql;
import org.n3r.idworker.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookingService {

    public Merchant queryMerchant() {
        return new Eql().selectFirst("queryMerchant").returnType(Merchant.class).execute();
    }

    public List<Staff> queryStaffs() {
        return new Eql().select("queryStaffs").returnType(Staff.class).execute();
    }

    public List<BookingDate> createBookingDates(String staffId) {
        List<Long> bookingTimeMillis = new Eql().select("queryBookingTimeMillis").params(staffId).returnType(Long.class).execute();
        Map<String, String> bookingTimeRange = new Eql().selectFirst("queryBookingTimeRange").execute();
        int bookingStartTime = Integer.valueOf(MapUtils.getString(bookingTimeRange, "bookingStartTime"));
        int bookingEndTime = Integer.valueOf(MapUtils.getString(bookingTimeRange, "bookingEndTime"));
        return createBookingDates(bookingTimeMillis, bookingStartTime, bookingEndTime);
    }

    public void bookingSave(String staffId, String millis, User user) {
        Member member = new Eql().selectFirst("queryMemberByUserId").params(user.getUserId()).returnType(Member.class).execute();
        Staff staff = new Eql().selectFirst("queryStaffByStaffId").params(staffId).returnType(Staff.class).execute();

        Subscribe subscribe = new Subscribe();
        subscribe.setSubscribeId(Id.next());
        subscribe.setMemberId(member.getMemberId());
        subscribe.setMemberName(member.getName());
        subscribe.setMemberMobile(member.getMobile());
        subscribe.setStaffId(staff.getStaffId());
        subscribe.setStaffName(staff.getName());
        subscribe.setStaffMobile(staff.getMobile());
        DateTime subscribeTime = new DateTime(Long.valueOf(millis));
        subscribe.setSubscribeTime(subscribeTime.toDate());
        subscribe.setMillis(subscribeTime.getMillis());

        new Eql().insert("insertSubscribe").params(subscribe).execute();
        new Eql().insert("insertBookingMessage").params(staff.getUserId()).execute();
    }

    private List<BookingDate> createBookingDates(List<Long> bookingTimeMillis, int bookingStartTime, int bookingEndTime) {
        List<BookingDate> bookingDates = Lists.newArrayList();
        DateTime startTime = DateTime.now();
        for (int i = 0; i < 7; i++) {
            DateTime bookingDateTime = 0 < i ? startTime.plusDays(i).withMillisOfDay(0) : startTime.plusDays(i).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
            BookingDate bookingDate = new BookingDate(bookingDateTime);

            List<BookingTime> dayBookingTimes = createDayBookingTimes(bookingTimeMillis, bookingStartTime, bookingEndTime, bookingDateTime);
            bookingDate.setBookingTimes(dayBookingTimes);
            bookingDates.add(bookingDate);
        }
        return bookingDates;
    }

    private List<BookingTime> createDayBookingTimes(List<Long> bookingTimeMillis, int bookingStartTime, int bookingEndTime, DateTime startTime) {
        List<BookingTime> dayBookingTimes = Lists.newArrayList();
        int addHour = 0;
        while (true) {
            DateTime time = startTime.plusHours(addHour++);
            int hourOfDay = time.getHourOfDay();
            if(hourOfDay < bookingStartTime) {
                continue;
            }
            if(hourOfDay > bookingEndTime || startTime.getDayOfYear() != time.getDayOfYear()) {
                break;
            }
            long millis = time.getMillis();
            BookingTime bookingTime = new BookingTime(hourOfDay + "", (hourOfDay + 1) + "", millis + "", bookingTimeMillis.contains(millis) ? "1" : "0");
            dayBookingTimes.add(bookingTime);
        }
        return dayBookingTimes;
    }

    public static void main(String[] args) {

        DateTime startTime = DateTime.now();
        System.out.println(startTime.getHourOfDay());
//        System.out.println(startTime.getDayOfYear());
//        DateTime.Property property = startTime.hourOfDay();
//        System.out.println(property.getAsString());
//        startTime.getHourOfDay();
        System.out.println(startTime.getMillis());
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(1450540800000l);
//
//        Chronology coptic = CopticChronology.getInstance();


        DateTime dateTime = new DateTime(1450972800000l);
        System.out.println(dateTime);
        System.out.println(dateTime.getHourOfDay() + " " + dateTime.getMinuteOfHour());

/*

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        //时间解析
        DateTime dateTime = DateTime.parse("2012-12-21 23:22:45", format);

        //时间格式化，输出==> 2012/12/21 23:22:45 Fri
        String string_u = dateTime.toString("yyyy/MM/dd HH:mm:ss EE");
        System.out.println(string_u);
*/

        //格式化带Locale，输出==> 2012年12月21日 23:22:45 星期五
//        String string_c = startTime.toString("MM月dd日", Locale.CHINESE);


//        System.out.println(string_c);

    }


}
