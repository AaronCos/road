<%--
  Created by IntelliJ IDEA.
  User: 87063
  Date: 2019/11/25
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${path}/resources/js/jquery-2.1.4.min.js" charset="utf-8"></script>
    <link rel="stylesheet" href="${path}/resources/layui/css/layui.css"  media="all">
    <script src="${path}/resources/layui/layui.js" charset="utf-8"></script>
    <script src="${path}/resources/js/vue.js" charset="utf-8"></script>

</head>
<style>
    .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
        top: 50%;
        transform: translateY(-50%);
    }
</style>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">新增</button>
        <button class="layui-btn layui-btn-sm" lay-event="del">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="upload">多图片上传</button>
    </div>
</script>
<body>

<blockquote class="layui-elem-quote news_search">
    <div class="layui-row" id="search">
        <form class="layui-form layui-col-md12 x-so" id="grade_search">
            姓名:
            <div class="layui-input-inline">
                <input type="text" name="username"  autocomplete="off"   class="layui-input" <%--v-model="username"  ref="username"--%>>
            </div>

            年级:
            <div class="layui-input-inline">
                <select  name="grade" id="grade"   autocomplete="off"  <%--v-model="grade" ref='grade'--%>></select>
            </div>

            月份:
            <div class="layui-input-inline">
                <input type="text" name="month" id="month"   autocomplete="off" class="layui-input" <%--v-model="month" ref='month'--%>>
            </div>

            <button class="layui-btn" lay-submit
                    lay-filter="gradeSearch">
                <i class="layui-icon">&#xe615;</i>
            </button>
        </form>
    </div>
    <table class="layui-hide" id="complainTable" lay-filter="complainList"></table>
</blockquote>

<table class="layui-table"  id="studentScore" lay-filter="studentScore">

</table>

