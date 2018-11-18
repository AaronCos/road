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