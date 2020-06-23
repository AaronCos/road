<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${path}/resources/layui/layui.js"></script>
    <link rel="stylesheet" href="${path}/resources/layui/css/layui.css"  media="all">
    <title>机构修改</title>
    <style>
        .layui-input,.layui-textarea{
            max-width: 450px;
        }
    </style>
</head>
<body>
<div style="height: 20px;"></div>


<form class="layui-form" action="" lay-filter="groupForm">
    <c:if test="${url != 'add.do'}">
        <input type="hidden" name="iid">
    </c:if>
    <div class="layui-form-item">
        <label class="layui-form-label">机构名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="required" lay-reqtext="机构名称不能为空" autocomplete="on" placeholder="请输入机构名称" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">机构描述</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容"  name="spec" lay-verify="content" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">父级机构</label>
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

    <div class="layui-form-item">
        <label class="layui-form-label">唯一编码</label>
        <div class="layui-input-block">
            <input type="text" name="codeid"  placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">拼音</label>
            <div class="layui-input-inline">
                <input type="tel" name="pinyin"  class="layui-input">
            </div>
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

        var abc =${group };
        if (abc != 'null' && abc != null && abc != undefined && abc != '') {
            form.val("groupForm",{
                "iid":abc.iid,
                "title":abc.title,
                "subject":abc.subject,
                "content":abc.content,
                "salaryLow":abc.salaryLow,
                "salaryHigh":abc.salaryHigh,
                "humanResource":abc.humanResource,
                "phone":abc.phone,
                "email":abc.email,
                "createTime":abc.createTime,
                "endTime":abc.endTime,
                "pageshow":abc.pageshow
            });
        }




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
        form.on('submit(group)', function(data){
            let dataField = data.field;
            $.ajax({
                url :  "${path}/group/add.do",
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
        form.on('submit(group-edit)', function(data){
            let dataField = data.field;
            $.ajax({
                url :  "${path}/group/edit.do",
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
