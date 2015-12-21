<!DOCTYPE html>
<html>
<head lang="en">
    <title>员工</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/merchant/css/staff-detail.css")}">
    <script src="${e.res("/biz/merchant/js/StaffEditor.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="staff-panel">
        <div class="item staff-name clearfix">
            <span class="info">姓名</span>
            <span class="content"></span>

            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div class="item clearfix" id="sex">
            <span class="info">性别</span>
            <span class="content"></span>

            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div class="item clearfix" id="mobile">
            <span class="info">电话</span>
            <span class="content"></span>

            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div class="item clearfix" id="desc">
            <span class="info">简介</span>
            <span class="content"></span>

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

        </div>

    </div>

    <div class="staff-operate">
        <div class="save-btn">保存</div>
        <div class="delete-btn">删除</div>
    </div>

<#include "../common/input-block.ftl">
</div>
</body>
</html>