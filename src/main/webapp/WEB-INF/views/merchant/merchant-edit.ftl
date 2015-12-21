<!DOCTYPE html>
<html>
<head lang="en">
    <title>商户首页</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/merchant/css/merchant.css")}">
    <script src="${e.res("/biz/merchant/js/MerchantEdit.js")}" charset="UTF-8"></script>
</head>
<body>
<div class="main">
    <div class="merchant-panel">
        <div class="item merchant-name clearfix">
            <span class="info">店名</span>
            <span class="content" data-val="${merchant.name}">${merchant.name}</span>
            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div class="item clearfix" id="mobile">
            <span class="info">电话</span>
            <span class="content" data-val="${merchant.mobile}">${merchant.mobile}</span>
            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div class="item clearfix" id="address">
            <span class="info">地址</span>
            <span class="content" data-val="${merchant.address}">${merchant.address}</span>
            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div class="item clearfix" id="tags">
            <span class="info-all">场馆标签(点击添加，最多三个)</span>
            <div class="arrow-right">
                <div class="arrow-a"></div>
                <div class="arrow-b"></div>
            </div>
        </div>

        <div id="tag-items">
            <#if merchant.tag1?has_content>
                <div class="item clearfix">
                    <span class="info-lab" data-val="${merchant.tag1}">${merchant.tag1}</span>
                    <i class="delete iconfont">&#xe608;</i>
                </div>
            </#if>

            <#if merchant.tag2?has_content>
                <div class="item clearfix">
                    <span class="info-lab" data-val="${merchant.tag2}">${merchant.tag2}</span>
                    <i class="delete iconfont">&#xe608;</i>
                </div>
            </#if>

            <#if merchant.tag3?has_content>
                <div class="item clearfix">
                    <span class="info-lab" data-val="${merchant.tag3}">${merchant.tag3}</span>
                    <i class="delete iconfont">&#xe608;</i>
                </div>
            </#if>
        </div>

      <#--  <div class="item clearfix">
            <span class="info-lab">可停车</span>
            <i class="delete iconfont">&#xe608;</i>
        </div>

        <div class="item clearfix">
            <span class="info-lab">时尚达人</span>
            <i class="delete iconfont">&#xe608;</i>
        </div>-->
    </div>

    <div class="merchant-operate">
        <div class="save-btn active">保存</div>
    </div>

    <#include "../common/input-block.ftl">
</div>

</body>
</html>