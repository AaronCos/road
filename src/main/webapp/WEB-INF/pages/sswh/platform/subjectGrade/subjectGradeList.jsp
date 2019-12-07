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
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>

<script type="text/html" id="toolbarDemo">

    <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon"></i>添加</button>
    </div>
</script>
<body>

<blockquote class="layui-elem-quote news_search">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" id="grade_search">
            姓名:
            <div class="layui-input-inline">
                <input type="text" name="username"  autocomplete="off"   class="layui-input"  v-model='username'>
            </div>

            月份:
            <div class="layui-input-inline">
                <input type="text" name="month" id="month" lay-verify="date"  autocomplete="off" class="layui-input" ref='month'>
            </div>

            <button id="search" class="layui-btn" lay-submit
                    lay-filter="gradeSearch">
                <i class="layui-icon">&#xe615;</i>
            </button>
        </form>
    </div>
    <%--<table class="layui-hide" id="complainTable" lay-filter="complainList"></table>--%>
</blockquote>

<table class="layui-table"  id="studentScore" lay-filter="studentScore">

</table>

<script>
    new Vue({
        el: "#grade_search",

        data: {
            username: null,
            month: null

        }
    })

    layui.use(['table','layer','form','laypage'], function(){
        var table = layui.table,
            layer = layui.layer,
            form = layui.form,
            laypage = layui.laypage;
        //var username = this.$ref.username.value;
       // layer.msg(username);
        var username = this.$refs.username.value;
        table.render({
            elem: '#studentScore'
            ,url:'findByFrontUsername.do'
            ,method:'POST'
            ,where : { username : username , month : '201910' }
            ,page: true
            ,limit:10
            //,contentType: 'application/json'
            //,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'iid',type:'checkbox', width:80, title: 'ID', sort: true}
                ,{field:'username', width:80, title: '用户名'}
                ,{field:'month', width:80, title: '月份'}
                ,{field:'chinese', width:80, title: '语文', edit: 'text'}
                ,{field:'math', title: '数学', width: '80', edit: 'text'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'english', title: '英语',  width:80, edit: 'text'}
                ,{field:'physics', title: '物理', width:80, edit: 'text'}
                ,{field:'chemistry', title: '化学',  width:80, edit: 'text'}
                ,{field:'history', title: '历史',  width:80, edit: 'text'}
                ,{field:'geography', title: '地理',  width:80, edit: 'text'}
                ,{field:'biology', title: '生物',  width:80, edit: 'text'}
                ,{field:'polity', title: '政治',  width:80, edit: 'text'}
            ]]
            ,limits: [5,10,20,50]
        });
        //监听表格编辑事件
        table.on('edit(studentScore)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            //layer.msg('[ID: '+ data.iid +'] ' + field + ' 字段更改为：'+ value );
            let param = new URLSearchParams();
            param.append("iid",data.iid);
            param.append("subject",field);
            param.append("grade",value);

            axios.post('/complat/subjectGrade/updateSubjectGrade.do', param)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });


        });

        form.render();
        form.on('submit(gradeSearch)', function(data) {
            var formData = data.field;
            console.debug(formData);
            var username = formData.username;


            table.reload('studentScore', {
                page: {
                    curr: 1
                },
                where: {
                    username:username,
                    month:'201910'
                },
                method: 'post',
                //contentType: "application/json;charset=utf-8",
                url: 'findByFrontUsername.do',
            });
            return false;
        });


        //监听头部工具栏事件
        table.on('toolbar(test)', function(obj){

            switch(obj.event){
                case 'query':
                    layer.alert('发送查询请求');
                    break;

            };
        });
    });



</script>
</body>
</html>
