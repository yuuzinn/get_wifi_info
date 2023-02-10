<%@page import="DB.Wifi_History_Info"%>
<%@page import="DB.WifiHistoryService"%>
<%@page import="DB.Wifi_Info"%>
<%@page import="java.util.List"%>
<%@page import="DB.WifiService2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<%
WifiHistoryService service =new WifiHistoryService();
List<Wifi_History_Info>data=service.historySelect();

%>
<h1>위치 히스토리 목록</h1>
	<a href="test.jsp"> 홈</a>|
	<a href="history.jsp"> 위치 히스토리 목록</a>|
	<a href="downloadCompleate.jsp"> Open API 와이파이 정보 가져오기</a>

<table class="table" id ="customers">
    <thead>
    <tr>
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
        <th>비고</th>

    </tr>
    </thead>
    <tbody>
    	<%
    
    		
    	
		        for (Wifi_History_Info wifi : data) {
		        	%>
    <tr>
        <td><%=wifi.getId() %></td>
        <td><%=wifi.getX() %></td>
        <td><%=wifi.getY() %></td>
        <td><%=wifi.getRead_date() %></td>
        <td><button onclick='location.href ="historyDeleteAction.jsp?id=<%=wifi.getId()%>"'>삭제</button></td>
    

                        
                        
    </tr>
      <%    	
		        }
			%>
    </tbody>
</table>


</body>
<script type="text/javascript">

function myXY(){
	var x = document.getElementById('x');
	var y = document.getElementById('y');
	navigator.geolocation.getCurrentPosition(
			function(position) {
			x.value= position.coords.latitude;
			y.value=position.coords.longitude;
			}, 
			);

}
function search(){
	var form = document.getElementById('form');
	form.submit();
}
</script>
</html>