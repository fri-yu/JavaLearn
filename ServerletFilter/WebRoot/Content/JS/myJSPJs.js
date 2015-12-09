$("a").click(function(e) {
	e.preventDefault();
});
function myLoad(url, loadDiv) {
	loadDataByGet(url, loadDiv);
}
function query(getUrl, getForm, freshDiv) {
	var params = serializeForm(getForm);
	// alert("<%=basePath%>"+ "userList?"+params);
	loadDataByGet(getUrl + "?&" + params, freshDiv);
}
function myPost(postUrl, postForm, freshDiv) {
	loadDataByPost(postUrl, freshDiv, serializeForm(postForm));
}
function del(url, getUrl) {
	if (confirm("确定要删除数据吗？")) {
		loadDataByGet(url, getUrl);
	}
}