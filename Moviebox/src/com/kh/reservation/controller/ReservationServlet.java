package com.kh.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReservationviewServlet
 */
@WebServlet("*.reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
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
			case "movie" : view = rc.selectReservationInfo(request); break; 
			case "payment" : view = rc.insertReservation(request); break;
			case "seat" : view = rc.connectSeatList(request); break;
		}
		
		if(request != null && response != null) {
			if(flag) {
				response.sendRedirect(view);
			} else {
				request.getRequestDispatcher(view).forward(request, response);
			}
		} else if(view.contains("errorPage")) {
			HttpSession session = request.getSession();
			
			session.setAttribute("alertMsg", "잘못된 요청입니다.");
			
			view = "views/common/errorPage.jsp";
			
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
