<%@page import="DB.WifiHistoryService"%>
<%@page import="DB.Wifi_Info"%>
<%@page import="java.util.List"%>
<%@page import="DB.WifiService2"%>HttpServletRequest
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if(request.getParameter("id")==null){
	System.out.println("sss");
}
int id = Integer.valueOf( request.getParameter("id")); 
WifiHistoryService service =new WifiHistoryService();
service.deleteHistory(id);

%>
<script>
location.href='history.jsp';
</script>
