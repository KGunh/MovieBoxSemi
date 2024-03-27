package com.kh.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.theater.model.vo.Screen;

/**
 * Servlet implementation class SelectScreenServlet
 */
@WebServlet("*.reservation.ajax")
public class SelectScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectScreenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// screen테이블과 조인하여 상영관 정보 가져오기
		List<Screen> screenList = new ReservationController().selectScreen(request);
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(screenList, response.getWriter());		
		// 반복문으로 보여주기
		
		// 더보기 버튼 만들기
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
