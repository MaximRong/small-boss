<!DOCTYPE html>
<html>
<head lang="en">
    <title>商户登录</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/common/css/login.css")}">
    <script src="${e.res("/biz/merchant/js/MerchantLogin.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="login">
        <div class="inner">
            <div class="item">
                <span>手机</span>
                <input id="mobile" placeholder="请输入手机号" maxlength="11"/>
            </div>
            <div class="item">
                <span>密码</span>
                <input id="password" type="password" placeholder="请输入密码"/>
            </div>
        </div>
    </div>

    <div class="login-operate">
        <div class="login-btn">登陆</div>
    </div>

    <#include "../common/input-block.ftl">
</div>
</body>
</html>