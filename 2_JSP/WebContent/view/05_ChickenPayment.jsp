<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String nickName = (String)request.getAttribute("nickName"); // : Object
	String phone = (String)request.getAttribute("phone");
	String address = (String)request.getAttribute("address");
	String message = (String)request.getAttribute("message");
	
	String chicken = (String)request.getAttribute("chicken");
	String[] sides = (String[])request.getAttribute("sides");
	String[] drinks = (String[])request.getAttribute("drinks");
	String payment = (String)request.getAttribute("payment");
	
	int price = (int)request.getAttribute("price");
	// Integer.parseInt == String 형을 int로



%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>돈 내놔</title>
</head>
<body>

	<h1>치킨 결제 페이지</h1>

	<h2>주문 내역</h2>
	
	<h3>주문자 정보</h3>
	
	<!-- client가 작성한 value는 XXX로 표현 -->
	
	<ul>
		<li>닉네임 : <%= nickName %></li>
		<li>전화번호 :<%= phone %></li>
		<li>주소 : <%= address %></li>
		
		<% if(message.equals("")){ %> <!-- '=='비교의 경우는 대상의 주소(reference)를 비교하고 equals는 객체간의 값자체를 비교하는 차이점이 있다. -->
			<!-- case1. 요청사항을 작성하지 않은 경우 -->
			<li>요청사항 : 없음</li>
		<%} else { %>
			<!-- case2. 요청사항을 작성한 경우-->
			<li>요청사항 : <%= message %></li>
		<%} %>
	</ul>
	
	<br>
	
	<h4>[ 주문정보 ]</h4>
	
	<ul>
		<li>치킨 : <%= chicken %></li>
		
		<!-- 민트초코, 치즈볼 -->
		<% if(sides == null){ %>
			<!-- case1. 사이드를 선택하지 않았을 경우 -->
			<li>사이드 : 선택 안 함</li>
		<% } else { %>
			<!-- case2. 사이드를 선택했을 경우 -->
			<li>사이드 :
				<% for(int i = 0; i < sides.length; i++){ %>
				<%= sides[i] %></li>
			<%} %>
		<% } %>
		
		
		<!-- 제로콜라, 맥주 -->
		<% if(drinks == null){ %>
			<!-- case1. 음료를 선택하지 않았을 경우  -->
			<li>음료 : 선택 안 함</li>
		<% } else { %>
			<!-- case2. 음료를 선택했을 경우 -->
			<li>음료 : <%=String.join(",", drinks) %></li>
		<% } %>
		
		<!-- 결제방식 -->
		<% if(payment.equals("cash")){ %>
			<!-- case1. 현금을 선택했을 경우 -->
			<li>결제방식 : 현금</li>
		<% } else { %>
			<!-- case2. 카드를 선택했을 경우 -->
			<li>결제방식 : 카드</li>
		<% } %>

		
		
		
		
	</ul>
	
	<br>
	
	<h3>위와 같이 주문하셨습니다.</h3>
	<h2>총 가격 : <%= price %>원</h2>
























	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>