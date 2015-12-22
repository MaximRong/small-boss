<!DOCTYPE html>
<html>
<head lang="en">
    <title>预订</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/member/css/booking.css")}">
    <link rel="stylesheet" href="${e.res("/common/css/slick.css")}">
    <link rel="stylesheet" href="${e.res("/common/css/slick-theme.css")}">
    <script src="${e.res("/biz/member/js/MemberRegister.js")}" charset="UTF-8"></script>
    <script src="${e.res("/biz/member/js/Booking.js")}" charset="UTF-8"></script>
    <script src="${e.res("/common/js/slick.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="top-panel">
        <div class="shop-name">${merchant.name}</div>
        <div class="shop-address">${merchant.address}</div>
        <ul class="shop-feature clearfix">
            <#if merchant.tag1?has_content>
            <li>${merchant.tag1}</li>
            </#if>
            <#if merchant.tag2?has_content>
            <li>${merchant.tag2}</li>
            </#if>
            <#if merchant.tag3?has_content>
            <li>${merchant.tag3}</li>
            </#if>
        </ul>
        <p class="call-phone"><a class="iconfont" href="tel:${merchant.mobile}">&#xe604;</a></p>
    </div>
    <div class="staff-panel">
        <ul class="staff-choose clearfix">
            <#list staffs as staff>
            <li <#if staff_index == 0>class="selected"<#else>class="unselected"</#if> data-id="${staff.staffId}">
                <img src="${e.photo(staff.photo, "meidui.jpg")}"/>
                <div class="staff-name">${staff.name}</div>
            </li>
            </#list>
        </ul>
        <div class="staff-footer clearfix">
            <a href="${e.ctx()}/member/staff/${staffs[0].staffId}"><div class="staff-link">美甲师介绍</div></a>
        </div>
    </div>
    <!-- replace-start -->
    <div class="booking-panel">
        <div class="booking-dates">
            <div class="slick-container">
                <#list dates as date>
                    <div class="date-circle">
                        <div data-day="${date.dayOfYear}" class="booking-date ${date.tabStyle}" data-index="0">
                            <span>${date.dateDesc}</span>
                        </div>
                    </div>
                </#list>
            </div>
        </div>

        <div class="booking-times">
            <#list dates as date>
            <div id="${date.dayOfYear}" style="${date.dayListStyle}" class="day-list-fake">
                <#list date.bookingTimes as time>
                    <div class="booking-time" data-millis="${time.timeMillis}">
                        <div class="<#if time.state == "0">can-booking<#else>canot-booking</#if>">
                            <a class="start-time" data-time="${time.hourOfDay}">${time.hourOfDay}:00 开始</a>
                            <a class="end-time">${time.endHourOfDay}:00结束</a>
                            <a class="booking-state"><#if time.state == "0">可预约<#else>已被预约</#if></a>
                        </div>
                    </div>
                </#list>
            </div>
            </#list>
        </div>

        <script>
            $('.slick-container').slick({
                infinite: false,
                slidesToShow: 3,
                slidesToScroll: 3
            });

            $(".date-circle > .booking-date").click(function () {
                $(".date-circle > .booking-date").removeClass("selected");
                var day = $(this).data("day");
                $(this).addClass("selected")
                $(".day-list-fake").hide();
                $("#" + day).show();
            });

            $(".booking-time").click(function() {
                var $selectStaff = $(".staff-choose > .selected");
                var staffId = $selectStaff.data("id");
                var staffName = $selectStaff.find(".staff-name").text();
                var millis = $(this).data("millis");
                var startTime = $(this).find(".start-time").data("time");
                $("#comfirm-booking-time").data("millis", millis).text(startTime + ":00");
                $("#comfirm-booking-staff").data("staffId", staffId).text(staffName);

                $(".booking-block").show().addClass("block-fadeUp").one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
                    $(this).removeClass("block-fadeUp");
                });
            });
        </script>
    </div>
    <!-- replace-end -->

    <div class="booking-block" id="booking-block">
        <div class="booking-inner">
            <div class="booking-info">
                <span class="info">时&nbsp;&nbsp;&nbsp;&nbsp;间:</span>
                <span class="content" id="comfirm-booking-time"></span>
            </div>

            <div class="booking-info">
                <span class="info">美甲师:</span>
                <span class="content" id="comfirm-booking-staff"></span>
            </div>

            <div class="booking-info" style="display: none;">
                <span class="info">支付会员卡:</span>
            </div>

            <ul class="card-items clearfix" style="display: none;">
                <li class="card-item-selected">
                    <div class="card-name">8折卡</div>
                    <div class="left">剩余5000元</div>
                </li>

                <li class="card-item">
                    <div class="card-name">5折卡</div>
                    <div class="left">剩余3000元</div>
                </li>
            </ul>
        </div>

        <div class="booking-btn">确认预约</div>
    </div>

    <#include "../common/input-block.ftl">
</div>
</body>
</html>