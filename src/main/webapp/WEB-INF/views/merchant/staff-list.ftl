<!DOCTYPE html>
<html>
<head lang="en">
    <title>教练列表</title>
<#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/merchant/css/staff.css")}">
    <script src="${e.res("/biz/merchant/js/StaffList.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="staff-operate">
        <a href="${e.ctx()}/merchant/staff/edit">
            <div class="add-staff">
                <i class="iconfont">&#xe609;</i>
                <span>添加新员工</span>
            </div>
        </a>
    </div>

    <div class="staffs">
        <ul class="staffs-inner">
        <#list staffs as staff>
            <li class="staff-item clearfix">
                <div class="content">
                    <div class="staff-photo">
                        <img src="${e.res("/biz/member/img/meidui.jpg")}"/>
                    </div>
                    <div class="staff-info">
                        <span class="name">${staff.name}</span>
                        <#if staff.sex == 0>
                            <span class="female"><i class="iconfont">&#xe602;</i></span>
                        <#else>
                            <span class="man"><i class="iconfont">&#xe602;</i></span>
                        </#if>

                    </div>
                    <div class="line">
                        <div></div>
                    </div>
                </div>
                <div class="operate">
                    <a class="iconfont" href="tel:${staff.mobile}">&#xe604;</a>
                </div>
            </li>
        </#list>

        </ul>
    </div>
</div>
</body>
</html>