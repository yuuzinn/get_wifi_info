<%@page import="DB.WifiHistoryService"%>
<%@page import="DB.Wifi_Info"%>
<%@page import="java.util.List"%>
<%@page import="DB.WifiService2"%>HttpServletRequest
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Double x=Double.valueOf( request.getParameter("x"));
Double y=Double.valueOf( request.getParameter("y"));
%>

<% WifiService2 service2=new WifiService2(); 
   WifiHistoryService service =new WifiHistoryService();
%>
<% List<Wifi_Info> data=service2.wifiSelect20(x, y); 
service.historyInsert(x,y);

request.setAttribute("data",data);
RequestDispatcher requestDispatehcer = request.getRequestDispatcher("test.jsp");
requestDispatehcer.forward(request, response);

%>
<script>
	location.href='test.jsp';
</script>

