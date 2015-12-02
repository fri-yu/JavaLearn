function loadData(url, divId, method, data) {
	// alert(url.replace(/#/,''));
	$.ajax({
		type : method,
		url : url,
		data : null == data ? "" : data,
		success : function(result) {
			// alert(data);
			$('#' + divId).html("");
			// alert("#"+divId+" clear");
			$('#' + divId).html(result);
		}
	});
}
function loadDataByGet(url, divId) {
	// alert("loadDataByGet run");
	loadData(url, divId, 'GET');
}
function loadDataByPost(url, divId, data) {
	loadData(url, divId, 'POST', data);
}
function getElements(formId) {
	var form = document.getElementById(formId);
	var elements = new Array();
	var tagElements = form.getElementsByTagName('input');
	for ( var j = 0; j < tagElements.length; j++) {
		elements.push(tagElements[j]);
	}
	return elements;
}

// 获取单个input中的【name,value】数组
function inputSelector(element) {
	if (element.checked)
		return [ element.name, element.value ];
}

function input(element) {
	switch (element.type.toLowerCase()) {
	case 'submit':
	case 'hidden':
	case 'password':
	case 'text':
		return [ element.name, element.value ];
	case 'checkbox':
	case 'radio':
		return inputSelector(element);
	}
	return false;
}

// 组合URL
function serializeElement(element) {
	var method = element.tagName.toLowerCase();
	var parameter = input(element);

	if (parameter) {
		var key = encodeURIComponent(parameter[0]);
		if (key.length == 0)
			return;

		if (parameter[1].constructor != Array)
			parameter[1] = [ parameter[1] ];

		var values = parameter[1];
		var results = [];
		for ( var i = 0; i < values.length; i++) {
			results.push(key + '=' + encodeURIComponent(values[i]));
		}
		return results.join('&');
	}
}

// 调用方法
function serializeForm(formId) {
	var elements = getElements(formId);
	var queryComponents = new Array();

	for ( var i = 0; i < elements.length; i++) {
		var queryComponent = serializeElement(elements[i]);
		if (queryComponent)
			queryComponents.push(queryComponent);
	}

	return queryComponents.join('&');
}