package org.iclass;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//{} 기호는 매개변수
		logger.info("[MyInfo] request URL:{}, URI:{}, 컨텍스트패스:{}, 서블릿패스:{}"
		,request.getRequestURL(),request.getRequestURI(),request.getContextPath(),request.getServletPath());
//INFO: [MyInfo] request URL:http://localhost:8081/servlet_intro/login, URI:/servlet_intro/login, 
//								컨텍스트패스:/servlet_intro, 서블릿패스:/login		
		//forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");	//jsp 파일
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("[MyInfo] request method : {}",request.getMethod());
		//login.jsp 에서 받은 파라미터를 처리할수 있습니다.
		//getParameter() 메소드 : 인자는 String 파라미터이름(input태그 name속성값) , 리턴값 String은 input태그 value 속성값
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String message;
		if(password.equals("admin"))
			message ="패스워드 일치합니다.";
		else
			message ="패스워드 불일치 입니다.";
		logger.info("[MyInfo] id:{}-{}",id,message);
		
		//redirect
		response.sendRedirect("./index");
		//url 지정할때 /index 는 컨텍스패스가 없어집니다. 현재위치 ./ 필요
	}
	
	
}
