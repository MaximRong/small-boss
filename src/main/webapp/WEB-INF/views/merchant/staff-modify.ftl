<!DOCTYPE html>
<html>
<head lang="en">
    <title>员工</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/merchant/css/staff-detail.css")}">
    <script src="${e.res("/biz/merchant/js/StaffModify.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="staff-panel">
        <div class="item staff-name clearfix">
            <span class="info">姓名</span>
            <span class="content" data-val="${staff.name}">${staff.name}</span>

            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div class="item clearfix" id="sex">
            <span class="info">性别</span>
            <span class="content" data-val="${staff.sex}"><#if staff.sex = 0>女<#else>男</#if></span>

            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

<#--        <div class="item clearfix" id="mobile">
            <span class="info">电话</span>
            <span class="content" data-val="${staff.mobile}">${staff.mobile}</span>

            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>-->

        <div class="item clearfix" id="desc">
            <span class="info">简介</span>
            <span class="content" data-val="${staff.desc}">${staff.desc}</span>

            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div class="item clearfix" id="tags">
            <span class="info-all">个人标签(选填项，点击添加，最多三个)</span>

            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div id="tag-items">
        <#if staff.tag1?has_content>
            <div class="item clearfix">
                <span class="info-lab" data-val="${staff.tag1}">${staff.tag1}</span>
                <i class="delete iconfont">&#xe608;</i>
            </div>
        </#if>

        <#if staff.tag2?has_content>
            <div class="item clearfix">
                <span class="info-lab" data-val="${staff.tag2}">${staff.tag2}</span>
                <i class="delete iconfont">&#xe608;</i>
            </div>
        </#if>

        <#if staff.tag3?has_content>
            <div class="item clearfix">
                <span class="info-lab" data-val="${staff.tag3}">${staff.tag3}</span>
                <i class="delete iconfont">&#xe608;</i>
            </div>
        </#if>
        </div>

    </div>

    <div class="staff-operate">
        <input type="hidden" id="staffId" value="${staff.staffId}"/>
        <input type="hidden" id="userId" value="${staff.userId}"/>
        <div class="save-btn">保存</div>
        <#if canRemove>
        <div class="delete-btn">删除</div>
        </#if>
    </div>

<#include "../common/input-block.ftl">
</div>
</body>
</html>