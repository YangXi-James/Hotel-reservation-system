$(function() {
    $.ajax({
        type: "POST",
        url: "/getallinformation",
        dataType: "json",
        success: function (result) {
            if(result.id==-1)
            {
                alert("未登录，请登录后查看！");
                window.event.returnValue = false;
                window.location.href = 'toPage?url=/loginForm';
            }
            else{
                $("#realname").text(result.realname);
                $("#nickname").text(result.nickname);
                $("#age").text(result.age);
                $("#email").text(result.email);
                $("#telephone").text(result.telephone);
                $("#ident").text(result.ident);
                $("#address").text(result.address);
            }

        },
    });
})

function getinformation(){
    $.ajax({
        type: "POST",
        url: "/updateinformation",
        dataType: "json",
        data:{
            "realname":$("#realname").text(),
            "nickname":$("#nickname").text(),
            "age":$("#age").text(),
            "email": $("#email").text(),
            "telephone":$("#telephone").text(),
            "ident": $("#ident").text(),
            "address":$("#address").text(),
        },

    });
    if(confirm('修改成功！去首页吗？')==true) {
        window.event.returnValue = false;
        window.location.href="toPage?url=/index";
    }
}