// JavaScript Document
function Delete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "user-delete.html?id=" + id;
	}
}

function productCategoryDelete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "/easybuy/productCategory/enterProductCategoryDelete/${" + id +"}";
	}
}