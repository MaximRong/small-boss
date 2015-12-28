<link rel="stylesheet" href="${e.res("/biz/common/css/inputBlock.css")}">
<div class="input-block hide">
    <div class="tip">请输入姓名</div>
    <div class="text-input hide">
        <input placeholder="请输入姓名"/>

        <div class="delete"><i class="iconfont">&#xe608;</i></div>
    </div>


    <div class="selected-input hide">
        <div class="selected">女</div>
        <div>男</div>
    </div>

    <div class="operate clearfix">
        <div class="input-content">
            <div class="save">确认</div>
            <div class="cancel">取消</div>
        </div>
    </div>
</div>

<div class="error hide">
    <div class="error-content">
        <i class="iconfont">&#xe612;</i>
        <span></span>
    </div>
</div>

<div class="overlay hide"></div>

<script>
    var inputBlockHide = function () {
        $(".overlay").hide();
        $(".input-block > .text-input").hide();
        $(".input-block").hide();
        $(".selected-input").hide();
        $(".operate .save").unbind("click");
    };

    var inputFn = function (param) {
        var elem = param.elem;

        var tip = param.tip;
        $(".input-block > .tip").text("请输入" + tip);
        var val = elem.find(".content").data("val");

        var $inputDiv = $(".input-block > .text-input");
        $inputDiv.find("input").val(val).attr("placeholder", "请输入" + tip);
        var maxlength = param.maxlength;
        maxlength && $inputDiv.find("input").attr("maxlength", maxlength);
        $inputDiv.show();
        var save = param.save;
        $(".operate .save").one("click", function () {
            var value = $inputDiv.find("input").val();
            save && save(value);
            inputBlockHide();
        });

        $(".input-block > .text-input").find("input")[0].focus();
    };

    var selectFn = function (param) {
        var elem = param.elem;

        var tip = param.tip;
        $(".input-block > .tip").text("请输入" + tip);

        var $selectDiv = $(".selected-input");
        $selectDiv.empty();

        var val = elem.find(".content").data("val");
        var options = param.options;
        val = val ? val : Object.keys(options)[0]; // 没有就设为第一个

        $.each(options, function (key, value) {
            var option = "<div ";
            if (key == val) {
                option += "class=\"selected\"";
            }
            option += " data-val=\""+ key +"\">"+ value +"</div>";
            $selectDiv.append(option);
        });
        $selectDiv.show();

        var save = param.save;
        $(".operate .save").one("click", function () {
            var selected = $selectDiv.find(".selected");
            var value = selected.data("val");
            var desc = selected.text();
            save && save(value, desc);
            inputBlockHide();
        });
    };

    $.inputBlock = function (param) {
        $(".overlay").show();
        $(".input-block").show().addClass("block-fadeUp").one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
            $(this).removeClass("block-fadeUp");
        });

        var type = param.type;
        type == "input" && inputFn(param);
        type == "select" && selectFn(param);
    };

    $.inputError = function (errorStr) {
        var $error = $(".error");
        $error.show().addClass("error-pulse").one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
            $error.removeClass("error-pulse");
        });
        $error.find("span").text(errorStr);
        setTimeout("$('.error').hide()", 4000)
    };


    $(".input-block > .text-input").find(".delete").click(function () {
        $(".input-block > .text-input").find("input").val("");
    });

    $(".selected-input").delegate("div", "click", function() {
        $(".selected-input > div").removeClass("selected");
        $(this).addClass("selected");
    });

    $(".overlay").click(function () {
        inputBlockHide();
    });

    $(".operate .cancel").click(function () {
        inputBlockHide();
    });
</script>