package com.bc.smallboss.member.booking.bean;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Locale;

public class BookingDate {

    private String dayOfYear;

    private String dayOfMonth;

    private String dayOfWeek;

    private String dateDesc;

    private List<BookingTime> bookingTimes;

    private String tabStyle;

    private String dayListStyle;

    private static  final String WEEKS[] = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};

    public static String dayOfWeek2Chinese(int dayOfWeek) {
        return WEEKS[dayOfWeek - 1];
    }

    public BookingDate(String dayOfYear, String dayOfMonth, String dayOfWeek, String dateDesc) {
        this.dayOfYear = dayOfYear;
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.dateDesc = dateDesc;
    }

    public BookingDate(DateTime dateTime) {
        this.dayOfYear = dateTime.getDayOfYear() + "";
        this.dayOfMonth = dateTime.getDayOfMonth() + "";
        this.dayOfWeek = dateTime.getDayOfWeek() + "";
        dateDesc = dateTime.toString("MM月dd日", Locale.CHINESE);
        tabStyle = "unselected";
        dayListStyle = "display : none;";
        if(isToday(dateTime)) {
            dateDesc += "(今天)";
            tabStyle = "selected";
            dayListStyle = "display : block;";
        } else if(isTomarrow(dateTime)) {
            dateDesc += "(明天)";
        } else if(isDoubleTomarrow(dateTime)) {
            dateDesc += "(后天)";
        } else {
            dateDesc += "(" + dayOfWeek2Chinese(dateTime.getDayOfWeek()) + ")";
        }
    }

    public List<BookingTime> getBookingTimes() {
        return bookingTimes;
    }

    public void setBookingTimes(List<BookingTime> bookingTimes) {
        this.bookingTimes = bookingTimes;
    }

    @Override
    public String toString() {
        return "BookingDate{" +
                "dayOfYear='" + dayOfYear + '\'' +
                ", dayOfMonth='" + dayOfMonth + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", dateDesc='" + dateDesc + '\'' +
                ", bookingTimes=" + bookingTimes +
                '}';
    }

    public String getTabStyle() {
        return tabStyle;
    }

    public void setTabStyle(String tabStyle) {
        this.tabStyle = tabStyle;
    }

    public String getDayListStyle() {
        return dayListStyle;
    }

    public void setDayListStyle(String dayListStyle) {
        this.dayListStyle = dayListStyle;
    }

    public static String[] getWEEKS() {
        return WEEKS;
    }

    private boolean isToday(DateTime bookingDate) {
        DateTime now = DateTime.now();
        return DateUtils.isSameDay(now.toDate(), bookingDate.toDate());
    }

    private boolean isTomarrow(DateTime bookingDate) {
        DateTime tomarrow = DateTime.now().plusDays(1);
        return DateUtils.isSameDay(tomarrow.toDate(), bookingDate.toDate());
    }

    private boolean isDoubleTomarrow(DateTime bookingDate) {
        DateTime tomarrow = DateTime.now().plusDays(2);
        return DateUtils.isSameDay(tomarrow.toDate(), bookingDate.toDate());
    }

    public String getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(String dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDateDesc() {
        return dateDesc;
    }

    public void setDateDesc(String dateDesc) {
        this.dateDesc = dateDesc;
    }
}
