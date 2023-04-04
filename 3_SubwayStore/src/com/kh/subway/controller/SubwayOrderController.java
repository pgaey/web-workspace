package com.kh.subway.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.subway.model.vo.Order;

/**
 * Servlet implementation class SubwayOrderController
 */
@WebServlet("/order.do")
public class SubwayOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubwayOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) POST 방식일 때만 => 인코딩
		
		// 2) 데이터 뽑기 = request의 Parameter영역에서
		// request.getParameter("키값");
		// request.getParameterValues("키값");
		
		// 뽑아다가 변수에 담아두기
		// 주문자 정보 뽑기!
		String userName = (String)request.getParameter("userName");
		String phone = (String)request.getParameter("phone");
		String address = (String)request.getParameter("address");
		String message = (String)request.getParameter("message");
		
		// 주문정보 뽑기!
		String sandwich = (String)request.getParameter("sandwich");
		// checkbox == request.getParameterValues() => String[] => 체크된게 하나도 없을 경우 null
		String[] vegetable = (String[])request.getParameterValues("vegetable");
		String[] sauce = (String[])request.getParameterValues("sauce");
		String[] cookie = (String[])request.getParameterValues("cookie");
		String payment = (String)request.getParameter("payment");
		
		// 3) 가공 => VO클래스 객체 생성해서 거기 담았음
		
		// 요청처리 간단하게 
		int price = 0; // 지역변수는 항상 초기화
		// 가격책정 
		// 샌드위치에 따른 기본가격
		
		switch(sandwich) {
		case "스테이크 & 치즈" :
		case "로티세리 바비큐 치킨" :
		case "스파이시 바베큐" : 
		case "K - 바비큐" : price += 6500; break;
		case "풀드 포크 바비큐" :
		case "머쉬룸" :
		case "쉬림프" :
		case "로스트 치킨" : price += 5500; break;
		case "치킨 데리야끼" :
		case "서브웨이 클럽" :
		case "치킨 슬라이스" :
		case "참치" : price += 4500; break;
		case "에그마요" :
		case "이탈리안 비엠티" :
		case "터키 베이컨 아보카도" : price += 3500; break;
		}
		
		// 쿠키종류에 따라서 추가금액 더하기
		// 배열의 경우 체크된게 없을 때 null이 와버림
		// 무작정 반복문을 돌리면 NullPointException이 발생할 가능성이 있음
		// => if문으로 애초에 발생을 안하도록 막는걸 권장
		if(cookie != null) {
			for(int i = 0; i < cookie.length; i++) {
				switch(cookie[i]) {
				case "라즈베리치즈케잌" :
				case "더블초코칩쿠키" :
				case "스모어초코어쩌고" : price += 2300; break;
				}
			}
		}
		
		// VO객체에 담기
		Order order = new Order(userName,
								phone,
								address,
								message,
								sandwich,
								String.join(",", vegetable),
								String.join(",", sauce),
								String.join(",", cookie),
								payment,
								price,
								null);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
