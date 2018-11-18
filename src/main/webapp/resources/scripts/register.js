function FocusItem(obj)
{
	/*obj.parentNode.parentNode.className = "current";*/
	var addClass=$(obj).parents("tr").addClass("current");
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	msgBox.innerHTML = "";
	msgBox.className = "";
}


//失去焦点
function CheckItem(obj)
{
	obj.parentNode.parentNode.className = "";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	switch(obj.name) {
	case "userName":
		if(obj.value == "") {
			msgBox.innerHTML = "用户名不能为空";
			msgBox.className = "error";
			return false;
		}
		break;

	case "identity":
		if(obj.value == "") {
			msgBox.innerHTML = "身份证不能为空";
			msgBox.className = "error";
			return false;
		}
		break;
	case "email":
		if(obj.value == "") {
			msgBox.innerHTML = "email不能为空";
			msgBox.className = "error";
			return false;
		}
		break;
	case "phone":
		if(obj.value == "") {
			msgBox.innerHTML = "phone不能为空";
			msgBox.className = "error";
			return false;
		}
		break;
	case "address":
		if(obj.value == "") {
			msgBox.innerHTML = "请输入地址";
			msgBox.className = "error";
			return false;
		}
		break;
	case "passWord":
		if(obj.value == "") {
			msgBox.innerHTML = "密码不能为空";
			msgBox.className = "error";
			return false;
		}else if(obj.value.length < 4){
			msgBox.innerHTML = "密码至少为4个字符";
			msgBox.className = "error";
			return false;
		}
		break;
	case "rePassWord":
		if(obj.value == "") {
			msgBox.innerHTML = "确认密码不能为空";
			msgBox.className = "error";
			return false;
		}else if(obj.value.length < 4){
			msgBox.innerHTML = "确认密码至少为4个字符";
			msgBox.className = "error";
			return false;
		}else if(obj.value != document.getElementById("passWord").value) {
			msgBox.innerHTML = "两次输入的密码不相同";
			msgBox.className = "error";
			return false;
		}
		break;
	case "veryCode":
		if(obj.value == "") {
			msgBox.innerHTML = "验证码不能为空";
			msgBox.className = "error";
			return false;
		}
		break;
	}
	return true;
}