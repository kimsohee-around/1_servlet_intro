package org.iclass;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(description = "회원등록 입력값 저장 서블릿", urlPatterns = { "/member/save" })   //member 서브디렉토리 만들었습니다.
public class MemberSaveServlet extends HttpServlet {   //http요청처리 서블릿 : extends HttpServlet
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberSaveServlet.class);
       

	//서블릿이 생성되고 컨테이너로 관리가 시잘될 때 실행되는 메소드
	public void init(ServletConfig config) throws ServletException {
		logger.info("[MyInfo]회원등록 입력값 저장 서블릿 초기화");
	}

	//form 태그의 입력값을 전달받아 request(url,header,body 데이터로 구성) 의 body 에 저장하는 방식이 POST 
	//요청 메소드가 POST 일떄 - service 메소드와 선택해서 하나만 사용합니다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력 파라미터 받아서  db insert
		//		ㄴ id, name, age, address -> 4개의 필드 정의하는 User클래스
		//1)파라미터가 값이 없으면 parseInt 오류인지 확인. 2)post 방식 인코딩 확인
		//POST 요청 파라미터는 UTF-8 인코딩 필요(톰캣버전 9이하)
		request.setCharacterEncoding("UTF-8");
		int age;
		if(request.getParameter("age").equals("")) age=0;
		else age = Integer.parseInt(request.getParameter("age"));
		User user = new User(request.getParameter("id"), 
				request.getParameter("name"),
				age,
//				Integer.parseInt(request.getParameter("age")),   //Exception 발생가능성 : for input string ""
				request.getParameter("address"));
		
		//할일 : dao 메소드 호출해서 user 객체 insert
		logger.info("user insert : {}",user);
		
		//리다이렉트
		response.sendRedirect("../");
		//response.sendRedirect("list");    //현재 서블릿 url /member/save
	}

}
