package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test1.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// System.out.println("진짜 호출?");
		
		/*
		 * Controller
		 * 1. 데이터가공
		 * 2. 응답화면 지정
		 * 
		 * Get방식으로 요청하면 doGet()가 호출됨
		 * 
		 * 첫 번째 매개변수인 HttpServletRequest request에는 요청 시 전달된 내용들이 담김
		 * => 사용자가 입력한 값, 요청전송방식, 요청한 사용자의 ip주소 등...
		 * 
		 * 두 번째 매개변수인 HttpservletResponse respose에는 요청 처리 후 응답을 할 때 사용하는 객체
		 * 
		 * 
		 * 
		 * 요청 처리 스텝
		 * 
		 * 1. 우선 요청을 처리하기 위해 요청 시 전달된값(사용자가 입력한값)들을 뽑는다.
		 * => request의 parameter라는 영역에 값이 존재
		 * => key-value 세트로 담겨있음!!(name속성값 = value속성값)
		 * 
		 * 2. 뽑아낸 값들을 가지고 요청 처리해야함(Service -> DAO -> DB)
		 * 
		 * 3. 처리 결과에 따른 성공 / 실패 페이지 응답
		 * 
		 */
		
		/*
		 * request의 parameter영역으로부터 전달된 데이터를 뽑는 방법
		 * 
		 * - request.getParameter("키값") : String(그에 해당 value값)
		 * => 무조건 문자열 형태로 반환되기 때문에
		 *    다른 자료형으로 사용하려면 파싱해야함
		 * 
		 * - request.getParameterValues("키값") : String[] (그에 해당하는 value값)
		 * => 하나의 key값으로 여러개의 value들을 받는 경우( ex: checkbox)
		 *    [String형 배열]로 반환 
		 * 
		 */
		
		// 1단계
		String name = request.getParameter("name");
		// 셀 수 없음 => ?
		// "홍길동" / ""(텍스트 상자가 빈 경우 빈문자열이 넘어온다)
		
		// 2단계
		String gender = request.getParameter("gender");
		// "M" / "F" / null(라디오 버튼의 경우 체크된 것이 없을 경우 null이 넘어옴)
		
		int age = Integer.parseInt(request.getParameter("age")); // : String
		// "15" / ""
		// "15" -> 15
		// Wrapper클래스를 이용한 파싱
		// "" : NumberFormatException 발생
		
		String city = request.getParameter("city"); // "서울시"
		
		double height = Double.parseDouble(request.getParameter("height")); // 170.0
		
		String[] foods = request.getParameterValues("food");
		// ["한식", "일식] / null(체크박스의 경우 하나도 없으면 null이 넘어옴)
		
		
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(city);
		System.out.println(height);
		
		if(foods == null) {
			System.out.println("없음");
		} else {
			System.out.println(Arrays.toString(foods));
		}
		
		// 자주보는 오류
		// 404 : 파일이나 요청을 받아주는 서블릿을 못찾았을 때 발생 => 경로를 잘못적었거나 파일명에 오타가 났을 때
		// 500 : 자바 소스코드상의 오류(예외발생)
		
		// 2단계
		// 뽑아낸 값들 가지고 요청 처리!(DB와 상호작용 => JDBC)
		// 보통의 흐름 : Controller단에서 Service단의 메소드를 호출하면서 값을 전달
		// -> DAO호출 - DB SQL문 실행 - 결과반환
		
		/*
		Person p = new Person(name, gender, age, city, height, foods);
		
		int result = new PersonService().insertPersont(p);
		
		if(result > 0) {
			성공 페이지~
		} else {
			실패 페이지~
		}
		*/
		
		// 3단계
		// 자바를 이용해서 응답페이지 넘기기 (JAVA코드 안에 HTML코드를 넣을 수 있음)
		// 장점 : Java코드 내에서 작성하기 때문에 조건문, 유용한 메소드들(자바꺼)을 활용 가능
		// 단점 : 복잡, 혹시라도 나중에 HTML수행할 때 JAVA코드 내에서 수정이 이루어지기 때문에
		//		수정한 내용을 반영하려면 서버를 restart해야함
		
		
		// * response객체를 통해 사용자에게 HTML(응답화면) 전달
		// 1단계 ) 이제부터 내가 출력할 내용은 문서형태의 HTML이고 문자셋은 UTF-8을 사용하겠다.
		response.setContentType("text/html; charset=UTF-8");
		
		// 2단계 ) 응답하고자하는 사용자와의 스트림을 연결(클라이언트와의 통로를 생성)
		PrintWriter out = response.getWriter();
		
		// 3단계 ) 생성된 스트림을 통해 응답 HTML구문을 출력
		out.println("<html>");
		out.println("<head>");
		
		out.println("<style>");
		
		out.println("h1{color : orangered};");
		out.println("#name{color : skyblue}");
		out.println("#age{color : red}");
		out.println("#city{color : yellowgreen}");
		out.println("#height{color : blue}");
		out.println("#gender{color : purple}");
		out.println("li{color : pink}");
		
		
		
		out.println("</style>");
		
		
		
		
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1>개인정보 응답화면</h1>");
		
		/*
		 * XXX님은
		 * XX살이며
		 * XXX에 삽니다
		 * 키는 XXXcm이고
		 * 
		 * 성별은 case1. 선택을 안했습니다.
		 * 	   case2. 남자/여자입니다.
		 * 
		 * 좋아하는 음식은 case1. 없습니다.
		 * 			 case2. 뭐시기 뭐시기
		 */
		
		out.printf("<span id='name'>%s</span>님은 <br>", name);
		out.printf("<span id='age'>%d</span>살이며 <br>", age);
		out.printf("<span id='city'>%s</span>에 삽니다. <br>", city);
		
		out.printf("키는 <span id='height'>%.1f</span>cm이고, <br>", height);
		
		out.print("성별은 ");
		if(gender == null) {
			out.println("선택을 안했습니다");
		} else {
			
			if(gender.equals("M")){
				out.println("<span id='gender'>남자</span>입니다. <br>");
			} else {
				out.println("<span id='gender'>여자</span>입니다. <br>");
			}
		}
		
		out.print("좋아하는 음식은 ");
		if(foods == null) {
			out.println("없어요");
		} else {
			out.println("<ul>");
			
			for(int i = 0; i < foods.length; i++ ) {
				out.printf("<li>%s</li>", foods[i]);
			}
			
			out.println("</ul>");
		}
		
		out.println("</body>");
		out.println("<html>");
		
		
		
		
		
		
		
		
		
		
		
	}
	

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
