<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${path}/resources/center/css/font.css">
    <link rel="stylesheet" href="${path}/resources/center/css/xadmin.css">
    <link rel="stylesheet" href="${path}/resources/js/city-picker/citypicker.css"  />
    <script src="${path}/resources/center/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${path}/resources/center/js/xadmin.js"></script>

    <script src="${path}/resources/js/city-picker/city-picker.data.js"></script>

    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item">
                <label for="L_loginname" class="layui-form-label">
                    <span class="x-red">*</span>
                    登录名
                </label>
                <div class="layui-input-inline">
                    <input type="hidden" id="iid" name = "iid" value="${frontuser.iid}">
                    <input type="text" id="loginname" name="loginname" required="" lay-verify="nikename" value="${frontuser.loginname}"
                           autocomplete="off" class="layui-input"></div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>将会成为您唯一的登入名
                </div>
            </div>

            <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">
                    <span class="x-red">*</span>密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="L_pass" name="password" required="" lay-verify="pass" autocomplete="off" value="${frontuser.password}"
                           class="layui-input"></div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                    <span class="x-red">*</span>确认密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="L_repass" name="repass" required="" lay-verify="repass" value="${frontuser.password}"
                           autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="L_username" class="layui-form-label">
                    <span class="x-red">*</span>用户名</label>
                <div class="layui-input-inline">
                    <input type="text" id="L_username" name="username" required="" lay-verify="nikename" value="${frontuser.username}"
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
                    <input type="text" id="identity" name="identity" required="" lay-verify="identity" value="${frontuser.identity}"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label width_auto text-r" style="margin-top:2px">省市县</label>
                    <div class="layui-input-inline" style="width:400px">
                        <input type="text" lay-verify="required" autocomplete="on" class="layui-input" id="city-picker" name="city_picker" readonly="readonly" data-toggle="city-picker" placeholder="请选择">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_username" class="layui-form-label">
                    <span class="x-red">*</span>学校</label>
                <div class="layui-input-inline">
                    <input type="text" id="school" name="school" required="" lay-verify="required" value="${frontuser.school}"
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
                    <input type="text" id="L_mobile" name="mobile" required="" lay-verify="phone" autocomplete="off" value="${frontuser.mobile}"
                           class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">
                    <span class="x-red">*</span>邮箱</label>
                <div class="layui-input-inline">
                    <input type="text" id="L_email" name="email" required="" lay-verify="email" autocomplete="off" value="${frontuser.email}"
                           class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label"></label>
                <button class="layui-btn" lay-filter="add" lay-submit="" style="margin-left: 126px;">保存</button>
            </div>
        </form>
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
                    if (value.length < 2) {
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

            $.get('../../subjectGrade/getGradeList.do', {}, function (data) {
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


            if(${frontuser !=null}){
                var str = '/';
                var grade = "${frontuser.grade}";
                currentPicker.setValue('${frontuser.province}'+str+'${frontuser.city}'+str+'${frontuser.district}');
                $("#sex option[value=${frontuser.sex}]").prop("selected",true);
                $("#loginname").attr("readonly","true");
                $("#L_pass").attr("readonly","true");
                $("#L_repass").attr("readonly","true");
                laydate.render({
                    elem: '#birthday', //指定元素
                    format: 'yyyy-MM-dd',
                    value : '${frontuser.birthday}'
                });
            }else{
                currentPicker.setValue("江苏省/南京市/玄武区");
                $("#iid").val('0');
                laydate.render({
                    elem: '#birthday', //指定元素
                    format: 'yyyy-MM-dd'
                });
            }


            //监听提交
            form.on('submit(add)', function (data) {

                if(${frontuser==null}){
                    $.post('${path}/manager/opr/useradd.do', data.field, function (result) {
                        if (result.success === 1) {
                            layer.alert(result.message, {
                                icon: 6
                            }, function () {
                                xadmin.close();
                                xadmin.father_reload();
                            });
                        } else {
                            layer.alert(result.message);
                            return;
                        }
                    })
                }else{
                    $.post('${path}/manager/opr/useredit.do', data.field, function (result) {
                        if (result.success === 1) {
                            layer.alert(result.message, {
                                icon: 6
                            }, function () {
                                xadmin.close();
                                xadmin.father_reload();
                            });
                        } else {
                            layer.alert(result.message);
                            return;
                        }
                    })
                }

                return false;
            });

        });</script>
</body>

</html>