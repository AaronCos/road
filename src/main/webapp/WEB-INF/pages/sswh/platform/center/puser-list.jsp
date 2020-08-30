<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>管理员列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="${path}/resources/center/css/font.css">
    <link rel="stylesheet" href="${path}/resources/center/css/xadmin.css">
    <script src="${path}/resources/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path}/resources/center/js/xadmin.js"></script>
    <script type="text/javascript" src="${path}/resources/center/js/xsswh.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="layui-fluid">
    <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">管理员管理</a>
            <a><cite>${cite}</cite></a>
          </span>
        <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
           onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
        </a>
    </div>
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="title" placeholder="请输入用户名称" autocomplete="off"
                                   class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit lay-filter="puser_sreach_filter"><i class="layui-icon">&#xe615;</i>
                            </button>
                        </div>
                    </form>
                </div>

                <div class="layui-card-body layui-table-body layui-table-main">
                    <table id="puser-table" class="layui-table layui-form" lay-filter="puser-table-filter">

                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>


<script type="text/html" id="editBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>
<script type="text/html" id="barManual">
    <button class="layui-btn" onclick="xadmin.open('新增用户','${path}/puser/showadd.do',500,300)"><i
            class="layui-icon"></i>添加
    </button>
    <button class="layui-btn layui-btn-danger" lay-event="delpuser"><i class="layui-icon"></i>删除
    </button>
</script>
<script type="text/html" id="is-default">
    <input type="checkbox" name="pageshow" value="{{d.iid}}" lay-skin="switch" lay-text="是|否" lay-filter="pageshow-filter" {{ d.pageshow == 1 ? 'checked': ''}} >
</script>

<script>
    let table;
    layui.use(['laydate', 'form', 'table'], function () {
        var laydate = layui.laydate;
        var form = layui.form;
        table = layui.table;
        //加载table数据
        table.render({
            toolbar: '#barManual',
            elem: '#puser-table',
            //height:400,
            url: '${path}/puser/puser-data.do',
            method: 'get',
            page: true,
            cols: [[
                {field: 'iid', type: 'checkbox', width: 80},
                {field: 'username', title: '用户名称', align: 'center'},
                {field: 'mobilePhone', title: '手机号码', align: 'center'},
                {field: 'idCard', title: '身份证号', align: 'center'},
                {field: 'userUuid', title: '唯一标识', align: 'center'},
            ]],
            limits: [10, 20, 30]
        });
        //支持全局搜索
        form.on('submit(puser_sreach_filter)', function (obj) {
            table.reload('puser-table', {
                where: obj.field
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            }); //只重载数据
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        })

        table.on('tool(puser-table-filter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.open({
                    type: 2,
                    title: "编辑招聘",
                    area: ['40%', '95%'],
                    fix: false,
                    maxmin: true,
                    shadeClose: true,
                    shade: 0.4,
                    skin: 'layui-layer-rim',
                    content: ["${path}/puser/showedit.do?iid=" + data.iid, "yes"],
                    success: function (layer, newWin) { //弹窗成功后回调

                    }
                });
            }
        });


        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
        //监听switch事件，更新pageshow的状态
        form.on('switch(pageshow-filter)', function(obj){
            var state ;
            if(obj.elem.checked){
                state = 1;
            }else{
                state = 0;
            }
            $.ajax({
                url :  "${path}/puser/changepageshow.do",
                type : "POST",
                datatype : "json",
                async : true,
                data : {
                    iid : this.value ,
                    pageshow : state
                },
                success:function(data) {
                },
                error:function(){
                    layer.alert("更新失败，请稍后再试！") ;
                }
            });
        });
        //头工具栏事件
        table.on('toolbar(puser-table-filter)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'delpuser':
                    var data = checkStatus.data;
                    if (data.length == 0) {
                        layer.alert("请先选择数据");
                        break;
                    }
                    var ids = [];
                    for (let i = 0; i < data.length; i++) {
                        ids[i] = data[i].iid;
                    }
                    let results = ids.join(",");
                    layer.confirm('是否确认删除选中信息？', {
                        btn: ['确认', '取消'] //按钮
                    }, function () {
                        delpuser(results);
                        layer.msg('共删除了' + ids.length + '条信息', {icon: 1});

                    }, function () {

                    });
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选' : '未全选');
                    break;
            }
            ;
        });

    });

    function delpuser(ids) {
        $.ajax({
            url: "${path}/puser/delete.do",
            type: "POST",
            datatype: "json",
            async: true,
            data: {ids: ids},
            success: function (data) {
                layer.alert("删除成功！");
                var $ = layui.$;
                table.reload('puser-table');

            },
            error: function () {
                layer.alert("删除失败，请稍后再试！");
            }
        });
    }



</script>
</html>