<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 이 구문을 스클립틀릿(scriptlet)이라고 해서 자바코드를 쓸 수 있는 영역
	// 현재 이 JSP파일에 필요한 데이터들 => request객체의 attribute영역에 담겨있음
	// request.getAttribute("키값") : Object
	
	String name = (String)request.getAttribute("name");
	int age = (int)request.getAttribute("age");
	String gender = (String)request.getAttribute("gender");
	String city = (String)request.getAttribute("city");
	double height = (double)request.getAttribute("height");
	String[] foods = (String[])request.getAttribute("foods");

	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>개인정보 응답화면~</h1>
	
	<span><%= name %></span>님은 <br>
	<span><%= age %></span>살이며, <br>
	<span><%= city %></span>에 삽니다. <br>
	
	키는 <span><%= height %></span>cm이고 <br>

	성별은
		<% if(gender==null){ %>
				<!-- 성별을 선택 안했을 경우 -->
				<span>선택을 안했습니다.</span> <br>
		<% } else { %>		
			<% if(gender.equals("M")){ %>
				<!-- 남자 선택 -->
				<span>남자</span>입니다. <br>
			<% } else {%>
				<!-- 여자 선택 -->
				<span>여자</span>입니다. <br>
			<% } %>
		<% } %>		
	
	좋아하는 음식은
		<% if(foods==null){ %>
				<!-- 체크를 안했을 경우 -->
				없습니다.
		<% } else {%>
			<!-- 체크를 했을 경우 -->
			<ul>
				<% for(int i=0; i < foods.length; i++){ %>				
					<li><%= foods[i] %></li>
				<% } %>
			</ul>
			입니다.
		<% } %>












</body>
</html>