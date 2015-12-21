package com.bc.smallboss.member.booking.bean;

public class BookingTime {

    private String hourOfDay;

    private String endHourOfDay;

    private String timeMillis;

    // 1 已预约 0 未预约
    private String state;

    public BookingTime(String hourOfDay, String endHourOfDay, String timeMillis, String state) {
        this.hourOfDay = hourOfDay;
        this.endHourOfDay = endHourOfDay;
        this.timeMillis = timeMillis;
        this.state = state;
    }

    public String getHourOfDay() {
        return hourOfDay;
    }

    public void setHourOfDay(String hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    public String getEndHourOfDay() {
        return endHourOfDay;
    }

    public void setEndHourOfDay(String endHourOfDay) {
        this.endHourOfDay = endHourOfDay;
    }

    public String getTimeMillis() {
        return timeMillis;
    }

    public void setTimeMillis(String timeMillis) {
        this.timeMillis = timeMillis;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BookingTime{" +
                "hourOfDay='" + hourOfDay + '\'' +
                ", endHourOfDay='" + endHourOfDay + '\'' +
                ", timeMillis='" + timeMillis + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
