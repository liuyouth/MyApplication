var totalNum;
var pageTotalNum;
function pageShow(total) {
	totalNum = total;
	$('#pagePanel').empty();
	pageTotalNum = total / 10;// 总页面数
	var last = total % 10;// 总页面除以10以后的余数
	if (parseInt(last) > 0) {
		// 如果余数大于1，则总页面数+1;
		pageTotalNum = parseInt(pageTotalNum) + 1;
	}
	if (pageTotalNum != 0) {
		var nowPage = $('#nowPage').val();
		var page = '<nav><ul class="pagination"><li><a href="javascript:void(0)"'
				+ ' onclick="javascript:nextPage(0)" aria-label="Previous">'
				+ ' <span aria-hidden="true">上一页</span></a></li>';

		page = page
				+ '<li id="pageShowLi"><a style="padding:0px;"><input type="text"'
				+ ' id="goPageNum" style="width:30px;height:32px;padding:0px;text-align:center;" '
				+ 'value="' + nowPage + '"></a>' + '<a>/' + pageTotalNum
				+ '</a></li>';

		page = page + '<li id="pageShowLi"><a href="javascript:void(0);"'
				+ ' onclick="javascript:jumpPage()">GO!</a></li>';

		page = page
				+ '<li><a href="javascript:void(0)" onclick="javascript:nextPage(1)"'
				+ ' aria-label="Next"> <span aria-hidden="true">'
				+ '下一页</span></a></li></ul></nav>';

		$('#pagePanel').append(page);
	}

}

function jumpPage() {
	var goPageNum = $('#goPageNum').val();
	if (goPageNum > pageTotalNum) {
		goPageNum = pageTotalNum;
		$('#goPageNum').val(goPageNum);
	} else if (goPageNum < 1) {
		goPageNum = 1;
		$('#goPageNum').val(goPageNum);
	}
	$('#nowPage').val(goPageNum);
	pageShow(totalNum);
	showData();
}
function nextPage(type) {
	if (type == 0) {
		// 点击上一页
		var nowPage = $('#nowPage').val();
		if (nowPage == 1) {
			customDialog("error", "当前已经是第一页。");
		} else {
			$('#nowPage').val(parseInt(nowPage) - 1);
			pageShow(totalNum);
			showData();
		}

	} else if (type == 1) {
		// 点击下一页
		var nowPage = $('#nowPage').val();
		if (nowPage == pageTotalNum) {
			customDialog("error", "当前已经是最后一页。");
		} else {
			$('#nowPage').val(parseInt(nowPage) + 1);
			pageShow(totalNum);
			showData();
		}
	}
}

// 带方法名查询方法不为searchData()的分页方法
var functionName;
function pageShowWithFunc(total, funcName) {

	functionName = funcName;

	totalNum = total;
	$('#pagePanel').empty();
	pageTotalNum = total / 10;// 总页面数
	var last = total % 10;// 总页面除以10以后的余数
	if (parseInt(last) > 0) {
		// 如果余数大于1，则总页面数+1;
		pageTotalNum = parseInt(pageTotalNum) + 1;
	}
	if (pageTotalNum != 0) {
		var nowPage = $('#nowPage').val();
		var page = '<nav><ul class="pagination"><li><a href="javascript:void(0)"'
				+ ' onclick="javascript:nextPageWithFunc(0)" aria-label="Previous">'
				+ ' <span aria-hidden="true">上一页</span></a></li>';

		page = page
				+ '<li id="pageShowLi"><a style="padding:0px;"><input type="text"'
				+ ' id="goPageNum" style="width:30px;height:32px;padding:0px;text-align:center;" '
				+ 'value="' + nowPage + '"></a>' + '<a>/' + pageTotalNum
				+ '</a></li>';

		page = page + '<li id="pageShowLi"><a href="javascript:void(0);"'
				+ ' onclick="javascript:jumpPageWithFunc()">GO!</a></li>';

		page = page
				+ '<li><a href="javascript:void(0)" onclick="javascript:nextPageWithFunc(1)"'
				+ ' aria-label="Next"> <span aria-hidden="true">'
				+ '下一页</span></a></li></ul></nav>';

		$('#pagePanel').append(page);
	}

}

function jumpPageWithFunc() {
	var goPageNum = $('#goPageNum').val();
	if (goPageNum > pageTotalNum) {
		goPageNum = pageTotalNum;
		$('#goPageNum').val(goPageNum);
	} else if (goPageNum < 1) {
		goPageNum = 1;
		$('#goPageNum').val(goPageNum);
	}
	$('#nowPage').val(goPageNum);
	pageShowWithFunc(totalNum, functionName);
	functionName();
}
function nextPageWithFunc(type) {
	if (type == 0) {
		// 点击上一页
		var nowPage = $('#nowPage').val();
		if (nowPage == 1) {
			customDialog("error", "当前已经是第一页。");
		} else {
			$('#nowPage').val(parseInt(nowPage) - 1);
			pageShowWithFunc(totalNum, functionName);
			functionName();
		}

	} else if (type == 1) {
		// 点击下一页
		var nowPage = $('#nowPage').val();
		if (nowPage == pageTotalNum) {
			customDialog("error", "当前已经是最后一页。");
		} else {
			$('#nowPage').val(parseInt(nowPage) + 1);
			pageShowWithFunc(totalNum, functionName);
			functionName();
		}
	}
}