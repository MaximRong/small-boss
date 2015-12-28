<!DOCTYPE html>
<html>
<head lang="en">
    <title>会员列表</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/merchant/css/member.css")}">
    <script src="${e.res("/biz/merchant/js/Member.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <#--<div class="search-panel clearfix">
        <div class="search-box">
            <input placeholder="会员名/手机号"/>
        </div>
        <div class="search-btn">
            <i class="iconfont">&#xe607;</i>
        </div>
    </div>-->

    <div class="member-operate">
        <a href="${e.ctx()}/merchant/member/add-show">
        <div class="add-member">
            <i class="iconfont">&#xe609;</i>
            <span>添加会员</span>
        </div>
        </a>
    </div>

    <div class="members">
        <ul class="members-inner">
            <#list members as member>
            <li class="member-item clearfix">
                <div class="content">
                    <div class="member-photo">
                        <img src="${e.photo(member.photo, "meidui.jpg")}"/>
                    </div>
                    <div class="member-info">
                        <span class="name">${member.name}</span>
                        <#if member.sex == 0>
                        <span class="female"><i class="iconfont">&#xe603;</i></span>
                        <#else>
                        <span class="man"><i class="iconfont">&#xe602;</i></span>
                        </#if>
                    </div>
                    <div class="line">
                        <div></div>
                    </div>
                </div>
                <div class="operate">
                    <a class="iconfont" href="tel:${member.mobile}">&#xe604;</a>
                </div>
            </li>
            </#list>
        </ul>
    </div>
</div>

</body>
</html>