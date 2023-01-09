package org.iclass;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(description = "회원등록 화면요청을 처리하는 서블릿", urlPatterns = { "/member/join" })   //member 서브디렉토리 만들었습니다.
public class MemberJoinServlet extends HttpServlet {   //http요청처리 서블릿 : extends HttpServlet
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberJoinServlet.class);
       

	//서블릿이 생성되고 컨테이너로 관리가 시잘될 때 실행되는 메소드
	public void init(ServletConfig config) throws ServletException {
		logger.info("[MyInfo]회원등록 화면 서블릿 초기화");
	}

	//아래 3개의 메소드는 요청을 처리하고 응답을 주어야 하므로 인자(매개변수)가 request,response 가 있습니다.
	//http 요청이 생겼을 때 - GET,POST
	/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	*/

	//요청 메소드가 GET 일떄 - service 메소드와 선택해서 하나만 사용합니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 브라우저 document(문서)에 출력 - document.write()
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/join.jsp");
		dispatcher.forward(request, response);
		
	}

	//요청 메소드가 POST 일떄 - service 메소드와 선택해서 하나만 사용합니다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
