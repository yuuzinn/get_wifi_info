<%@page import="DB.WifiService2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="
    text-align: center;
">
        	<h1 id="title">19268개 다운로드 완료</h1>
	<a href="test.jsp"> 홈으로 가기</a>
    </div>

<script>
window.onload = function(){
	var urlSearch = new URL(window.location.href);
	var count =urlSearch.searchParams.get('count');
	var title =document.getElementById('title');
	title.innerText=count+"개의 WIFI 정보를 정상적으로 저장하였습니다.";
}
</script>

</html>