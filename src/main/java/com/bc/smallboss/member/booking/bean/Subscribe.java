package com.bc.smallboss.member.booking.bean;

import java.util.Date;

public class Subscribe {

    private long subscribeId;

    private long staffId;

    private String staffName;

    private String staffMobile;

    private Date subscribeTime;

    private long memberId;

    private String memberName;

    private String memberMobile;

    private long millis;

    private String state;

    private boolean isPassed;

    private String stateDesc;

    public boolean getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(long subscribeId) {
        this.subscribeId = subscribeId;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffMobile() {
        return staffMobile;
    }

    public void setStaffMobile(String staffMobile) {
        this.staffMobile = staffMobile;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "subscribeId=" + subscribeId +
                ", staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", staffMobile='" + staffMobile + '\'' +
                ", subscribeTime=" + subscribeTime +
                ", memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberMobile='" + memberMobile + '\'' +
                ", millis=" + millis +
                '}';
    }
}
