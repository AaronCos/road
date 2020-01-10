<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>后台注册</title>
    <!-- CSS -->
    <%--<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">--%>
    <link rel="stylesheet" href="${path}/resources/layui/css/layui.css"  media="all">
    <script src="${path}/resources/layui/layui.js" charset="utf-8"></script>
    <link rel="stylesheet" href="${path}/resources/js/city-picker/citypicker.css"  />
    <script src="${path}/resources/js/city-picker/city-picker.data.js"></script>
    <script src="${path}/resources/js/loginjs/jquery-1.11.1.min.js"></script>


    <link rel="stylesheet" href="${path}/resources/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/resources/css/logincss/font-awesome.min.css">
    <link rel="stylesheet" href="${path}/resources/css/logincss/form-elements.css">
    <link rel="stylesheet" href="${path}/resources/css/logincss/style.css">

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="${path}/resources/images/loginimages/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${path}/resources/images/loginimages/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${path}/resources/images/loginimages/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${path}/resources/images/loginimages/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${path}/resources/images/loginimages/apple-touch-icon-57-precomposed.png">
    <style type="text/css">
        .error {
            display: inline-block;
            border: 1px solid #ff835a;
            background-color: #ffe8e0;
        }
        .current {
            background: #ffdc9a;
            font-weight: bold;
            color: #663300;
        }
    </style>
</head>
<body>
<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container" style="margin-top: -134px">

            <div class="row" style="height: 1300px;">
                <div class="col-sm-6 col-sm-offset-3 form-box" style="height: 1300px;">
                   <%-- <div class="form-top">
                        <div class="form-top-left">
                            <h3>登陆系统</h3>
                            <p>输入用户名和密码进行登陆:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>--%>
                    <div class="form-bottom" style="height: 900px;">
                        <form class="layui-form">
                            <div class="layui-form-item">
                                <label for="L_loginname" class="layui-form-label">
                                    <span class="x-red">*</span>
                                    登录名
                                </label>
                                <div class="layui-input-inline">

                                    <input type="text" id="loginname" name="loginname" required="" lay-verify="nikename" "
                                           autocomplete="off" class="layui-input"></div>
                                <div class="layui-form-mid layui-word-aux">
                                    <span class="x-red">*</span>将会成为您唯一的登入名
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="L_pass" class="layui-form-label">
                                    <span class="x-red">*</span>密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_pass" name="password" required="" lay-verify="pass" autocomplete="off"
                                           class="layui-input"></div>
                                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_repass" class="layui-form-label">
                                    <span class="x-red">*</span>确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_repass" name="repass" required="" lay-verify="repass"
                                           autocomplete="off" class="layui-input"></div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_username" class="layui-form-label">
                                    <span class="x-red">*</span>用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_username" name="username" required="" lay-verify="nikename"
                                           autocomplete="off" class="layui-input"></div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_username" class="layui-form-label">
                                    <span class="x-red">*</span>性别</label>
                                <div class="layui-input-inline">
                                    <select id="sex" name="sex" lay-verify="required">
                                        <option value="1">男</option>
                                        <option value="0">女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_username" class="layui-form-label">
                                    <span class="x-red">*</span>出生年月</label>
                                <div class="layui-input-inline">
                                    <input class="layui-input"  autocomplete="off"  name="birthday" id="birthday" lay-verify="date">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_username" class="layui-form-label">
                                    <span class="x-red">*</span>身份证号</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="identity" name="identity" required="" lay-verify="identity"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label class="layui-form-label width_auto text-r" style="margin-top:2px">省市县：</label>
                                    <div class="layui-input-inline" style="width:400px;margin-left: -20px;">
                                        <input type="text" lay-verify="required" autocomplete="on" class="layui-input" id="city-picker" name="city_picker" readonly="readonly" data-toggle="city-picker" placeholder="请选择">
                                    </div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_username" class="layui-form-label">
                                    <span class="x-red">*</span>学校</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="school" name="school" required="" lay-verify="required"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_username" class="layui-form-label">
                                    <span class="x-red">*</span>年级</label>
                                <div class="layui-input-inline">
                                    <select  name="grade" id="grade"  lay-verify="required"  autocomplete="off"  lay-filter="grade" ></select>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_email" class="layui-form-label">
                                    <span class="x-red">*</span>手机</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_mobile" name="mobile" required="" lay-verify="phone" autocomplete="off"
                                           class="layui-input"></div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_email" class="layui-form-label">
                                    <span class="x-red">*</span>邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_email" name="email" required="" lay-verify="email" autocomplete="off"
                                           class="layui-input"></div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_repass" class="layui-form-label"></label>
                                <button class="layui-btn" lay-filter="add" lay-submit="" style="margin-left: 126px;">保存</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script>

    layui.config({
        base: '${path}/resources/js/city-picker/' //静态资源所在路径
    }).use(['laydate','form', 'layer', 'jquery', 'citypicker'],
        function () {
            $ = layui.jquery;
            var form = layui.form,
                layer = layui.layer,
                laydate = layui.laydate ,
                cityPicker = layui.citypicker;

            var currentPicker = new cityPicker("#city-picker", {
                provincename:"provinceId",
                cityname:"cityId",
                districtname: "districtId",
                level: 'districtId',// 级别
            });


            //自定义验证规则
            form.verify({
                nikename: function (value) {
                    if (value.length < 5) {
                        return '昵称至少得5个字符啊';
                    }
                },
                pass: [/(.+){6,12}$/, '密码必须6到12位'],
                repass: function (value) {
                    if ($('#L_pass').val() != $('#L_repass').val()) {
                        return '两次密码不一致';
                    }
                }
            });

            $.get('${path}/subjectGrade/getGradeList.do', {}, function (data) {
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
                    if(${frontuser !=null}){
                        $("#grade option[value='"+grade+"']").prop("selected",true);
                    }
                    form.render('select');
                }
            })



                currentPicker.setValue("江苏省/南京市/玄武区");
                $("#iid").val('0');
                laydate.render({
                    elem: '#birthday', //指定元素
                    format: 'yyyy-MM-dd'
                });



            //监听提交
            form.on('submit(add)', function (data) {

                    $.post('${path}/manager/opr/useradd.do', data.field, function (result) {
                        if (result.success === 1) {
                            layer.alert('注册成功！', {
                                icon: 6
                            }, function () {
                                window.location.href = "login.do";
                            });
                        } else {
                            layer.alert(result.message);
                            return;
                        }
                    })

                return false;
            });

        });
</script>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>


<!-- Javascript -->


<!--[if lt IE 10]>
<script src="${path}/resources/js/loginjs/placeholder.js"></script>
<![endif]-->
</body>
</html>