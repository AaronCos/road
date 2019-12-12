<%--
  Created by IntelliJ IDEA.
  User: 87063
  Date: 2019/12/11
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${path}/resources/js/jquery-2.1.4.min.js" charset="utf-8"></script>
    <link rel="stylesheet" href="${path}/resources/layui/css/layui.css"  media="all">
    <script src="${path}/resources/layui/layui.js" charset="utf-8"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<script>
    layui.use(['table','layer','laypage','laydate','form'], function(){
        var layer = layui.layer,
            form = layui.form,
            laydate = layui.laydate;

        laydate.render({
            elem: '#month',
            type : 'month',
            format: 'yyyyMM'
        });

        form.on('submit(submit)', function(data){

            let param = new URLSearchParams();
            param.append("name",data.field.name);
            param.append("month",data.field.month);
            param.append("times",data.field.times);
            param.append("chinese",data.field.chinese);
            param.append("math",data.field.math);
            param.append("english",data.field.english);
            param.append("biology",data.field.biology);
            param.append("physics",data.field.physics);
            param.append("chemistry",data.field.chemistry);
            param.append("history",data.field.history);
            param.append("geography",data.field.geography);
            param.append("polity",data.field.polity);

            axios.post('/complat/subjectGrade/addSubjectGrade.do',param )
                .then(function (response) {
                    if(response.data.success){
                        layer.alert("保存成功！") ;
                        window.parent.location.href = "subjectGradeList.do";
                    }else{
                        layer.alert("保存失败，请稍后再试！") ;
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
            return false;
        });


    });
</script>
<body>
<form class="layui-form" action="">

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="请输入学生姓名" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">月份</label>
            <div class="layui-input-inline">
                <input type="text" id="month" name="month" lay-verify="required"  placeholder="请选择月份" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">语文</label>
            <div class="layui-input-inline">
                <input type="text" name="chinese" lay-verify="number"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">数学</label>
            <div class="layui-input-inline">
                <input type="text" name="math" lay-verify="number" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">英语</label>
            <div class="layui-input-inline">
                <input type="text" name="english" lay-verify="number" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">物理</label>
            <div class="layui-input-inline">
                <input type="text" name="physics" lay-verify="number" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">化学</label>
            <div class="layui-input-inline">
                <input type="text" name="chemistry"  lay-verify="number" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">历史</label>
            <div class="layui-input-inline">
                <input type="text" name="history" lay-verify="number" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">地理</label>
            <div class="layui-input-inline">
                <input type="text" name="geography"  lay-verify="number" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">生物</label>
            <div class="layui-input-inline">
                <input type="text" name="biology" lay-verify="number" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">政治</label>
            <div class="layui-input-inline">
                <input type="text" name="polity" lay-verify="number"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">次数</label>
            <div class="layui-input-inline">
                <input type="text" name="times" lay-verify="number"  autocomplete="off" class="layui-input">
            </div>
        </div>

    </div>
      <div class="layui-form-item">
           <div class="layui-input-block">
             <button lay-submit="" lay-filter="submit" class="layui-btn layui-btn-normal tijiao">提交</button>
             <button type="button" class="layui-btn layui-btn-primary quxiao">取消</button>
           </div>

     </div> 

</form>
</body>
</html>
