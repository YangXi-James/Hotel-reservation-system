
$(function() {
    $.ajax({
        type: "POST",
        url: "/findStandard",
        dataType: "json",


        success: function (data) {
            var str = "";
            $.each(data, function() {
                str += "<li>"+
                    '<div class="">'+
                    '<div>'+
                    '<img style="width=200px;height=200px" src="'+this.roomphoto_url+'" alt=""/>'+
                    '</div>'+
                    '<div style="padding-top:20px;">'+
                    '</div>'+
                    '<div>'+
                    '<h4>'+'类型：'+this.bed+'人间'+'</h4>'+
                    '<h4>'+'楼层：'+this.storey+'</h4>'+
                    '<h4>'+'是否提供热水：'+this.weather_hotwater+'</h4>'+
                    '<h4>'+'是否提供wifi：'+this.weather_wifi+'</h4>'+
                    '<h4>'+'剩余房间数：'+this.room_number+'</h4>'+
                    '<h4>'+'早餐：'+this.breakfast+'人餐'+'</h4>'+
                    '<h4>'+'设施服务：'+this.equipment+'</h4>'+
                    '</div>'+
                    '<div style="padding-top:20px;">'+
                    '</div>'+
                    '<form method="get" action="/toBooking">'+
                    "价格:"+this.price+
                    '<input style="display: none" name="standard_id" type="text" value="'+this.standard_id+'">'+
                    '<input style="display: none" name="price" type="text" value="'+this.price+'">'+
                    '<input style="margin-top: 0px;margin-left: 20px" type="submit" value="预订">'+
                    '</form>'+
                    '<div style="padding-top:60px;">'+
                    '</div>'+
                    "</li>";

                //str += "<li>"+"<img src="+this.roomphoto_url+"/>"+"价格"+this.price+'<div style="padding-top:60px;">'+'</div>'+"</li>";


            });
            $("#roomresult").append(str);

        }
    });
});