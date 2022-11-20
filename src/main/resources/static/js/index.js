$(function() {
    $.ajax({
        type: "POST",
        url: "/getweatherlogin",
        dataType: "json",
        success: function (result) {
            if(result==0) {
                $('#order').hide();
                $('#cancellation').hide();
            }
            else {
                $('#register').hide();
                $('#login').hide();
            }
        },
    });
})

function cancellogin(){
    $.ajax({
        type: "POST",
        url: "/cancellogin",
        dataType: "json",
        success: function () {
        },
    });
    if( confirm('确定要注销吗？')==true) {
        window.event.returnValue = false;
        window.location.href = "toPage?url=/loginForm"
    }
}

$(function() {
    $.ajax({
        type: "POST",
        url: "/findCountry",
        dataType: "json",
        success: function (result) {
            $('#country option').remove();
            $('#country').append("<option value='0' selected='selected'>-- 请选择 --</option>");
            for (let i in result) {
                $('#country').append("<option value='" + result[i].country_id + "'>" + result[i].country_name + "</option>")
            }
        },
        error: function () {
            alert("获取数据失败!");
        },
    });
})

$(function () {
    $('#country').change(function () {
        $.ajax({
            type: "POST",
            url: "/findProvince",
            data: {
                "country_id": $(this).val(),
            },
            dataType: "json",
            success: function (result) {
                $('#province option').remove();
                $('#province').append("<option value='0' selected='selected'>-- 请选择 --</option>");
                for (let i in result) {
                    $('#province').append("<option value='" + result[i].province_id + "'>" + result[i].province_name + "</option>")
                }
            }
        });
    });
});

$(function () {
    $('#province').change(function () {
        $.ajax({
            type: "POST",
            url: "/findCity",
            data: {
                "province_id": $(this).val(),
            },
            dataType: "json",
            success: function (result) {
                $('#city option').remove();
                $('#city').append("<option value='0' selected='selected'>-- 请选择 --</option>");
                for (let i in result) {
                    $('#city').append("<option value='" + result[i].city_id + "'>" + result[i].city_name + "</option>")
                }
            }
        });
    });
});


$(function () {
    $('#city').change(function () {
        $.ajax({
            type: "POST",
            url: "/findDistinction",
            data: {
                "city_id": $(this).val(),
            },
            dataType: "json",
            success: function (result) {
                $('#distinction option').remove();
                $('#distinction').append("<option value='0' selected='selected'>-- 请选择 --</option>");
                for (let i in result) {
                    $('#distinction').append("<option value='" + result[i].distinct_id + "'>"  + result[i].distinct_name + "</option>")
                }
            }
        });
    });
});


function search() {
    $.ajax({
        type: "POST",
        url: "/findHotel",
        data: {
            "distinct_id": $('#distinction').val(),
        },
        dataType: "json",
        success: function (result) {
            $("#test").empty();
            let i=0;
            if(result.length%2==0)
            {
                for(let i=0; i+1 <result.length ; i=i+2) {
                    all ='<li id="hotellist">'+
                        /*图片1*/
                        "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                        '<img  style="float: left;width: 200px; height: 200px;" class="one" id="' +  result[i].hotel_id + '"  src="' + result[i].photo_address + '" />' +
                        "</a>"+
                        /*名称1*/
                        '<div style="float: left; margin-top: 80px;font-size: 25px;"class="one" id="' +  result[i].hotel_id + '">' +"<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+ result[i].hotel_name +
                        "</a>"+'</div>'+
                        /*名称2*/
                        '<div style="float: right;margin-top: 80px;font-size: 25px;"class="one" id="' +  result[i+1].hotel_id + '">' + "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+result[i+1].hotel_name +
                        "</a>"+'</div>'+
                        /*图片2*/
                        "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                        '<img  style="float: right;width: 200px; height: 200px;" class="one" id="' +  result[i+1].hotel_id+ '"  src="' + result[i+1].photo_address + '"/>'+
                        "</a>"+
                        /*间隔*/
                        '<div style="padding-top:300px;">'+'</div>'+
                        '</li>'
                    $("#test").append( all);
                }
            }
            else{
                for( i=0;i+2 <result.length ; i=i+2) {
                    all ='<li id="hotellist">'+
                        /*图片1*/
                        "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                        '<img  style="float: left;width: 200px; height: 200px;" class="one" id="' + result[i].hotel_id + '"  src="' + result[i].photo_address + '" />' +
                        "</a>"+
                        /*名称1*/
                        '<div style="float: left; margin-top: 80px;font-size: 25px;"class="one" id="' + result[i].hotel_id + '">' +"<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+ result[i].hotel_name +
                        "</a>"+'</div>'+
                        /*名称2*/
                        '<div style="float: right;margin-top: 80px;font-size: 25px;"class="one" id="' + result[i+1].hotel_id + '">' + "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+result[i+1].hotel_name +
                        "</a>"+'</div>'+
                        /*图片2*/
                        "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                        '<img  style="float: right;width: 200px; height: 200px;" class="one" id="' + result[i+1].hotel_id + '"  src="' + result[i+1].photo_address + '"/>'+
                        "</a>"+
                        /*间隔*/
                        '<div style="padding-top:300px;">'+'</div>'+
                        '</li>'
                    $("#test").append( all);
                }
                it = '<li id="hotellist">'+
                    /*图片1*/
                    "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                    '<img  style="float: left;width: 200px; height: 200px;" class="one" id="' + result[i].hotel_id + '"  src="' + result[i].photo_address + '" />' +
                    "</a>"+
                    /*名称1*/
                    '<div style="float: left; margin-top: 80px;font-size: 25px;"class="one" id="' + result[i].hotel_id + '">' +"<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+ result[i].hotel_name +
                    "</a>"+'</div>'+
                    '</li>'
                $("#test").append(it);
            }

        }
    });
}


