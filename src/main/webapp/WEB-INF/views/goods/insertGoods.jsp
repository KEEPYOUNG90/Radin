<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goods insert</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<form name="newGoods" action="insert.do" method="post">
			name:<input type="text" class="inTxt" name="name"><br>
			price:<input type="text" name="price"><br>
			ISBN: <input type="text" name="ISBN"><br>
			publish:<input type="text" name="publish"><br>
			subject:<input type="text" class="inTxt"  name="subject"><br>
			content:<input type="text" class="inTxt"  name="content"><br>
			bookindex:<input type="text" name="bookindex"><br>
			pages:<input type="text" name="pages"><br>
			weight:<input type="text" name="weight"><br>
			booktype:<input type="text" name="booktype"><br>
			intro:<input type="text" class="inTxt"  name="intro"><br>
			inside:<input type="text" class="inTxt" name="inside"><br>
			<input id="registPost" type="submit" value="등록"> 
			<input type="reset" value="초기화">
			<input type="button" value="hash tag 추출" onclick="gatherText()"/><br>
			
			<div class="add_tag_wrap">
	            <div class="input_wrap">
	               <span class="sharp">#</span>
	               <input type="text" class="hashtag" placeholder="태그를 입력해보세요 " />
	            </div>
				<button type="button" class="btn tag_add_btn">추가</button>
			</div>
			<ul class="keyword_list">
			</ul>
	</form>
</body>
</html>

<script type="text/javascript">
	function gatherText(){
		var fullStr ="";
		//var selected = $(".inTxt")[0];
	    //var selectedVal = selected.val();
	    //console.log(selectedVal);
		var inputs = $(".inTxt");
		for(var i = 0 , len = inputs.length ; i < len ; i++){
			fullStr += inputs[i].value + " ";
			console.log("for:"+fullStr);
		}
		var Cw = /\ /g;
		fullStr = fullStr.replace(Cw, ",");
		
		$.ajax({
			type : 'post',
			url : '/goods/makeHashTag',
			data : JSON.stringify(fullStr),
			contentType : "application/json;charset=EUC-KR",
			success : function(result, status, xhr) {
				var Ca = /\+/g;
				result = decodeURIComponent(result.replace(Ca, " ") );

				result = result.split(', ');
				result.forEach(function(keyword){
					$('.keyword_list').append("<li><span>"+keyword+
							"</span><a href='javascript:;' class='btn_del ico_sprites'><span class='wa'>X</span></a></li>");
				});
				
				
			},
			error : function (xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}
	
	$('.add_tag_wrap').find('.btn').click(function(){
	    var selected = $('.add_tag_wrap .hashtag');
	    var selectedVal = selected.val();
	    for(var i=0; i<selected.length; i++){
	            selected[i].value = '';
	    }
	    
	    var isDuple = false;
	    $('.keyword_list li').each(function(){
	    	if($(this).children('span').text() == selectedVal){
	    		isDuple=true;
	    		alert("중복된 키워드");
	    	}
	    });
	   
	    if(!isDuple){
	    	$('.keyword_list').append('<li><span>'+selectedVal+'</span><a href="javascript:;" class="btn_del ico_sprites"><span class="wa">X</span></a></li>');
	    }
	    
	    $('.keyword_list > li').each(function(){
	        $(this).find('.btn_del').click(function(){
	            var li = $(this).parent('li'),
	                txt = li.children('span').text();
	            li.remove();
	        });
	    });
	});
	
	var formObj = $("form[name='newGoods']");
	$("#registPost").on("click", function(e){
		var RemainingKeyword = gatherRemainingKeywords();
		formObj.append(RemainingKeyword).submit();
	});
	
	function gatherRemainingKeywords() {
		var RemainingKeyword = "";
		$(".keyword_list li").each(function(idx){
			RemainingKeyword += "<input type='hidden' name='Keyword"+ idx +"' value='" + $(this).children('span').text() + "'>";
		});
		return RemainingKeyword;
	}
	
</script>