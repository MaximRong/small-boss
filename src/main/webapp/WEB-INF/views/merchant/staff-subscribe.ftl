<!DOCTYPE html>
<html>
<head lang="en">
    <title>我的预约</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/merchant/css/myworks.css")}">
    <link rel="stylesheet" href="${e.res("/common/css/slick.css")}">
    <link rel="stylesheet" href="${e.res("/common/css/slick-theme.css")}">
    <script src="${e.res("/biz/merchant/js/StaffSubscribe.js")}" charset="UTF-8"></script>
    <script src="${e.res("/common/js/slick.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="staff-panel">
        <ul class="staff-choose clearfix">
            <#list staffs as staff>
            <li <#if staff.staffId?string == staffId>class="selected"<#else>class="unselected"</#if> id="${staff.staffId}">
                <img src="${e.photo(staff.photo, "meidui.jpg")}"/>
                <div class="staff-name">${staff.name}</div>
            </li>
            </#list>
        </ul>
        <div class="staff-footer clearfix" data-style="table">
            <div class="staff-link">列表模式</div>
        </div>
    </div>

    <!-- replace-start -->
    <div class="booking-panel">
        <div class="table-style" style="display: none;">
            <#list subscribes as subscribe>
                <div class="booking-table">
                    <div class="booking-info clearfix">
                        <div class="booking-left">
                            <div class="staff-name">
                                <span class="info">会员:</span>
                                <span class="content">${subscribe.memberName}</span>
                                <a class="iconfont" href="tel:${subscribe.memberMobile}">&#xe604;</a>
                            </div>

                            <div class="booking-time">
                                <span class="info">预约时间:</span>
                                <span class="content">${subscribe.subscribeTime?string("yyyy年MM月dd号, HH点")}</span>
                            </div>

                            <div class="booking-state">
                                <span class="info">状态:</span>
                                <span class="content"><#if subscribe.state == "0">已取消<#elseif subscribe.isPassed>已结束<#else>未使用</#if></span>
                            </div>
                        </div>
                    </div>
                    <div class="booking-operate cancel-booking-fake"  data-val="${subscribe.subscribeId}"
                         <#if subscribe.isPassed || subscribe.state == "0">style="display: none;" </#if>>
                        <span>取消预约</span>
                    </div>
                </div>
            </#list>
        </div>

        <div class="date-style">
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
                <#list subscribes as subscribe>
                    <div class="booking-inner" data-date="${subscribe.dayOfYear}" <#if !subscribe.isToday>style="display: none;" </#if>>
                        <div class="booking-item clearfix">
                            <div class="booking-time">
                                <div class="start-time">${subscribe.subscribeTime?string("HH")}:00开始</div>
                                <div class="end-time">${subscribe.endTime?string("HH")}:00结束</div>
                            </div>

                            <div class="booking-member">
                                <span>${subscribe.memberName}</span>
                                <a class="iconfont" href="tel:${subscribe.memberMobile}">&#xe604;</a>
                            </div>
                            <#if !subscribe.isPassed && subscribe.state == "1">
                                <a class="booking-state cancel-booking-fake" data-val="${subscribe.subscribeId}">取消预约</a>
                            <#else>
                                <a class="cancel-state"><#if subscribe.isPassed>已结束<#else>已取消</#if></a>
                            </#if>
                        </div>
                    </div>
                </#list>
            </div>
        </div>

        <script>
            $('.slick-container').slick({
                infinite: false,
                slidesToShow: 3,
                slidesToScroll: 3
            });

            $(function () {
                $(".date-circle > .booking-date").click(function () {
                    $(".date-circle > .booking-date").removeClass("selected");
                    var day = $(this).data("day");
                    $(this).addClass("selected")
                    $(".booking-inner").hide();
                    $(".booking-inner").filter(function() {
                        return $(this).data("date") == day;
                    }).show();
                });
            });

            $(".cancel-booking-fake").click(function() {
                $.ajax({
                    url: context + "/merchant/staff-subscribe/cancel",
                    type: "POST",
                    data: {"subscribeId": $(this).data("val")},
                    dataType: "json",
                    success : function (ret) {
                        if("ok" == ret.result) {
                            var id = $(".staff-choose > .selected").attr("id");
                            window.location.href = context + "/merchant/staff-subscribe/show/" + id;
                        }

                    }
                });
            });
        </script>

    </div>
    <!-- replace-end -->

</div>

</body>
</html>