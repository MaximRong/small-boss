<!DOCTYPE html>
<html>
<head lang="en">
    <title>会员注册</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/member/css/register.css")}">
    <script src="${e.res("/biz/member/js/MemberRegister.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="member-panel">
        <div class="item member-name clearfix">
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
            <div class="save-btn ">好了，提价资料审核</div>
        </div>

    <#include "../common/input-block.ftl">
</div>
</body>
</html>