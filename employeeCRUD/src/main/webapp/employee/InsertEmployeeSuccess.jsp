<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/style.css' />" />
<meta charset="UTF-8">
<title>新增員工資料成功</title>
</head>
<body>
<div align='center'>
<h1>新增員工資料成功</h1>
<!-- 
本文件顯示員工資料新增成功的訊息，要顯示的員工資料由Controller放入『Session範圍』內
，成為Session物件的屬性物件，識別字串為mb, 我們將屬性物件內的帳號與姓名取出，放在
本文件中，一起送回給瀏覽器
-->
員工${employee.name}(編號:${employee.employeeId})的資料已新增成功
<p/>
<a href="<c:url value='/index.jsp' />">回到員工管理</a>
</div>
</body>
</html>