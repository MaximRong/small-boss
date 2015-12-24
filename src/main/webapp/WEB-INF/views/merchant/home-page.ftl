<!DOCTYPE html>
<html>
<head lang="en">
    <title>商户首页</title>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="${e.res("/biz/merchant/css/merchant-index.css")}">
    <link rel="stylesheet" href="${e.res("/common/css/slick.css")}">
    <link rel="stylesheet" href="${e.res("/common/css/slick-theme.css")}">
    <script src="${e.res("/biz/merchant/js/MerchantIndex.js")}" charset="UTF-8"></script>
    <script src="${e.res("/common/js/slick.js")}" charset="UTF-8"></script>
    <#assign ctx = e.ctx()>
</head>
<body>
<div class="main">
    <div class="often-funs clearfix">
        <div class="fun">
            <div class="content">
                <div class="content-inner">
                    <div class="icon"><i class="iconfont">&#xe60f;</i><a></a></div>
                    <div class="text"><span>预约</span></div>
                </div>
            </div>
        </div>

        <div class="fun">
            <div class="content">
                <div class="content-inner">
                    <div class="icon"><i class="iconfont">&#xe60c;</i></div>
                    <div class="text"><span>会员</span></div>
                </div>
            </div>
        </div>

        <div class="fun">
            <div class="content">
                <div class="content-inner">
                    <div class="icon"><i class="iconfont">&#xe60e;</i></div>
                    <div class="text"><span>个人</span></div>
                </div>
            </div>
        </div>

        <div class="fun">
            <div class="content">
                <div class="content-inner">
                    <div class="icon"><i class="iconfont">&#xe610;</i><a></a></div>
                    <div class="text"><span>作品</span></div>
                </div>
            </div>
        </div>
    </div>

    <div class="less-funs clearfix">
        <a href="${ctx}/merchant/merchant/edit">
        <div class="fun border-rm">
            <div class="content">
                <div class="content-inner">
                    <div class="icon"><i class="iconfont">&#xe60b;</i></div>
                    <div class="text"><span>场馆设置</span></div>
                </div>
            </div>
        </div>
        </a>

        <a href="${ctx}/merchant/staff/list">
        <div class="fun border-rm">
            <div class="content">
                <div class="content-inner">
                    <div class="icon"><i class="iconfont">&#xe60d;</i></div>
                    <div class="text"><span>员工设置</span></div>
                </div>
            </div>
        </div>
        </a>

        <div class="fun border-rm">
            <div class="content">
                <div class="content-inner">
                </div>
            </div>
        </div>

        <div class="fun border-m">
            <div class="content">
                <div class="content-inner">
                </div>
            </div>
        </div>
    </div>

    <div class="staff-panel clearfix">
        <div class="my-works">
            <span>我的预约</span>
        </div>

        <div class="staff-footer" data-style="table">
            <div class="staff-link">列表模式</div>
        </div>
    </div>

    <div class="booking-panel">
        <div class="table-style" style="display: none;">
            <#list subscribes as subscribe>
                <div class="booking-table">
                    <div class="booking-info clearfix">
                        <div class="booking-left">
                            <div class="staff-name">
                                <span class="info">会员:</span>
                                <span class="content">${subscribe.memberName}</span>
                                <a class="iconfont" href="tel:${subscribe.memberMobile}">&#xe604;</a>
                            </div>

                            <div class="booking-time">
                                <span class="info">预约时间:</span>
                                <span class="content">${subscribe.subscribeTime?string("yyyy年MM月dd号, HH点")}</span>
                            </div>

                            <div class="booking-state">
                                <span class="info">状态:</span>
                                <span class="content"><#if subscribe.state == "0">已取消<#elseif subscribe.isPassed>已结束<#else>未使用</#if></span>
                            </div>
                        </div>
                    </div>
                    <div class="booking-operate" <#if subscribe.isPassed || subscribe.state == "0">style="display: none;" </#if>>
                        <span>取消预约</span>
                    </div>
                </div>
            </#list>
        </div>

        <div class="date-style">
            <div class="booking-dates">
                <div class="slick-container">
                    <#list dates as date>
                        <div class="date-circle">
                            <div data-day="${date.dayOfYear}" class="booking-date ${date.tabStyle}" data-index="0">
                                <span>${date.dateDesc}</span>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>

            <div class="booking-times">
                <div class="booking-inner">
                    <div class="booking-item clearfix">
                        <div class="booking-time">
                            <div class="start-time">9:00 开始</div>
                            <div class="end-time">10:00结束</div>
                        </div>

                        <div class="booking-member">
                            <span>陈晓波</span>
                            <a class="iconfont" href="tel:18541218792">&#xe604;</a>
                        </div>
                        <a class="booking-state">取消预约</a>
                    </div>
                </div>

                <div class="booking-inner">
                    <div class="booking-item clearfix">
                        <div class="booking-time">
                            <div class="start-time">9:00 开始</div>
                            <div class="end-time">10:00结束</div>
                        </div>

                        <div class="booking-member">
                            <span>陈晓波</span>
                            <a class="iconfont" href="tel:18541218792">&#xe604;</a>
                        </div>
                        <a class="booking-state">取消预约</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>