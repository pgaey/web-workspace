<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교촌치킨</title>
</head>
<body>

	<h1>☆ 치킨 주문페이지에 오신 것을 환영합니다 ★</h1>

	<h2>오늘의 날짜</h2>
	<%@ include file="datePrint.jsp" %>
	
	<br>
	
	<form action="/2_JSP/orderChicken.do" method="get">
		<fieldset>
			<legend>주문자 정보</legend>
			<table>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name="nickName" required></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone" required></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address" required></td>
				</tr>
				<tr>
					<th>요청사항</th>
					<td><textarea style="resize:none" name="message"></textarea></td>
				</tr>
			</table>
		</fieldset>
		
		<br>
		
		<fieldset>
			<legend>주문 정보</legend>
		
			<table>
				<tr>
					<th>치킨</th>
					<td>
						<select name="chicken">
							<option>허니콤보</option>
							<option>고추바사삭</option>
							<option>뿌링클</option>
							<option>호랑이치킨</option>
							<option>신호등치킨</option>
							<option>황금올리브</option>
							<option>민트초코치킨</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>사이즈</th>
					<td>
						<input type="checkbox" name="side" value="치즈볼">치즈볼
						<input type="checkbox" name="side" value="감자튀김">감자튀김
						<input type="checkbox" name="side" value="프로틴파우더">프로틴파우더
						<input type="checkbox" name="side" value="떡볶이">떡볶이
						<input type="checkbox" name="side" value="핫도그">핫도그
						<input type="checkbox" name="side" value="민초아이스크림">민트초코아이스크림
					</td>
				</tr>
				<tr>
					<th>음료</th>
					<td>
						<input type="checkbox" name="drink" value="맥주">맥주
						<input type="checkbox" name="drink" value="제로콜라">제로콜라
						<input type="checkbox" name="drink" value="제로사이다">제로사이다
						<input type="checkbox" name="drink" value="포카리">포카리
						<input type="checkbox" name="drink" value="민트초코우유">민트초코우유
					</td>
				</tr>
				<tr>
					<th>결제방식</th>
					<td>
						<input type="radio" name="payment" value="card" checked>카드결제
						<input type="radio" name="payment" value="cash">만나서 현금 결제
					</td>
				</tr>				
			</table>
		</fieldset>
		<input type="submit" value="주문하기">
		<input type="reset" value="다시고르기">
	</form>















	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>