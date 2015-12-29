<!DOCTYPE html>
<html>
<head lang="en">
    <title>会员注册</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/member/css/register.css")}">
    <script src="${e.res("/biz/merchant/js/ChangePassword.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="member-panel">
        <div class="item clearfix" id="password">
            <span class="info">密码</span>
            <span class="content"></span>

            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div class="item clearfix" id="reRassword">
            <span class="info">确认密码</span>
            <span class="content"></span>

            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>


        <div class="member-operate">
            <div class="save-btn ">保存</div>
        </div>

    <#include "../common/input-block.ftl">
</div>
</body>
</html>