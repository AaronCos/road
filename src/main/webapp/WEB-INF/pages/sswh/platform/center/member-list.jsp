<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
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
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
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
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delUser()"><i class="layui-icon"></i>删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加用户','memberadd.do',600,800)"><i class="layui-icon"></i>添加</button>
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
        <!-- 这里的checked的状态只是演示 -->
        <input type="checkbox" name="status" value="{{d.iid}}"  lay-skin="switch" lay-text="生效|失效" lay-filter="status" {{ d.status == 1 ? 'checked': ''}} >
    </script>

    <script type="text/html" id="isStudent">
        <!-- 这里的checked的状态只是演示 -->
        <input type="checkbox" name="isstudent" value="{{d.iid}}" lay-skin="switch" lay-text="是|否" lay-filter="status" {{ d.isStudent == 1 ? 'checked': ''}} >
    </script>

    <script>
        var table;
      layui.use(['laydate','form','table'], function(){

        var laydate = layui.laydate;
        var  form = layui.form;
        table = layui.table;
        //加载table数据
          table.render({
              elem:'#student-table',
              //height:400,
              url:'../data/findFrontUsers.do',
              method:'post',
              page:true,
              cols:[[
                  {field:'iid',type:'checkbox',title:'ID',fixed:'left'},
                  {field:'username',title:'用户名',fixed:'left'},
                  {field:'sex',title:'性别',fixed:'left'},
                  {field:'mobile',title:'手机号码',fixed:'left'},
                  {field:'email',title:'邮箱',fixed:'left'},
                  {field:'address',title:'地址'},
                  {field:'state',title:'账号状态',templet: '#switchTpl',align :'center'},
                  // {field:'school',title:'学校',width:80},
                  {field:'grade',title:'年级'},
                  {field:'isstudent',title:'是否学生',templet: '#isStudent',align :'center'}
              ]],
              limits : [10,20,30]
          });

          form.render();
          form.on('submit(student_sreach)', function(data) {
              var formData = data.field;
              console.debug(formData);
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



        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });


      });




      function delUser () {
          var ids = [];
          var selectList='';
          //怎么获取选中的行id
          $(".table tbody input[type=checkbox]:checked").map(function () {

              var id = $.trim($(this).closest("tr").find("td:eq(0)").text());
              selectList+=id+',';

          })

          selectList=selectList.substring(0,selectList.length-1);
        console.log(selectList);
       // var checkStatus = table.checkStatus(obj.config.id);
          if(ids.length==0){
              layer.alert("请先勾选学生");
          }else{
              var ids = "";
              for (var i = 0; i < checkStatus.data.length; i++) {
                  if(i!=ids.length-1){
                      ids = ids  + checkStatus.data[i].iid + ",";
                  }else{
                      ids = ids  + checkStatus.data[i].iid ;
                  }
                  $.ajax({
                      url :  "${path}/manager/opr/userdel.do",
                      type : "POST",
                      datatype : "json",
                      async : true,
                      data : {ids : ids},
                      success:function(data) {
                          layer.alert("删除成功！") ;
                          var $ = layui.$;
                          table.reload('studentScore', {
                              page: {
                                  curr: $(".layui-laypage-em").next().html()
                              },
                              where: {
                                  username:$("#username").val(),
                                  month:$("#month").val()
                              },
                              method: 'post',
                              //contentType: "application/json;charset=utf-8",
                              url: 'findByFrontUsername.do',
                          });

                      },
                      error:function(){
                          layer.alert("删除失败，请稍后再试！") ;
                      }
                  });
              }
          }
      }
    </script>
</html>