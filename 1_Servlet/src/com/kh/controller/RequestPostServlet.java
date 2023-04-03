package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("거짓말이라도 진짜라고 생각할래요");
		
		// 1. 데이터가공
		// 2. 응답화면지정
		
		// 0단계)
		// POST방식의 기본 인코딩 설정 ISO-8859-1 이상한애로 설정
		// POST방식의 경우 값을 뽑기전에 미리 UFT-8방식으로 인코딩 설정을 진행해함
		request.setCharacterEncoding("UTF-8");
		
		
		// 1단계)
		// request.getParameter() 또는 request.getParameterValues()로 값 뽑아내기
		String name = request.getParameter("name"); // : String
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String city = request.getParameter("city");
		double height = Double.parseDouble(request.getParameter("height"));
		String[] foods = request.getParameterValues("food");
		
		/*		
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(city);
		System.out.println(height);
		
		if(foods == null) {
			System.out.println("없음");
		} else {
		 System.out.println(String.join("-", foods));
		}
		*/
		
		// 2단계)
		// 처리 -> Service -> DAO -> DB
		
		
		// 3단계
		// 응답데이터
		// 3_1. JSP이용해서 응답페이지 만들기
		// JSP(Java Server Page) : HTML내에서 JAVA코드를 쓸 수 있음
		
		// 응답화면(jsp)에서 필요한 데이터들을 request객체에 담아서 보내줄것
		// Parameter영역은 getParameter OOO / setParameter XXX
		// request에 attribute영역이 있음 => 키 - 밸류 세트로 묶어서 담을 수 있음
		// request.setAttribute(키, 밸류);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("gender", gender);
		request.setAttribute("city", city);
		request.setAttribute("foods", foods);
		request.setAttribute("height", height);
		
		request.setAttribute("msg", "졸려요");
		
		// 3_2. 현재 작업중인 doGet()에서 응답페이지를 만드는 과정을 위임해야한다.
		// 응답페이지를 JSP에게 위임(떠넘기기)
		
		// 위임 시 필요한 객체 : RequestDispatchar
		// 1) 응답하고자 하는 뷰(jsp)를 선택하면서 request.getRequestDIspatcher(jsp경로);
		RequestDispatcher view = request.getRequestDispatcher("view/responsePage.jsp");
		
		// 2) forwarding : forward()
		view.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("아니 나는 졸리다고 쓸거야");
		doGet(request, response);
	}

}
