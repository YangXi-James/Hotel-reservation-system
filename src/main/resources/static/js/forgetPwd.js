function sendcheckCode() {
    let email = $("#email").val()
    if(email==null||email==""){
        console.log("邮箱号不能为空")
        return;
    }
    $.ajax({
        type: "POST",
        url: "/sendcheckCode",
        //stringify方法将js对象转换为字符串
        data: {
            "email": email,
        },
        dataType: "json",
        success: function (response) {
            if (response.code === 200) {
                alert("验证码已发送，请在5分钟内填写验证码")
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

function next()  {
    let email = $.trim($("#email").val());
    let code = $.trim($("#code").val());

    if(email==null||email==""){
        alert("邮箱号不能为空")
        return;
    }

    if(code==null||code==""){
        alert("请填写验证码！")
        return;
    }

    $.ajax({
        type: "POST",
        url: "/check",
        //stringify方法将js对象转换为字符串
        data: {
            "email": email,
            "code":code
        },
        dataType: "json",
        success: function (response) {
            if (response.code === 200) {
                    window.location.href = 'toPage?url=/forgetPwd2';
            } else {
                alert(response.message)
            }
        },
    });
}

function setpassword()  {
    let loginPwd = $.trim($("#loginPwd").val());
    let surePwd = $.trim($("#surePwd").val());

    if(loginPwd==null||loginPwd==""){
        alert("新密码不能为空")
        return;
    }

    if(surePwd==null||surePwd==""){
        alert("请再次填写密码")
        return;
    }

    if(loginPwd != surePwd){
        alert("两次输入的密码不一致")
        return;
    }

    $.ajax({
        type: "POST",
        url: "/setpassword",
        //stringify方法将js对象转换为字符串
        data: {

            "password":loginPwd
        },
        dataType: "json",
        success: function (response) {
            if (response.code === 200) {
                window.location.href = 'toPage?url=/forgetPwd3';
            } else {
                alert(response.message)
                window.location.href = 'toPage?url=/loginForm';
            }
        },
    });
}

function reback() {
    window.location.href = 'toPage?url=/loginForm';
}