<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
	<style>
		ul{
			
			text-align: center;
			padding-right: 190px;
		}
		.pull-righ{
			text-align: center;
		}
		ul li{
			list-style:none;
			padding:5px;
			margin:0px;
			float:left;
		}
		table {
    		width: 100%;
  		}
  		.pull-right {
			 width: 100%;
			 text-align: center;
 		}
		.pagination {
 			display: inline-block;
		} 

	</style>
	  <link href="/resources/vendor/bootstrap/css/main.css" rel="stylesheet">
	    <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.css?222" rel="stylesheet">

  <!-- Custom fonts for this template -->
  
  <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="/resources/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="/resources/css/landing-page.min.css" rel="stylesheet">
	  
	<title>모든 게시글 보기</title>
</head>
<body>
<!-- Masthead -->
  <header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h1 class="mb-5">Build a landing page for your business or project and generate more leads!</h1>
        </div>
        <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
          <form>
            <div class="form-row">
              <div class="col-12 col-md-9 mb-2 mb-md-0">
                <input type="email" class="form-control form-control-lg" placeholder="Enter your email...">
              </div>
              <div class="col-12 col-md-3">
                <button type="submit" class="btn btn-block btn-lg btn-primary">Sign up!</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </header>
	<ul >
		<li><button onclick="resist()" class="button button--ujarak">등록</button></li>
	</ul>
	<table class="table">
	<tbody align=center >
		<tr style="background:#00aaff">
			<thead><th>id</th>
			<th>name</th>
			<th>price</th>
			<th>ISBN</th>
			<th>publish</th>
			<th>subject</th>
			<th>content</th>
			<th>bookindex</th>
			<th>pages</th></thead>
		</tr>
		<c:forEach var="goods" items="${listAllGoods}">
			<tr>
				<td>${goods.id}</td>
				<td>
					<a class='showDetail' href='<c:out value="${goods.id}"/>'>
						${goods.name}
					</a>
				</td>
				<td>${goods.price}</td>
				<td>${goods.ISBN}</td>
				<td>${goods.publish}</td>
				<td>${goods.subject}</td>
				<td>${goods.content}</td>
				<td>${goods.bookindex}</td>
				<td>${goods.pages}</td>
			</tr>
		</c:forEach>
	</tbody>	
	</table>
	
	<!-- 페이징 -->
	<div class='pull-right'>
        <ul class='pagination' >
            <c:if test="${pageMaker.hasPrev}">
                <ol class='paginate_button previous'><a href="${pageMaker.startPage - 1}">Prev</a></ol>
            </c:if>
            <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                <li class="paginate_button ${pageMaker.pageNum == num ? "active":""}">
                    <a href="${num}">${num}</a>
                </li>
            </c:forEach>
            <c:if test="${pageMaker.hasNext}">
                <li class='paginate_button next'><a href="${pageMaker.endPage + 1}">Next</a></li>
            </c:if>
        </ul>
    </div>
	
	
	<form id='actionForm' action="/goods/listAll.do" method="get">
		<input type="hidden" name='pageNum' value='${pageMaker.pageNum}'>
		<input type="hidden" name='amount' value='${pageMaker.amount}'>
	</form>


</body>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		
        //regPost id를 가지는 요소에서 클릭이 발생하면 이 함수에서 처리합니다.
        $("#regPost").on("click", function(){
            self.location = "/goods/createPost";
        });
        
        //paginate_button에서 클릭 이벤트로 해당 페이지 띄우기
        var actionForm = $("#actionForm");
        $('.paginate_button a').on('click', function(e){
            e.preventDefault();
            //클릭한 앵커의 href값을 form안의 pageNum input에 기록한다.
            var pn = $(this).attr("href");
            var inPageNum = actionForm.find("input[name='pageNum']");
            inPageNum.val(pn);
            var modified = inPageNum.val();
            //actionForm.find("input[name='pageNum']").val($(this).attr("href"));
            actionForm.submit();
        });
		
		var actionForm = $("#actionForm");
		$(".showDetail").on('click', function(e){
				e.preventDefault();
				actionForm.append("<input type='hidden' name='id' value='" 
						+ $(this).attr("href") + "'>");
				actionForm.attr("action", "/goods/showDetail");
				actionForm.submit();
		});
		
	});
	function resist(){
		location.replace('insertGoods');
	}	
</script>
