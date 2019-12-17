<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">게시글 수정</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">수정</div>
				<div class="panel-body">
					<form id="goodsForm" role="form" action="update" method="post">
						<div class="form-group">
							<label>id : </label> <input class="form-control" type="text"
								name="id" value='<c:out value="${goods.id}" />'
								readonly="readonly">
						</div>
						<div class="form-group">
							<label>name : </label> <input class="form-control" type="text"
								name="name" value='<c:out value="${goods.name}" />'>
						</div>
						<div class="form-group">
							<label>price : </label> <input class="form-control" type="text"
								name="price" value='<c:out value="${goods.price}" />'>
						</div>
	
						<div class="form-group">
							<label>ISBN : </label> <input class="form-control" type="text"
								name="ISBN" value='<c:out value="${goods.ISBN}" />'>
						</div>
						<div class="form-group">
							<label>publish : </label> <input class="form-control" type="text"
								name="publish" value='<c:out value="${goods.publish}" />'>
						</div>
						<div class="form-group">
						<label>subject : </label> <input class="form-control" type="text"
							name="subject" value='<c:out value="${goods.subject}" />'>
					</div>
						<div class="form-group">
							<label>content : </label> <input class="form-control" type="text"
								name="content" value='<c:out value="${goods.content}" />'>
						</div>
						<div class="form-group">
							<label>bookindex : </label> <input class="form-control"
								type="text" name="bookindex"
								value='<c:out value="${goods.bookindex}" />'>
						</div>
						<div class="form-group">
							<label>pages : </label> <input class="form-control" type="text"
								name="pages" value='<c:out value="${goods.pages}" />'>
						</div>
						<div class="form-group">
						<label>weight : </label> <input class="form-control" type="text"
							name="weight" value='<c:out value="${goods.weight}" />'>
						</div>
						<div class="form-group">
							<label>booktype : </label> <input class="form-control" type="text"
								name="booktype" value='<c:out value="${goods.booktype}" />'>
						</div>
						<div class="form-group">
							<label>intro : </label> <input class="form-control" type="text"
								name="intro" value='<c:out value="${goods.intro}" />'>
						</div>
						<div class="form-group">
							<label>inside : </label> <input class="form-control" type="text"
								name="inside" value='<c:out value="${goods.inside}" />'>
						</div>
						
						
						
						<button type="submit" data-oper='modify' class="btn btn-default">수정</button>
						<button type="submit" data-oper='remove' class="btn btn-danger">삭제</button>
						<button type="submit" data-oper='list' class="btn btn-info">목록</button>
						<input type="hidden" name='pageNum' value='${pageMaker.pageNum}'>
						<input type="hidden" name='amount' value='${pageMaker.amount}'>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
	var goodsForm = $("#goodsForm");
	$("button").on("click", function(e){
		e.preventDefault();
		
		var oper = $(this).data("oper");
		
		if (oper === "remove") {
			goodsForm.attr("action", "/goods/deletePosting");
			
		} else if (oper === "list") {
			goodsForm.attr("action", "/goods/listAll.do").attr("method", "get");
			
			var inputPN = $("input[name='pageNum']").clone();
			var inputAmt = $("input[name='amount']").clone();
			goodsForm.empty();
			goodsForm.append(inputPN);
			goodsForm.append(inputAmt);
		}
		goodsForm.submit();
	});
});
</script>