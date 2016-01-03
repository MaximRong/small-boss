<!DOCTYPE html>
<html>
<head lang="en">
    <title>预订</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/member/css/person.css")}">
    <script src="${e.res("/biz/member/js/Subscribe.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="person-panel clearfix">
        <div class="person-left">
            <div class="person-photo">
                <img src="${e.photo(member.photo, "meidui.jpg")}"/>
            </div>
        </div>
        <div class="person-right">
            <div class="person-name">
                <span>${member.name}</span>
                <#if member.verify == "0"><i>(审核中)</i></#if>
            </div>
        </div>
    </div>

    <div class="person-main">
        <ul class="main-tabs clearfix">
            <li class="selected">
                <span>我的预约</span>

                <div class="arrow-up">
                    <div class="arrow-a"></div>
                    <div class="arrow-b"></div>
                </div>
            </li>
        </ul>
    </div>

    <div class="booking-list">
        <div class="booking-inner">
            <#list subscribes as subscribe>
                <div class="booking-item <#if subscribe.isPassed || subscribe.state == "0">invalid<#else>unused</#if>">
                    <div class="booking-info clearfix">
                        <div class="booking-left">
                            <div class="staff-name">
                                <span class="info">美甲师:</span>
                                <span class="content">${subscribe.staffName}</span>
                            </div>

                            <div class="booking-time">
                                <span class="info">预约时间:</span>
                                <span class="content">${subscribe.subscribeTime?string("yyyy年MM月dd号, HH点")}</span>
                            </div>

                            <div class="booking-state">
                                <span class="info">状态:</span>
                                <span class="content"><#if subscribe.state == "0">已取消<#elseif subscribe.isPassed>已消费<#else>未使用</#if></span>
                            </div>
                        </div>
                        <#if !subscribe.isPassed && subscribe.state == "1">
                            <div class="booking-right">
                                <p class="call-phone"><a class="iconfont" href="tel:${subscribe.staffMobile}">&#xe604;</a></p>
                            </div>
                        </#if>
                    </div>
                    <div class="booking-operate" data-val="${subscribe.subscribeId}">
                        <span><#if subscribe.isPassed || subscribe.state == "0"><#else>取消预约</#if></span>
                    </div>
                </div>
            </#list>
        </div>
    </div>

    <div class="menus clearfix">
        <a href="${e.ctx()}/member/booking/show"><div class="unselected">美甲预约</div></a>
        <div class="selected">我的预约</div>
    </div>
</div>
</body>
</html>