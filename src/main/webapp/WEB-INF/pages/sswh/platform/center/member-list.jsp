<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <link rel="stylesheet" href="${path}/resources/center/css/font.css">
        <link rel="stylesheet" href="${path}/resources/center/css/xadmin.css">
        <script src="${path}/resources/center/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${path}/resources/center/js/xadmin.js"></script>
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
             <a href="">会员管理</a>
                <a>
                 <cite>前台用户</cite></a>
          </span>
                <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
                    <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
            </div>
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5">
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="开始日" name="start" id="start">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="截止日" name="end" id="end">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit lay-filter="student_sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>

                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table id="student-table" class="layui-table layui-form" lay-filter="student-table">

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script type="text/html" id="switchTpl">
        <input type="checkbox" name="status" value="{{d.iid}}"  lay-skin="switch" lay-text="生效|失效" lay-filter="status" {{ d.status == 1 ? 'checked': ''}} >
    </script>
    <script type="text/html" id="is-student">
        <input type="checkbox" name="isstudent" value="{{d.iid}}" lay-skin="switch" lay-text="是|否" lay-filter="status" {{ d.beStudent == 1 ? 'checked': ''}} >
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    </script>
    <script type="text/html" id="barManual">
            <button class="layui-btn layui-btn-danger" lay-event="delUser"><i class="layui-icon"></i>删除
            </button>
            <button class="layui-btn" onclick="xadmin.open('添加用户','memberadd.do',1000,80000)"><i class="layui-icon"></i>添加</button>

    </script>

    <script>
        var table;
      layui.use(['laydate','form','table','layer'], function(){

        var laydate = layui.laydate;
        var form = layui.form;
        var layer = layui.layer;
        table = layui.table;
        //加载table数据
          table.render({
              toolbar: '#barManual',
              elem:'#student-table',
              //height:400,
              url:'../data/findFrontUsers.do',
              method:'post',
              page:true,
              cols:[[
                  //gei
                  {field:'iid',type:'checkbox', width:80},
                  {field:'loginname',title:'登录名',align:'center'},
                  {field:'username',title:'用户名',align:'center'},
                  {field:'sex',title:'性别',align:'center', templet : function(d){
                          if(d.sex!=0){
                              return '男';
                          }else{
                              return "女";
                          }

                      }},
                  {field:'mobile',title:'手机号码',align :'center'},
                  {field:'email',title:'邮箱',align:'center'},
                  {field:'address',title:'地址',align :'center'},
                  {field:'state',title:'账号状态',templet: '#switchTpl',align :'center'},
                  {field:'school',title:'学校',align :'center'},
                  {field:'grade',title:'年级',align:'center'},
                  {field:'isstudent',title:'是否学生',templet: '#is-student',align :'center'},
                  {field:'edit',title:'操作',toolbar: '#barDemo',align :'center'},
              ]],
              limits : [10,20,30]
          });

          form.render();
          form.on('submit(student_sreach)', function(data) {
              var formData = data.field;
              var username = formData.username;
              var start = formData.start;
              var end = formData.end;
              table.reload('student-table', {
                  page: {
                      curr: 1
                  },
                  where: {
                      username:username,
                      start:start,
                      end : end
                  },
                  method: 'post',
                  //contentType: "application/json;charset=utf-8",
                  url: '../data/findFrontUsers.do',
              });
              return false;
          });

          form.on('switch(status)', function(obj){

              var state ;
              if(obj.elem.checked){
                  state = 1;
              }else{
                  state = 0;
              }
              $.ajax({
                  url :  "../data/updateStatusOrIsStudent.do",
                  type : "POST",
                  datatype : "json",
                  async : true,
                  data : {
                      iid : this.value ,
                      name : this.name,
                      state : state
                  },
                  success:function(data) {
                  },
                  error:function(){
                      layer.alert("更新失败，请稍后再试！") ;
                  }
              });
          });


          table.on('toolbar(student-table)', function(obj){
              var checkStatus = table.checkStatus(obj.config.id);
                switch (obj.event) {
                    case 'add-user':
                        console.log("hello world");
                        layer.msg("hello");
                        break;
                    case 'delUser':
                        var data = checkStatus.data;
                        if (data.length == 0) {
                            layer.alert("请先选择用户");
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
                            delUser(results);
                            layer.msg('共删除了' + ids.length + '条信息', {icon: 1});

                        }, function () {

                        });
                        break;

                };

          });
          table.on('tool(student-table)', function(obj){
              var data = obj.data;
               if(obj.event === 'edit'){
                   layer.open({
                       type: 2,
                       title: "编辑学生信息",
                       area: ['53%', '95%'],
                       fix: false,
                       maxmin: true,
                       shadeClose: true,
                       shade: 0.4,
                       skin: 'layui-layer-rim',
                       // btn:['确定','取消'],
                       content:["memberedit.do?iid="+data.iid, "yes"],
                       success: function(layer, newWin) { //弹窗成功后回调

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


      });


        function delUser (ids) {
            $.ajax({
                url :  "${path}/manager/opr/userdel.do",
                type : "POST",
                datatype : "json",
                async : true,
                data : {ids : ids},
                success:function(data) {
                    layer.alert("删除成功！") ;
                    var $ = layui.$;
                    table.reload('student-table', {
                        page: {
                            curr: $(".layui-laypage-em").next().html()
                        },
                        where: {
                            username : $("#username").val(),
                            start : $("#start").val(),
                            end : $("#end").val()
                        },
                        method: 'post',
                        //contentType: "application/json;charset=utf-8",
                        url: '../data/findFrontUsers.do',
                    });

                },
                error:function(){
                    layer.alert("删除失败，请稍后再试！") ;
                }
            });
        }
    </script>
</html>