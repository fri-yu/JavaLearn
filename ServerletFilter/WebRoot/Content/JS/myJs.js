function loadDataByGet(url, divId) {
	//alert(url.replace(/#/,''));
	$.ajax({
		type : 'GET',
		url : url,
		success: function(data)
		{
			//alert(data);
			$('#'+divId).html("");
			$('#'+divId).html(data);
		}
	});
}