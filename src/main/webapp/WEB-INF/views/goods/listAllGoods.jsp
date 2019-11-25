<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style>
		ul{
			text-align: right;
			padding-right: 190px;
		}
	</style>
	<title>모든 게시글 보기</title>
</head>
<body>
	<ul >
		<li><a href="insertGoods">등록</a></li>
	</ul>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>price</th>
			<th>ISBN</th>
			<th>publish</th>
			<th>subject</th>
			<th>content</th>
			<th>bookindex</th>
			<th>pages</th>
			<th>booktype</th>
			<th>intro</th>
			<th>inside</th>
		</tr>
		<c:forEach var="goods" items="${listAllGoods}">
			<tr>
				<td>${goods.id}</td>
				<td>${goods.name}</td>
				<td>${goods.price}</td>
				<td>${goods.ISBN}</td>
				<td>${goods.publish}</td>
				<td>${goods.content}</td>
				<td>${goods.bookindex}</td>
				<td>${goods.pages}</td>
				<td>${goods.booktype}</td>
				<td>${goods.intro}</td>
				<td>${goods.inside}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>
