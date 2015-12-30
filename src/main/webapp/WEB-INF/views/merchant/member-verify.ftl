<!DOCTYPE html>
<html>
<head lang="en">
    <title>会员列表</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/merchant/css/member-verify.css")}">
    <script src="${e.res("/biz/merchant/js/MemberVerify.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="members">
        <#if members?has_content>
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
                        <a class="iconfont" href="tel:${member.mobile}">&#xe604;</a>
                    </div>
                    <div class="line">
                        <div></div>
                    </div>
                </div>
                <div class="operate">
                    <span class="pass" data-val="${member.memberId}">通过</span>
                    <span class="refuse" data-val="${member.memberId}">拒绝</span>
                </div>
            </li>
            </#list>
        </ul>
        <#else>
            <div class="no-members">没有任何申请的会员信息哦~</div>
        </#if>
    </div>
</div>

</body>
</html>