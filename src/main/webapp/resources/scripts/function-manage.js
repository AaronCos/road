// JavaScript Document
function newsDelete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href="DoBackNewsDelete?newsId=" + id;
	}
}
function commentDelete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href="DoBackCommentDelete?commentId=" + id;
	}
}
function orderDelete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href="DoBackOrderDelete?orderId=" + id;
	}
}
function userDelete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href="DoBackUserDelete?userId=" + id;
			
	}
}
function selectCategory(c_id) {
    var categorys = document.getElementsByTagName('li');
    for (var i = 0; i < categorys.length - 1; i++) {
        if (categorys[i].name == 'category') {
            if (categorys[i].id == c_id) {
                categorys[i].className = "current";
                if (categorys[i].id == 0) {
                    location.href = "index.jsp";
                }
            } else {
                categorys[i].className = "";
            }
        }
    }
    text_onkeyup(c_id);
}

function text_onkeyup(c_id) {
    var xhr;
    if (window.XmLHttpRequest) {
        xhr = new XmlHttpRequest();
    } else {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }
    var url = "DoCategorySelect?keyWord=" + c_id;
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readystate == 4 && xhr.status == 200) {
            if (xhr.responseText.length != 0) {
                let result = xhr.responseText.split('-');
                let clew = "";
                for (var i = 0; i < result.length; i++) {
                    clew += "";
                    clew += result[i];
                    clew += "</li>";
                }
                document.getElementById("select").innerHTML = clew;
            }

        }
    };
    xhr.send(null);
}