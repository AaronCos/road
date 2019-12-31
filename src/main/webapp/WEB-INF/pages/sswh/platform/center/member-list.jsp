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
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加用户','memberadd.do',600,400)"><i class="layui-icon"></i>添加</button>
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
      layui.use(['laydate','form','table'], function(){

        var laydate = layui.laydate;
        var  form = layui.form;
        var table = layui.table;
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



      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }



      function delAll (argument) {
        var ids = [];

        // 获取选中的id 
        $('tbody input').each(function(index, el) {
            if($(this).prop('checked')){
               ids.push($(this).val())
            }
        });
  
        layer.confirm('确认要删除吗？'+ids.toString(),function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
</html>