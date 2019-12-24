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
    <%--<script src="${path}/resources/js/axios.min.js"></script>--%>
</head>
<script>
    layui.use(['table','layer','laypage','laydate','form'], function(){
        var layer = layui.layer,
            form = layui.form,
            laydate = layui.laydate;
        var gradeList;
        laydate.render({
            elem: '#month',
            type : 'month',
            format: 'yyyyMM'
        });

        var allGrade1 = "chinese,math,english,physics,chemistry,history,geography,biology,polity".split(",");
        for (let i = 0; i < allGrade1.length; i++) {
            $("#"+allGrade1[i]).css("display","block")
        }

        form.verify({
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            score: function(value, item) { //昵称 value：表单的值、item：表单的DOM对象
                if (value.length > 0 && !/(^[\-0-9][0-9]*(.[0-9]+)?)$/) {
                    return '请填入数字'
                }
            }
        });

        $.get('getGradeList.do', {}, function (data) {
            var $html = "<option value=''>请选择年级</option>";
            if(data.data != null){
                gradeList = data.data;
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

        form.on('select(grade)', function(data) {
            var grade = data.value;
            var gradeArray;
            var allGrade = "chinese,math,english,physics,chemistry,history,geography,biology,polity".split(",");
            for (let i = 0; i < allGrade.length; i++) {
                $("#"+allGrade[i]).css("display","none")
            }
            $.each(gradeList, function (index, item) {
                if(grade==""){
                    grade = "九";
                }
               if(grade==item.grade){
                   gradeArray = item.subject.split(",");
               }
            });
            for (let i = 0; i < gradeArray.length; i++) {
                $("#"+gradeArray[i]).css("display","block")
            }

        });

        form.on('submit(submit)', function(data){

            $.ajax({
                url :  "/complat/subjectGrade/addSubjectGrade.do",
                type : "POST",
                datatype : "json",
                async : true,
                data : data.field,
                success:function(data) {
                    layer.alert("保存成功！") ;
                    window.parent.location.href = "subjectGradeList.do";

                },
                error:function(){
                    layer.alert("保存失败，请稍后再试！") ;
                }
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
        <div class="layui-inline" style="margin-left: -15px">
            <label class="layui-form-label">月份</label>
            <div class="layui-input-inline">
                <input type="text" id="month" name="month" lay-verify="required"  placeholder="请选择月份" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">年级</label>
            <div class="layui-input-inline">
                <select  name="grade" id="grade"  lay-verify="required"  autocomplete="off"  lay-filter="grade" ></select>
            </div>
        </div>
        <div class="layui-inline" style="margin-left: -15px">
            <label class="layui-form-label">次数</label>
            <div class="layui-input-inline">
                <input type="text" name="times" lay-verify="number"  autocomplete="off" class="layui-input">
            </div>
        </div>

    </div>
    <div class="layui-form-item">
        <div class="layui-inline" id="chinese">
            <label class="layui-form-label">语文</label>
            <div class="layui-input-inline">
                <input type="text" name="chinese"  lay-verify="score"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline" id="math">
            <label class="layui-form-label">数学</label>
            <div class="layui-input-inline">
                <input type="text" name="math"  lay-verify="score" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline" id="english">
            <label class="layui-form-label">英语</label>
            <div class="layui-input-inline">
                <input type="text" name="english"  lay-verify="score" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline" id="physics">
            <label class="layui-form-label">物理</label>
            <div class="layui-input-inline">
                <input type="text" name="physics"  lay-verify="score" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline" id="chemistry">
            <label class="layui-form-label">化学</label>
            <div class="layui-input-inline">
                <input type="text" name="chemistry"   lay-verify="score" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline" id="history" >
            <label class="layui-form-label">历史</label>
            <div class="layui-input-inline">
                <input type="text" name="history" lay-verify="score" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline" id="geography">
            <label class="layui-form-label">地理</label>
            <div class="layui-input-inline">
                <input type="text" name="geography"   lay-verify="score" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline" id="biology">
            <label class="layui-form-label">生物</label>
            <div class="layui-input-inline">
                <input type="text" name="biology"  lay-verify="score" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline" id="polity">
            <label class="layui-form-label">政治</label>
            <div class="layui-input-inline">
                <input type="text" name="polity"  lay-verify="score"  autocomplete="off" class="layui-input">
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
