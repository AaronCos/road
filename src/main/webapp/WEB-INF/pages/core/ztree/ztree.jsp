<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="session"></c:set>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="expires" content="0">
    <title>树</title>
    <link rel="stylesheet" href="${path}/resources/ztree/css/zTreeStyle/zTreeStyle.css">
</head>
<body>

<div>
    <ul id="regionZTree" class="ztree"></ul>
</div>

<!-- Javascript -->
<script src="https://cdn.bootcdn.net/ajax/libs/zTree.v3/3.5.01/js/jquery.ztree.all.min.js"></script>
<%--<script src="${path}/resources/ztree/js/jquery-1.4.4.min.js"></script>--%>
<script>
/*    var setting = {
        view: {
            dblClickExpand: false,//双击节点时，是否自动展开父节点的标识
            showLine: true,//是否显示节点之间的连线
            fontCss:{'color':'black','font-weight':'bold'},//字体样式函数
            selectedMulti: true //设置是否允许同时选中多个节点
        },
        check:{
            //chkboxType: { "Y": "ps", "N": "ps" },
            chkboxType: { "Y": "", "N": "" },
            chkStyle: "checkbox",//复选框类型
            enable: true //每个节点上是否显示 CheckBox
        },
        edit:{
            enable: true,
            editNameSelectAll: true,
            showRemoveBtn : true,
            showRenameBtn : true,
            removeTitle : "remove",
            renameTitle : "rename"
        },
        data: {
            simpleData: {//简单数据模式
                enable:true,
                idKey: "id",
                pIdKey: "IPARENTID",
                rootPId: null
            }
        },
        callback: {
            beforeExpand:zTreeBeforeExpand, // 用于捕获父节点展开之前的事件回调函数，并且根据返回值确定是否允许展开操作
        }
    };
    zTreeObj = $.fn.zTree.init($("#regionZTree"), setting, dominZTree);*/
</script>
</body>
</html>