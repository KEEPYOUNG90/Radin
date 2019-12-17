<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">goods 내용</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">내용</div>
				<div class="panel-body">

					<div class="form-group">
						<label>id : </label> <input class="form-control" type="text"
							name="id" value='<c:out value="${goods.id}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>name : </label> <input class="form-control" type="text"
							name="name" value='<c:out value="${goods.name}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>price : </label> <input class="form-control" type="text"
							name="price" value='<c:out value="${goods.price}" />'
							readonly="readonly">
					</div>

					<div class="form-group">
						<label>ISBN : </label> <input class="form-control" type="text"
							name="ISBN" value='<c:out value="${goods.ISBN}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>publish : </label> <input class="form-control" type="text"
							name="publish" value='<c:out value="${goods.publish}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>subject : </label> <input class="form-control" type="text"
							name="subject" value='<c:out value="${goods.subject}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>content : </label> <input class="form-control" type="text"
							name="content" value='<c:out value="${goods.content}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>bookindex : </label> <input class="form-control"
							type="text" name="bookindex"
							value='<c:out value="${goods.bookindex}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>pages : </label> <input class="form-control" type="text"
							name="pages" value='<c:out value="${goods.pages}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>weight : </label> <input class="form-control" type="text"
							name="weight" value='<c:out value="${goods.weight}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>booktype : </label> <input class="form-control" type="text"
							name="booktype" value='<c:out value="${goods.booktype}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>intro : </label> <input class="form-control" type="text"
							name="intro" value='<c:out value="${goods.intro}" />'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>inside : </label> <input class="form-control" type="text"
							name="inside" value='<c:out value="${goods.inside}" />'
							readonly="readonly">
					</div>

					<button data-oper='modify' class="btn btn-default">수정</button>
					<button data-oper='list' class="btn btn-info">목록</button>

					<!-- 264쪽 : 나중에 다양한 상황처리 -->
					<form id="operForm" method="get">
						<input type="hidden" id="id" name="id"
							value='<c:out value="${goods.id}" />'> <input
							type="hidden" name='pageNum' value='${pageMaker.pageNum}'>
						<input type="hidden" name='amount' value='${pageMaker.amount}'>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function() {
		var operForm = $("#operForm");

		$("button[data-oper='modify']").on("click", function(e) {
			operForm.attr("action", "/goods/modify");
			operForm.submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#id").remove();
			operForm.attr("action", "/goods/listAll.do");
			operForm.submit();
		});

	});
</script>