function searchname() {
    let information = $("#information").val()
    if(information==null||information==""){
        alert("请输入您要搜索的酒店")
        return;
    }
    $.ajax({
        type: "POST",
        url: "/findHotelname",
        data: {
            "hotelname": information,
        },
        dataType: "json",
        success: function (result) {
            if(result.length == 0) {
                alert("未找到酒店，换个关键字试试");
            }
            else {
                $("#test").empty();
                let i=0;
                if(result.length%2==0)
                {
                    for(let i=0; i+1 <result.length ; i=i+2) {
                        all ='<li id="hotellist">'+
                            /*图片1*/
                            "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                            '<img  style="float: left;width: 200px; height: 200px;" class="one" id="' + result[i].hotel_id + '"  src="' + result[i].photo_address + '" />' +
                            "</a>"+
                            /*名称1*/
                            '<div style="float: left; margin-top: 80px;font-size: 25px;"class="one" id="' + result[i].hotel_id + '">' +"<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+ result[i].hotel_name +
                            "</a>"+'</div>'+
                            /*名称2*/
                            '<div style="float: right;margin-top: 80px;font-size: 25px;"class="one" id="' + result[i+1].hotel_id + '">' + "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+result[i+1].hotel_name +
                            "</a>"+'</div>'+
                            /*图片2*/
                            "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                            '<img  style="float: right;width: 200px; height: 200px;" class="one" id="' + result[i+1].hotel_id + '"  src="' + result[i+1].photo_address + '"/>'+
                            "</a>"+
                            /*间隔*/
                            '<div style="padding-top:300px;">'+'</div>'+
                            '</li>'
                        $("#test").append( all);
                    }
                }
                else{
                    for( i=0;i+2 <result.length ; i=i+2) {
                        all ='<li id="hotellist">'+
                            /*图片1*/
                            "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                            '<img  style="float: left;width: 200px; height: 200px;" class="one" id="' + result[i].hotel_id + '"  src="' + result[i].photo_address + '" />' +
                            "</a>"+
                            /*名称1*/
                            '<div style="float: left; margin-top: 80px;font-size: 25px;"class="one" id="' + result[i].hotel_id + '">' +"<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+ result[i].hotel_name +
                            "</a>"+'</div>'+
                            /*名称2*/
                            '<div style="float: right;margin-top: 80px;font-size: 25px;"class="one" id="' + result[i+1].hotel_id + '">' + "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+result[i+1].hotel_name +
                            "</a>"+'</div>'+
                            /*图片2*/
                            "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                            '<img  style="float: right;width: 200px; height: 200px;" class="one" id="' + result[i+1].hotel_id + '"  src="' + result[i+1].photo_address + '"/>'+
                            "</a>"+
                            /*间隔*/
                            '<div style="padding-top:300px;">'+'</div>'+
                            '</li>'
                        $("#test").append( all);
                    }
                    it ='<li id="hotellist">'+
                        /*图片1*/
                        "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                        '<img  style="float: left;width: 200px; height: 200px;" class="one" id="' + result[i].hotel_id + '"  src="' + result[i].photo_address + '" />' +
                        "</a>"+
                        /*名称1*/
                        '<div style="float: left; margin-top: 80px;font-size: 25px;"class="one" id="' + result[i].hotel_id + '">' +"<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+ result[i].hotel_name +
                        "</a>"+'</div>'+
                        '</li>'
                    $("#test").append(it);
                }

            }
        }

    });
}



