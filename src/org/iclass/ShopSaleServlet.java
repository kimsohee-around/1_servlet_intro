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

@WebServlet(urlPatterns = {"/shop/sale"} , description = "매출현황 처리")
public class ShopSaleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ShopSaleServlet.class);
	
	@Override
	public void init() throws ServletException {
		logger.info("[MyInfo]매출현황 서블릿 초기화");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//브라우저 document(문서)에 출력 - document.write()
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//request를 index.jsp 파일로 전달합니다.목적은 `서블릿 처리 결과 데이터`를 request 에 담아 보냅니다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/sale.jsp");
		dispatcher.forward(request, response);
	}
}











