
$(function () {
    $(".email-signup").hide();
    $("#signup-box-link").click(function(){
        $(".email-login").fadeOut(100);
        $(".email-signup").delay(100).fadeIn(100);
        $("#login-box-link").removeClass("active");
        $("#signup-box-link").addClass("active");
    });
    $("#login-box-link").click(function(){
        $(".email-login").delay(100).fadeIn(100);
        $(".email-signup").fadeOut(100);
        $("#login-box-link").addClass("active");
        $("#signup-box-link").removeClass("active");
    });
})

function sendCode() {
    let email = $("#email").val()
    if(email==null||email==""){
        console.log("邮箱号不能为空")
        return;
    }
    $.ajax({
        type: "POST",
        url: "/sendCode",
        //stringify方法将js对象转换为字符串
        data: {
            "email": email,
        },
        dataType: "json",
        success: function (response) {
            if (response.code === 200) {
                alert("验证码已发送，请在5分钟内完成注册")
                invokeSetTime("#getCode")
            } else {
                alert(response.message)
            }
        },
    });
}

/**
 * 发送邮件后定时60秒
 * @param obj
 */
function invokeSetTime(obj){
    let countdown = 60;
    setTime(obj);
    function setTime(obj) {
        if (countdown === 0) {
            $(obj).attr("disabled",false);
            $(obj).attr("value","获取验证码");
            countdown = 60;
            return;
        } else {
            $(obj).attr("disabled",true);
            $(obj).attr("value", countdown + "s 重新发送");
            countdown--;
        }
        setTimeout(function() {setTime(obj)},1000);
    }
}


function register() {
    let email = $.trim($("#email").val());
    let nickname = $.trim($("#nickname").val());
    let pwd = $.trim($("#pwd").val());
    let code = $.trim($("#code").val());

    if(email==null||email==""){
        alert("邮箱号不能为空")
        return;
    }
    if(nickname ==null|| nickname ==""){
        alert("昵称不能为空")
        return;
    }
    if(pwd ===null||pwd ===""){
        alert("密码不能为空")
        return;
    }
    if(code==null||code==""){
        alert("请填写验证码！")
        return;
    }

    $.ajax({
        type: "POST",
        url: "/register",
        data: {
            "email": email,
            "nickname":nickname,
            "password":pwd,
            "code":code
        },
        dataType: "json",
        success: function (response) {
            if (response.code === 200) {
                alert("注册成功，快去登录吧！");
                window.event.returnValue = false;
                window.location.href = 'toPage?url=/loginForm';

            } else {
                alert(response.message)
            }
        },
    });
}

function login() {
    let nickname  = $("#loginnickname").val();
    let pwd = $("#loginPwd").val();
    let identity=$("#login_identity").val();
    if(nickname==null||nickname.trim().length === 0){
        alert("昵称不能为空")
        return;
    }
    if(pwd ===null||pwd ===""){
        alert("密码不能为空")
        return;
    }
    if(identity ===null||identity ===""){
        alert("验证码不能为空")
        return;
    }
    $.ajax({
        type: "POST",
        url: "/login",
        data: {
            "nickname": nickname,
            "password":pwd,
            "identity":identity
        },
        dataType: "json",
        success: function (response) {
            if (response.code === 200) {
                alert("登录成功！");
                window.event.returnValue = false;
                window.location.href = 'toPage?url=/index';
            }
            else if(response.code === 999) {
                alert("欢迎您，管理员！");
                window.location.href = 'toPage?url=/backStage';
            }
            else {
                alert(response.message)
            }
        },
    });

}

function getVerify(obj){
    obj.src = "./getVerify?"+Math.random()
}