<script>
  //vue初始化
 /* var search =  new Vue({
        el: "#search",
        data(){
            return {
                username: "",
                month : ""

            }
        }
    })*/
    //初始化表格
    layui.use(['table','layer','laypage','laydate','form'], function(){
        var table = layui.table,
            layer = layui.layer,
            form = layui.form,
            $ = layui.$,
            laypage = layui.laypage,
            laydate = layui.laydate;

        laydate.render({
            elem: '#month',
            type : 'month',
            format: 'yyyyMM'
        });
        var username = $('#username').val();
        var month = $('#month').val();
        var grade = $('#grade').val();



        $.get('getGradeList.do', {}, function (data) {
            var $html = "<option value=''>请选择年级</option>";
            if(data.data != null){
                $.each(data.data, function (index, item) {
                  $html += "<option value='" + item.grade + "'>" + item.grade + "</option>";
                });
                $("select[name='grade']").append($html);
                //反选
               // $("select[name='???']").val($("#???").val());
                //append后必须从新渲染
                form.render('select');
            }
        })



       /* var username = search.$refs.username.value;
        var month = search.$refs.month.value;*/

        table.render({
            elem: '#studentScore'
            ,url:'findByFrontUsername.do'
            ,method:'POST'
            ,where : { username : username , month : month , grade : grade }
            ,page: true
            ,limit:10
            //,contentType: 'application/json'
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,done : function (res,curr,count){

                $("tbody tr").each(function(){
                    var tdArray = $(this).children();

                    for(var i=0;i<tdArray.length;i++){
                        if(tdArray.eq(i).find("div").html()=="--"){

                            tdArray.eq(i).find('div').parent().data('edit',null).attr('lay-editabled',true);
                        }
                    }
                });
            }
            ,cols: [[
                {field:'iid',type:'checkbox', width:80, title: 'ID', sort: true}
                ,{field:'username',  title: '姓名'}
                ,{field:'grade',  title: '年级'}
                ,{field:'month',  title: '月份'}
                ,{field:'times', title: '次数'}
                ,{field:'chinese', title: '语文', edit: 'text'}
                ,{field:'math', title: '数学',  edit: 'text'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'english', title: '英语',  edit: 'text'}
                ,{field:'physics', title: '物理',  edit: 'text', templet : function(d){
                    if(d.physics!=undefined&&d.physics!=''){
                           return d.physics;
                     }else{
                         return "--";
                     }

                  }}
                ,{field:'chemistry', title: '化学',   edit: 'text', templet : function(d){
                        if(d.chemistry!=undefined&&d.chemistry!=''){
                            return d.chemistry;
                        }else{
                            return "--";
                        }

                    }}
                ,{field:'history', title: '历史',   edit: 'text', templet : function(d){
                        if(d.history!=undefined&&d.history!=''){
                            return d.history;
                        }else{
                            return "--";
                        }

                    }}
                ,{field:'geography', title: '地理',   edit: 'text', templet : function(d){
                        if(d.geography!=undefined&&d.geography!=''){
                            return d.geography;
                        }else{
                            return "--";
                        }

                    }}
                ,{field:'biology', title: '生物',   edit: 'text', templet : function(d){
                        if(d.biology!=undefined&&d.biology!=''){
                            return d.biology;
                        }else{
                            return "--";
                        }

                    }}
                ,{field:'polity', title: '政治',   edit: 'text', templet : function(d){
                        if(d.polity!=undefined&&d.polity!=''){
                            return d.polity;
                        }else{
                            return "--";
                        }

                    }}
                    ,{field:'loginname', title: '总分'}
            ]]
            ,limits: [5,10,20,50]
        });

        //监听头部工具栏事件
        table.on('toolbar(studentScore)', function(obj){

            var checkStatus = table.checkStatus(obj.config.id);

            switch(obj.event){
                case 'add':
                    layer.open({
                        type: 2,
                        title: "添加学生成绩",
                        area: ['35%', '70%'],
                        fix: false,
                        maxmin: true,
                        shadeClose: true,
                        shade: 0.4,
                        skin: 'layui-layer-rim',
                       // btn:['确定','取消'],
                        content:["addStudentGrade.do", "no"],
                        success: function(layer, newWin) { //弹窗成功后回调

                        }
                    });
                  break;
                case 'upload':
                    layer.open({
                        type: 2,
                        title: "图片上传",
                        area: ['35%', '70%'],
                        fix: false,
                        maxmin: true,
                        shadeClose: true,
                        shade: 0.4,
                        skin: 'layui-layer-rim',
                        // btn:['确定','取消'],
                        content:["uploadPics.do", "no"],
                        success: function(layer, newWin) { //弹窗成功后回调

                        }
                    });
                    break;
                case  'del' :
                    //console.log(checkStatus.data);
                    if(checkStatus.data.length==0){
                        layer.alert("请先勾选学生");
                    }else{
                        var ids = "";
                        for (var i = 0; i < checkStatus.data.length; i++) {
                            if(i!=checkStatus.data.length-1){
                                ids = ids  + checkStatus.data[i].iid + ",";
                            }else{
                                ids = ids  + checkStatus.data[i].iid ;
                            }
                            let param = new URLSearchParams();
                            param.append("ids",ids);

                            axios.post('/complat/subjectGrade/deleteSubjectGrade.do', param)
                                .then(function (response) {
                                    if(response.data.success){
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
                                    }else{
                                        layer.alert("删除失败，请稍后再试！") ;
                                    }

                                })
                                .catch(function (error) {
                                    console.log(error);
                                });
                        }
                    }
                    break;

            };
        });

        //监听表格编辑事件
        table.on('edit(studentScore)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            //layer.msg('[ID: '+ data.iid +'] ' + field + ' 字段更改为：'+ value );


            $.ajax({
                url :  "/complat/subjectGrade/updateSubjectGrade.do",
                type : "POST",
                datatype : "json",
                async : true,
                data : {
                    iid : obj.data.iid,
                    subject : obj.field,
                    grade : obj.value
                },
                success:function(data) {
                    layui.table.reload('studentScore');

                },
                error:function(){
                    layer.alert("保存失败，请稍后再试！") ;
                }
            });




        });
        //检索事件
        form.render();
        form.on('submit(gradeSearch)', function(data) {
            var formData = data.field;
            console.debug(formData);
            var username = formData.username;
            var month = formData.month;
            var grade = formData.grade;
            table.reload('studentScore', {
                page: {
                    curr: 1
                },
                where: {
                    username:username,
                    month:month,
                    grade : grade
                },
                method: 'post',
                //contentType: "application/json;charset=utf-8",
                url: 'findByFrontUsername.do',
            });
            return false;
        });




    });



</script>
</body>
</html>
