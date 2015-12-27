package com.bc.smallboss.merchant.index.bean;

import com.bc.smallboss.member.booking.bean.Subscribe;

import java.util.Date;

public class StaffSubscribe extends Subscribe {

    private String dayOfYear;

    private Date endTime;

    private boolean isToday;

    public String getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(String dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public void setIsToday(boolean isToday) {
        this.isToday = isToday;
    }

    public boolean getIsToday() {
        return isToday;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
