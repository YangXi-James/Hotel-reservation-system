function cancel() {
    $.ajax({
        type: "POST",
        url: "/bookingDetail",
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
            } else {
                alert(response.message)
            }
        },
    });
}
