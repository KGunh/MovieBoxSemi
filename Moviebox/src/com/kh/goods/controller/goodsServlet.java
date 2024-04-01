package com.kh.goods.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.reservation.controller.ReservationController;

/**
 * Servlet implementation class goodsServlet
 */
@WebServlet("*.goods")
public class goodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String mapping = uri.substring(uri.lastIndexOf("/") + 1 , uri.lastIndexOf("."));
		ReservationController rc = new ReservationController(); 
		
		String view = "";
		
		boolean flag = false;
		
		switch(mapping) {
		case "list" : view = "views/goods/goodsList.jsp"; break; 
		//case "seat" : view = rc.connectSeatList(request); break;
		//case "payment" : view = rc.insertReservation(request); break;
		}
		
		if(flag) {
			response.sendRedirect(view);
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