$(function() {
    $.ajax({
        type: "POST",
        url: "/findallhotel",
        dataType: "json",
        success: function (result) {
            $("#test").empty();
            let i=0;
            if(result.length%2==0)
            {
                for(let i=0; i+1 <result.length ; i=i+2) {
                    all ='<li id="hotellist">'+
                        /*图片1*/
                        "<a href='toPage?url=/hotelinfo.html' >"+
                        '<img  style="float: left;width: 200px; height: 200px;" class="one" id="' + result[i].hotel_id + '"  src="' + result[i].photo_address + '" />' +
                        "</a>"+
                        /*名称1*/
                        '<div style="float: left; margin-top: 80px;font-size: 25px;"class="one" id="' + result[i].hotel_id + '">' +"<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+ result[i].hotel_name +
                        "</a>"+'</div>'+
                        /*名称2*/
                        '<div style="float: right;margin-top: 80px;font-size: 25px;"class="one" id="' + result[i+1].hotel_id + '">' + "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+result[i+1].hotel_name +
                        "</a>"+'</div>'+
                        /*图片2*/
                        "<a href='toPage?url=/hotelinfo.html' >"+
                        '<img  style="float: right;width: 200px; height: 200px;" class="one" id="' + result[i+1].hotel_id + '"  src="' + result[i+1].photo_address + '"/>'+
                        "</a>"+
                        /*间隔*/
                        '<div style="padding-top:300px;">'+'</div>'+
                        '</li>'
                    $("#test").append( all);
                }
            }
            else{
                for( i=0;i+2 <result.length ; i=i+2) {
                    all ='<li id="hotellist">'+
                        /*图片1*/
                        "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                        '<img  style="float: left;width: 200px; height: 200px;" class="one" id="' + result[i].hotel_id + '"  src="' + result[i].photo_address + '" />' +
                        "</a>"+
                        /*名称1*/
                        '<div style="float: left; margin-top: 80px;font-size: 25px;"class="one" id="' + result[i].hotel_id + '">' +"<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+ result[i].hotel_name +
                        "</a>"+'</div>'+
                        /*名称2*/
                        '<div style="float: right;margin-top: 80px;font-size: 25px;"class="one" id="' + result[i+1].hotel_id + '">' + "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+result[i+1].hotel_name +
                        "</a>"+'</div>'+
                        /*图片2*/
                        "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                        '<img  style="float: right;width: 200px; height: 200px;" class="one" id="' + result[i+1].hotel_id + '"  src="' + result[i+1].photo_address + '"/>'+
                        "</a>"+
                        /*间隔*/
                        '<div style="padding-top:300px;">'+'</div>'+
                        '</li>'
                    $("#test").append( all);
                }
                it = '<li id="hotellist">'+
                    /*图片1*/
                    "<a href='toPage?url=/hotelinfo.html' onclick='choose()'>"+
                    '<img  style="float: left;width: 200px; height: 200px;" class="one" id="' + result[i].hotel_id + '"  src="' + result[i].photo_address + '" />' +
                    "</a>"+
                    /*名称1*/
                    '<div style="float: left; margin-top: 80px;font-size: 25px;" class="one" id="' + result[i].hotel_id + '">' +"<a href='toPage?url=/hotelinfo.html' >"+ result[i].hotel_name +
                    "</a>"+'</div>'+
                    '</li>'
                $("#test").append(it);
            }

        },
        error: function () {
            alert("获取数据失败!");
        },
    });
})

$(document).on("click",".one",function() {

    $.ajax({
        type: "POST",
        url: "/sendHotel",
        dataType: "json",
        data: {
            hotel_id: $(this).attr('id')
        },
        success: function () {

        }
    })

})