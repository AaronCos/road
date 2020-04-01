<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${path}/resources/layui/layui.js"></script>
    <link rel="stylesheet" href="${path}/resources/layui/css/layui.css"  media="all">
    <title>修改页面</title>
    <style>
        .layui-input,.layui-textarea{
            max-width: 450px;
        }
    </style>
</head>
<body>
<div style="height: 20px;"></div>


<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">招聘标题</label>
        <div class="layui-input-block">
            <input type="text" name="title" lay-verify="required" lay-reqtext="招聘标题不能为空" autocomplete="on" placeholder="请输入标题" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">选择科目</label>
        <div class="layui-input-block">
            <select name="subject" lay-filter="aihao" lay-verify="required|subject" >
                <option value=""></option>
                <option value="1" selected="">语文</option>
                <option value="2">数学</option>
                <option value="3">外语</option>
                <option value="4">物理</option>
                <option value="5">化学</option>
                <option value="6">历史</option>
                <option value="7">地理</option>
                <option value="8">生物</option>
                <option value="9">政治</option>
            </select>
        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">招聘内容</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容"  name="content" lay-verify="content" class="layui-textarea"></textarea>
        </div>
    </div>

   <%-- <div class="layui-form-item">
        <label class="layui-form-label">性别要求</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="1" title="男">
            <input type="radio" name="sex" value="0" title="女">
            <input type="radio" name="sex" value="2" title="不限" checked="">
        </div>
    </div>--%>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">薪资范围</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="salaryLow" placeholder="￥" lay-verify="required|number" maxlength="5" minlength="3" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="salaryHigh" placeholder="￥" lay-verify="required|number" maxlength="5" minlength="3" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">人事姓名</label>
        <div class="layui-input-block">
            <input type="text" name="humanResource" lay-verify="required" lay-reqtext="联系人是必填项，岂能为空？" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">人事电话</label>
            <div class="layui-input-inline">
                <input type="tel" name="phone" lay-verify="required|phone" autocomplete="on" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">简历邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email" lay-verify="email" autocomplete="on" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">创建日期</label>
        <div class="layui-input-inline">
            <input type="text" name="createTime" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">截止日期</label>
        <div class="layui-input-inline">
            <input type="text" name="endTime" id="date1" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">开启招聘</label>
        <div class="layui-input-block">
            <input type="checkbox" checked="" name="pageshow" value="1" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" lay-submit="" lay-filter="recruit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    layui.use(['form', 'jquery', 'laydate'], function(){
        //$=layui.jquery;
        var form = layui.form
            ,layer = layui.layer
            ,layDate = layui.laydate
            ,$=layui.jquery;//为了使用jquery 的ajax

        //日期
        layDate.render({
            elem: '#date'
            ,showBottom: true
        });
        layDate.render({
            elem: '#date1'
            ,showBottom: true
        });



        //自定义验证规则
        form.verify({
            subject: function (value) {
                if(value.length != 1){
                    return '请选择科目';
                }
            }
            ,content: function(value){
                if(value == ''){
                    return '请填写招聘内容';
                }else if(value.length >500) {
                    return '最多输入500个字';
                }
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.tips('开启后招聘信息将在网站展示',data.other);
        });

        //监听提交
        form.on('submit(recruit)', function(data){
            let dataField = data.field;
            $.ajax({
                url :  "${path}/recruit/add.do",
                type : "POST",
                datatype : "json",
                data : dataField,
                success:function(resp) {
                    layer.msg('保存成功！');
                },
                error:function(){
                    layer.alert("更新失败，请稍后再试！") ;
                }

            });
            window.parent.location.reload();//todo:这种方式不好，不会给出保存成功的提示需要改进
            return false;//不加这个会触发form自己的action地址进行提交
       });




    });
</script>

</body>
</html>
