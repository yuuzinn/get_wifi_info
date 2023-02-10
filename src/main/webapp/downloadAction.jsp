<%@page import="DB.WifiService2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% WifiService2 service2=new WifiService2(); %>

<script>
	location.href='downloadCompleate.jsp?count=<%= service2.dowonLoadAction()%>';
</script>