<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${path}/resources/layui/layui.js"></script>
    <link rel="stylesheet" href="${path}/resources/layui/css/layui.css"  media="all">
    <title>修改用户</title>
    <style>
        .layui-input,.layui-textarea{
            max-width: 450px;
        }
    </style>
</head>
<body>
<div style="height: 20px;"></div>


<form class="layui-form" action="" lay-filter="puserForm">
    <c:if test="${url != 'add.do'}">
        <input type="hidden" name="iid">
    </c:if>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名称</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" lay-verify="required" lay-reqtext="联系人是必填项，岂能为空？" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-block">
            <input type="text" name="idcard" lay-verify="required" lay-reqtext="身份证号不能为空" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号码</label>
        <div class="layui-input-block">
            <input type="text" name="idcard" lay-verify="required" lay-reqtext="手机号不能为空" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" lay-submit="" lay-filter="${puserurl}">立即提交</button>
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

        var abc =${puser };
        if (abc != 'null' && abc != null && abc != undefined && abc != '') {
            form.val("puserForm",{
                "iid":abc.iid,
                "username":abc.username,
                "password":abc.password,
                "mobilePhone":abc.mobilePhone,
            });
        }

        //自定义验证规则
        form.verify({
            username: function(value){
                if(value == ''){
                    return '请填写用户名内容';
                }else if(value.length >29) {
                    return '最多输入20个字';
                }
            }
        });

        //监听提交
        form.on('submit(puser)', function(data){
            let dataField = data.field;
            $.ajax({
                url :  "${path}/puser/add.do",
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
        //监听提交
        form.on('submit(puser-edit)', function(data){
            let dataField = data.field;
            $.ajax({
                url :  "${path}/puser/edit.do",
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
