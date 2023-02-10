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
List<Wifi_Info> data = null;
if(request.getAttribute("data")!=null){
	data = (List<Wifi_Info>)request.getAttribute("data");
	for(int i=0; i<data.size();i++){
		System.out.println(data.get(i));
	}
}

%>
<h1>와이파이 정보 구하기</h1>
	<a href='test.jsp'> 홈 </a> |
	<a href="downloadAction.jsp"> 오픈 API 정보 가져오기</a> |
	<a href="history.jsp">위치 히스토리 목록</a>
	<form id ='form' action="selectAction.jsp" method="get">
		<label for='x'>LAT : </label>
		<input id='x' name='x' >
		<label for='y'>LNT : </label>
		<input id='y' name='y' >
	</form>
	<button onclick='myXY();'>내위치 가져오기</button>
	<button onclick='search();'>근처 wifi 정보보기</button>
	
<table class="table" id="customers">
    <thead>
    <tr>
        <th>거리</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>wifi접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    </thead>
    <tbody>
    	<%
    	if(data!=null){
    		
    	
		        for (Wifi_Info wifi : data) {
		        	
		        	%>
    <tr>
        <td><%= Math.ceil(wifi.getKm() * 10)/10000.0 %></td>
        <td><%=wifi.getNo() %></td>
         <td><%=wifi.getGu() %></td>
          <td><%=wifi.getWifi_name() %></td>
           <td><%=wifi.getRoad_address() %></td>
            <td><%=wifi.getDetail_address() %></td>
             <td><%=wifi.getFloor() %></td>
              <td><%=wifi.getInstall_type() %></td>
               <td><%=wifi.getCenter() %></td>
                <td><%=wifi.getService() %></td>
                 <td><%=wifi.getNet_type() %></td>
                  <td><%=wifi.getInstall_year() %></td>
                   <td><%=wifi.getIn_out() %></td>
                    <td><%=wifi.getWifi_env() %></td>
                      <td><%=wifi.getX_crood() %></td>
                     <td><%=wifi.getY_crood() %></td>
                       <td><%=wifi.getDate() %></td>
                        
                        
    </tr>
      <%    	
		        }
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