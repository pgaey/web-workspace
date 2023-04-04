package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChickenServlet
 */
@WebServlet("/orderChicken.do")
public class ChickenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChickenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 전달값 중에 한글이 있을 경우 인코딩 처리(POST방식일 경우)
		
		// 2) 요청 시 전달한 값을 뽑기 및 데이터 가공 처리 => 변수에 기록
		// request.getParameter("키") : String형의 값
		// request.getParameterValues("키") : String[]
		
		// 주문자정보
		String nickName = request.getParameter("nickName"); // "치킨왕" required가 있기 때문에 빈 문자열이 올 수 없음  >> 데이터를 어떻게 뽑을지 생각해야함   올수 있다면 ""
		String phone = request.getParameter("phone"); 		// "01012345678"
		String address = request.getParameter("address");	// "서울시 중구"
		String message = request.getParameter("message");	// "빨리와주세요" / "" << required가 없기 때문에 빈 문자열이 들어올 수도 있다
		
		// 주문정보
		String chicken = request.getParameter("chicken");	// "허니콤보"
		String[] sides = request.getParameterValues("side");// ["치즈", "떡볶이"] / null     배열의 경우 선택안할시 null
		String[] drinks = request.getParameterValues("drink"); // ["제로콜라", "맥주"] / null
		String payment = request.getParameter("payment");	// "card" / "cash"   checked 속성이 없을 시 null
		
		// 3) 요청 처리
		// 보통의 흐름 : Controller - Service - DAO - DB
		
		// 사용자가 보게 될 내용을 처리 : 가격
		
		// 치킨가격 + 사이드 추가 시 가격 + 음료 추가 시 가격 == 총 결제할 금액
		
		int price = 0;
		
		/*
		   <option>허니콤보</option>	 : 2000
		   <option>고추바사삭</option>  : 1500
		   <option>뿌링클</option>     : 3000
  		   <option>호랑이치킨</option>  : 2800
		   <option>신호등치킨</option>  : 1000
		   <option>황금올리브</option>  : 20000
		   <option>민트초코치킨</option> : 300
		 */
		
		switch(chicken) {
		case "허니콤보" : price += 2000; break;
		case "고추바사삭" : price += 1500; break;
		case "뿌링클" : price += 3000; break;
		case "호랑이치킨" : price += 2800; break;
		case "신호등치킨" : price += 1000; break;
		case "황금올리브" : price += 20000; break;
		case "민트초코치킨" : price += 300; break;
		}
		
		/*
		치즈볼 : 500
		감자튀김 : 600
		프로틴파우더 : 2300
		떡볶이 : 1000
		핫도그 : 800
		민트초코아이스크림 : 2000
		*/
		
		if(sides == null) {
			price += 0;
		} else {
			for(int i = 0; i < sides.length; i++) {
				switch(sides[i]) {
				case "치즈볼" : price += 500; break;
				case "감자튀김" : price += 600; break;
				case "프로틴파우더" : price += 2300; break;
				case "떡볶이" : price += 1000; break;
				case "핫도그" : price += 800; break;
				case "민트초코아이스크림" : price += 2000; break;
				}
			}
		}
		
		/*
		맥주		: 1000
		제로콜라	: 1500
		제로사이다	: 1500
		포카리	: 1000
		민트초코우유: 100
		*/
		
		if(drinks != null) {
			for(int i = 0; i < drinks.length; i++) {
				switch(drinks[i]) {
				case "맥주" :
				case "포카리" : price += 1000; break;
				case "제로콜라" :
				case "제로사이다" : price += 1500; break;
				case "민트초코우유" : price += 100; break;
				}
			}
		}
		
		/*
		System.out.println();
		System.out.println("주문자정보");
		System.out.println("닉네임  : " + nickName);
		System.out.println("전화번호 : " + phone);
		System.out.println("주소 : " + address);
		System.out.println("요청사항 : " + message);
		System.out.println();
		
		System.out.println("주문정보" + "\n");
		
		System.out.println("치킨 : " + chicken);
		System.out.println("사이드 : " + String.join("-", sides));
		System.out.println("음료 : " + String.join("-", drinks));
		System.out.println("결제방법 : " + payment);
		System.out.println("결제할 금액 : " + price);
		*/
		
		// 4) 요청 처리 후 사용자가 보게 될 응답페이지 만들기 또는 JSP에게 위임
		// request의 attribute라는 영역에 응답페이지에 필요한 값 담기
		request.setAttribute("nickName", nickName);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		
		request.setAttribute("chicken", chicken);
		request.setAttribute("sides", sides);
		request.setAttribute("drinks", drinks);
		request.setAttribute("payment", payment);
		
		request.setAttribute("price", price);
		
		
		// RequestDispatcher 객체 생성(위임할 JSP파일의 경로 기술)
		// request.getRequestDispatcher(); 호출하면 반환
		RequestDispatcher view = request.getRequestDispatcher("view/05_ChickenPayment.jsp");
		
		view.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
