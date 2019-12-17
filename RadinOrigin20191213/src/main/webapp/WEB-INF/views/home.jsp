<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<style type="text/css">
ul {
	list-style: none;
	text-align: center;
	border-top: 1px solid red;
	border-bottom: 1px solid red;
	padding: 10px 0;
}

ul li {
	display: inline;
	text-transform: uppercase;
	padding: 0 10px;
	letter-spacing: 10px;
}

ul li a {
	text-decoration: none;
	color: black;
}

ul li a:hover {
	text-decoration: underline;
}
</style>
	<title> Admin Home</title>
</head>
<body>
<ul>
	<li><a href="#">Home</a></li>
	<li><a href="goods/listAll.do">책 목록 보기</a></li>
	
	<li><li>
</ul>
</body>
</html>