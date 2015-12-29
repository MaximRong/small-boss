<!DOCTYPE html>
<html>
<head lang="en">
    <title>员工</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/merchant/css/member-detail.css")}">
    <script src="${e.res("/biz/merchant/js/MemberDetail.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="member-panel">
        <div class="member-info clearfix">
            <div class="member-photo">
                <div class="photo">
                    <img src="${e.photo(member.photo, "meidui.jpg")}"/>
                </div>
            </div>

            <div class="info">
                <div class="base-info">
                    <span>${member.name}</span>
                    <i class="iconfont man">&#xe602;</i>
                </div>

                <div class="extra-info">
                    <span>电话: </span>
                    <a>${member.mobile}</a>
                    <a class="iconfont" href="tel:${member.mobile}">&#xe604;</a>
                </div>
            </div>
        </div>
    </div>

    <div class="person-main">
        <ul class="main-tabs clearfix">
            <li class="selected">
                <span>预约历史</span>

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
                </div>
            </div>
            </#list>
        </div>
    </div>

    <input type="hidden" id="memberId" value="${member.memberId}"/>
    <div class="member-operate">
        <div class="delete-btn">删除</div>
    </div>

<#include "../common/input-block.ftl">
</div>
</body>
</html>