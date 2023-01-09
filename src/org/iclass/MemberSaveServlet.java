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

@WebServlet(description = "회원등록 입력값 저장 서블릿", urlPatterns = { "/member/save" })   //member 서브디렉토리 만들었습니다.
public class MemberSaveServlet extends HttpServlet {   //http요청처리 서블릿 : extends HttpServlet
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberSaveServlet.class);
       

	//서블릿이 생성되고 컨테이너로 관리가 시잘될 때 실행되는 메소드
	public void init(ServletConfig config) throws ServletException {
		logger.info("[MyInfo]회원등록 입력값 저장 서블릿 초기화");
	}

	//form 태그의 입력값을 전달받아 request(url,header,body) 의 body 에 저장하는 방식이 POST 
	//요청 메소드가 POST 일떄 - service 메소드와 선택해서 하나만 사용합니다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력값을 처리하고  (db 변경)
		//리다이렉트
		response.sendRedirect("../");
		//response.sendRedirect("list");    //현재 서블릿 url /member/save
	}

}
