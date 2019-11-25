<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goods insert</title>
</head>
<body>
	<form action="insert.do" method="post">
			name:<input type="text" name="name"><br>
			price:<input type="text" name="price"><br>
			ISBN: <input type="text" name="ISBN"><br>
			publish:<input type="text" name="publish"><br>
			subject:<input type="text" name="subject"><br>
			content:<input type="text" name="content"><br>
			bookindex:<input type="text" name="bookindex"><br>
			pages:<input type="text" name="pages"><br>
			weight:<input type="text" name="weight"><br>
			booktype:<input type="text" name="booktype"><br>
			intro:<input type="text" name="intro"><br>
			inside:<input type="text" name="inside"><br>
			<input type="submit" value="등록"> 
			<input type="reset" value="초기화">
	</form>
</body>
</html>