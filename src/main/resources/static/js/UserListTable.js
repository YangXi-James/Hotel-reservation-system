layui.use(['table'], function(){
        var table = layui.table;//使用数据表格

        table.render({
            elem: '#adminList',//选择html中对应的数据表格ID
            url:'showAdminList',//分页提交到spring boot 代码的映射名称
            method:'POST',
            limit:8,//每页显示的记录数量
            limits:[5,8,10,15,20],//可选择每页显示的数量
            page: true,//开启分页

            //设置表头的数组
            //field：后台传回的数字字段名，
            //title：表头文字
            //templet: function(data){} 数据表格请求后台回调函数，处理数据
            //return  表示在对应的列中输出的内容
            cols: [[
                {type:'checkbox',fixed: 'left'},
                {field:'id',width:60,title:'ID'},
                {field:'admin_name', title:'账号'},
                {field:'admim_truename',title:'真实姓名'},
                {field:'admin_sex',width:60,title:'性别',
                    templet: function(data){
                        if(data.admin_sex==1){
                            return 	"<span>男</span>";
                        }else if(data.admin_sex==2){
                            return "<span>女</span>";
                        }else{
                            return "<span>保密</span>";
                        }
                    }
                },
                {field:'create_ip',title:'操作ip',
                    templet: function(data){
                        if(data.create_ip=='0:0:0:0:0:0:0:1'){
                            return "<span>127.0.0.1</span>";
                        }else{
                            return "<span>"+data.create_ip+"</span>";
                        }
                    }
                },
                {field:'state',width:80,title:'状态',
                    templet: function(data){
                        if(data.state==1){
                            return "<span>正常</span>";
                        }else{
                            return "<span>受限</span>";
                        }
                    }
                },
                {fixed: 'right',title:'操作',width:150,
                    templet: function(data){
                        return 	"<a href='AdminInfo?id="+data.id+"' title='查看' class='layui-btn layui-btn-xs layui-btn-normal'><icon class='layui-icon'>&#xe60b;</icon></a>"+
                            "<a href='' title='编辑' class='layui-btn layui-btn-xs layui-btn-normal'><icon class='layui-icon'>&#xe642;</icon></a>"+
                            "<a href='' title='删除' class='layui-btn layui-bg-red layui-btn-xs layui-btn-normal'><icon class='layui-icon'>&#xe640;</icon></a>";
                    }
                }
            ]],
            done:function(res, curr, count){
                console.log("表格渲染完成：");
                console.log(res);
                console.log(curr);
                console.log(count);
            }

        });
    });

