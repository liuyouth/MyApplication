//分页处理
var totalNum;
var pageTotalNum;

function pageShow(total){//显示页码
	totalNum = total;
	$('#pagePanel').empty();
	pageTotalNum = total/10;//总页面数 
	var last = total%10;//总页面除以10以后的余数
	if(parseInt(last)>0){
		//如果余数大于1，则总页面数+1;
		pageTotalNum = parseInt(pageTotalNum) + 1;
	}
	if(pageTotalNum != 0){
		var nowPage = $('#nowPage').val();
		/*<ul class="pagination-plain" style="text-align:center;margin:20px auto;">
			<li class="previous" style="display: inline;font-size:120%;">
				<a href="#fakelink">< </a>
			</li>
			<li><input type="text" value="1" style="width:30px;text-align:center;"></li>
			<li>/</li>
			<li><a href="#fakelink">3</a></li>
			<li><a href="#fakelink">GO</a></li>
			<li class="next" style="float:none;font-size:120%;">
				<a href="#fakelink"> ></a>
			</li>
		</ul>*/
	
		var page = '<ul class="pagination-plain" '
			+'style="text-align:center;margin:20px auto;">'
			+' <li class="previous" style="display: inline;font-size:120%;">'
			+'<a href="javascript:nextPage(0);">< </a></li>';
		
		page = page + '<li><input type="text"'
			+' id="goPageNum" style="width:30px;text-align:center;" '
			+'value="' + nowPage + '"></li>'
			+'<li>/  </li><li><a href="javascript:void(0)">'+ pageTotalNum +'</a></li>';
		
		page = page + '<li><a href="javascript:jumpPage()">GO!</a></li>';
		
		page = page + '<li style="float:none;font-size:120%;"'
			+' class="next"><a href="javascript:nextPage(1)"'
			+' >  ></a></li></ul>';
		
		$('#pagePanel').append(page);
	}
	
}


function jumpPage(){//跳页功能
	var goPageNum = $('#goPageNum').val();
	if(goPageNum>pageTotalNum){
		goPageNum = pageTotalNum;
		$('#goPageNum').val(goPageNum);
	}else if(goPageNum<1){
		goPageNum = 1;
		$('#goPageNum').val(goPageNum);
	}
	$('#nowPage').val(goPageNum);
	pageShow(totalNum);
	//加载商品列表页面数据
	showData();
}

//下一页功能
function nextPage(type){
	if(type == 0){
		//点击上一页
		var nowPage = $('#nowPage').val();
		if(nowPage == 1){
			alert("当前已经是第一页。");
		}else{
			$('#nowPage').val(parseInt(nowPage) - 1);
			pageShow(totalNum);
			//加载商品列表页面数据
			showData();
		}
		
	}else if(type == 1){
		//点击下一页
		var nowPage = $('#nowPage').val();
		if(nowPage == pageTotalNum){
			alert("当前已经是最后一页。");
		}else{
			$('#nowPage').val(parseInt(nowPage) + 1);
			pageShow(totalNum);
			//加载商品列表页面数据
			showData();
		}
	}
}