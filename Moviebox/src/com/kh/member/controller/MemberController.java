package com.kh.member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.Answer;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.Reservation;
import com.kh.goods.model.vo.Order;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.movie.model.vo.Movie;

public class MemberController {

	public String login(HttpServletRequest request, HttpServletResponse response) {
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		Member m = new Member();
		
		m.setMemberId(memberId);
		m.setMemberPwd(memberPwd);
		HttpSession session = request.getSession();
		

		Member loginUser = new MemberService().login(m);
		String view = "";
		if(loginUser != null) {
			
			
			session.setAttribute("loginUser", loginUser);
			
			session.setAttribute("alertMsg", "로그인 성공");
			
		} else {
			session.setAttribute("alertMsg", "잘못된 로그인 정보입니다.");
			
			view = "/loginForm.me";
		}
		
		
		return view;
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		String view = "index.jsp";
		
		return view;
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String localCode = request.getParameter("localCode");
		String address = request.getParameter("address");
		String[] genres = request.getParameterValues("genre");
		
		Member m = new Member();
		String view = "";
		
		List<Genre> genreList = new ArrayList();
		
		if(genres != null) {
			for(int i = 0;i< genres.length; i++) {
				Genre g = new Genre();
				g.setGenreName(genres[i]);
				genreList.add(g);
			}
		}
		

		
		
	
		m.setMemberId(memberId);
		m.setMemberPwd(memberPwd);
		m.setMemberName(memberName);
		m.setBirthday(birthday);
		m.setGender(gender);
		m.setEmail(email);
		m.setPhone(phone);
		m.setLocalCode(localCode);
		m.setAddress(address);

		
		
		
		
		int result = new MemberService().insert(m,genreList);
		
		
		if(result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입에 성공했습니다.");
		}else {
			request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
			view = "views/common/errorPage.jsp";
		}
		
		return view;
	}
	
	public String myPagePrint(HttpServletRequest request, HttpServletResponse response) {
		
		String view = "";
		HttpSession session = request.getSession();
		List<Movie> movieList = new ArrayList();
		List<Answer> answerList = new ArrayList();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		if(loginUser == null) {
			return view = "views/member/myPage.jsp";
		} else {

			List<Reservation> list = new MemberService().myPagePrint(loginUser);
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					Reservation res = list.get(i);
					Movie m = new MemberService().myPageMoviePoster(res);
					if (m == null) {
						request.setAttribute("errorMsg", "");
						return view = "views/common/errorPage.jsp";
					}

					movieList.add(m);

				}
				request.setAttribute("movieList", movieList);
				request.setAttribute("list", list);
				view = "views/member/myPage.jsp";
			}
			
			
			List<Board> boardList = new MemberService().myPageBoardPrint(loginUser);
			
			

			if(!boardList.isEmpty()) {
				
				for(int i=0;i<boardList.size();i++) {
					Board board = boardList.get(i);		
					Answer a = new MemberService().myPageBoardAnswer(board);
					if(a != null) {
					answerList.add(a);
					}
				}
				request.setAttribute("boardList", boardList);
			}
			if(!answerList.isEmpty()) {
				request.setAttribute("answerList", answerList);
			}
			
			List<Order> orderList = new MemberService().myPageOrderPrint(loginUser);
			
			if(!orderList.isEmpty()) {
				
				request.setAttribute("orderList", orderList);
			}
			
			
			view = "views/member/myPage.jsp";
		}
		
		

		return view;
	}
	

	public String myReservation(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		HttpSession session = request.getSession();
		List<Movie> movieList = new ArrayList();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd, HH:mm");
		
		Date current = new Date();
		
		boolean isBeforeCurrent = true;
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return view = "views/member/myPage.jsp";
		} else {
			List<Reservation> list = new MemberService().myPagePrint(loginUser);
			
			
			if (list.isEmpty()) {
				return view ="views/member/myReservation.jsp";
			} else {

				
				for (int i = 0; i < list.size(); i++) {
					Reservation res = list.get(i);
					Movie m = new MemberService().myPageMoviePoster(res);
					if (m == null) {
						request.setAttribute("errorMsg", "");
						return view = "views/common/errorPage.jsp";
					}
					Date watchDate;
					try {
						watchDate = dateFormat.parse(list.get(i).getWatchDate());
						isBeforeCurrent = watchDate.before(current);
						list.get(i).setBeforeCurrent(isBeforeCurrent);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					
		

					movieList.add(m);

				}

				
				request.setAttribute("list", list);
				request.setAttribute("movieList", movieList);

				view = "views/member/myReservation.jsp";
			}
			
		}
		
		
		return view;
	}
	
	public String pwdCheck(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		String CheckPwd = request.getParameter("memberPwd");

		
		
		String loginUserPwd = loginUser.getMemberPwd();

		if(CheckPwd.equals(loginUserPwd)) {
			view = "views/member/myPageModify.jsp";
		} else {
			session.setAttribute("alertMsg", "잘못된 비밀번호입니다 다시 입력해주세요.");
			view = "views/member/myPagePwdCheck.jsp";
		}
		return view;
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String localCode = request.getParameter("localCode");
		String[] genres = request.getParameterValues("genre");
		
		Member m = new Member();
		
		List<Genre> genreList = new ArrayList();
		
		
		if(genres != null) {
			for(int i = 0;i< genres.length; i++) {
				Genre g = new Genre();
				g.setGenreName(genres[i]);
				genreList.add(g);
			}
		}
		m.setMemberNo(loginUser.getMemberNo());
		m.setEmail(email);
		m.setLocalCode(localCode);
		m.setAddress(address);
		System.out.println(m.getAddress());
		int result = new MemberService().update(m,genreList);
		
		
		if(result > 0) {
			session.setAttribute("alertMsg", "수정에 성공했습니다.");
			
			
			Member updateMem = new MemberService().login(loginUser);
			
			session.setAttribute("loginUser", updateMem);
			
			view = "/Updateform.me";
		}else {
			session.setAttribute("alertMsg", "수정에 실패했습니다.");
			view = "/Updateform.me";
		}
		
		return view;
	}
	
	public void pwdDuplicationCheck(HttpServletRequest request, HttpServletResponse response) {
		String checkPwd = request.getParameter("checkPwd");
		
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		String loginUserPwd = loginUser.getMemberPwd();
		response.setContentType("text/html; charset=UTF-8");
		
		if(checkPwd.equals(loginUserPwd)) {
			try {
				response.getWriter().print("Y");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().print("N");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public String updatePwd(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String view = "";
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int memberNo = loginUser.getMemberNo();
		String changePwd = request.getParameter("changePwd");
		
		
		Member m = new Member();
		
		m.setMemberNo(memberNo);
		m.setMemberPwd(changePwd);
		
		int result = new MemberService().updatePwd(m);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "수정에 성공했습니다.");
			
			loginUser.setMemberPwd(changePwd);
			Member updateMem = new MemberService().login(loginUser);
			
			session.setAttribute("loginUser", updateMem);
			
			view = "/Updateform.me";
		}else {
			session.setAttribute("alertMsg", "수정에 실패했습니다.");
			view = "/Updateform.me";
		}
		
		return view;
		
	}
	
	public String idSearch(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String view = "";
		String memberName = request.getParameter("memberName");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		
		Member m = new Member();
		
		m.setMemberName(memberName);
		m.setBirthday(birthday);
		m.setPhone(phone);
		String memberId = new MemberService().idSearch(m);
		
		if(memberId != "") {
			request.setAttribute("memberId", memberId);
			view = "views/member/idSearchResult.jsp";
		} else {
			session.setAttribute("alertMsg", "아이디를 찾지 못했습니다. 다시입력해주세요");
			view = "views/member/idSearchForm.jsp";
		}
		return view;
		
		
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		String CheckPwd = request.getParameter("memberPwd");

		
		
		String loginUserPwd = loginUser.getMemberPwd();
		
		if(CheckPwd.equals(loginUserPwd)) {
			int result = new MemberService().deleteMember(loginUser);
			
			if(result > 0) {
				session.setAttribute("alertMsg", "회원 탈퇴에 성공했습니다.");
				session.invalidate();
			} else {
				session.setAttribute("alertMsg", "회원 탈퇴에 실패했습니다.");
				view = "/Updateform.me";
			}
			
			
		} else {
			session.setAttribute("alertMsg", "잘못된 비밀번호 입니다.");
			view = "/Updateform.me";
		}
		
		
		return view;
	}
	
	public String pwdSearch(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String view = "";
		
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		
		Member m = new Member();
		
		m.setMemberId(memberId);
		m.setMemberName(memberName);
		m.setBirthday(birthday);
		m.setPhone(phone);
		int memberNo = new MemberService().memberNoSearch(m);
		
		
		if(memberNo > 0) {
			request.setAttribute("memberNo", memberNo);
			view = "views/member/pwdSearchResult.jsp";
		} else {
			session.setAttribute("alertMsg", "아이디를 찾지 못했습니다. 다시입력해주세요");
			view = "views/member/pwdSearchForm.jsp";
		}
		return view;
	}
	
	public String pwdSearchUpdate(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		HttpSession session = request.getSession();
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String changePwd = request.getParameter("memberPwd");
		
		Member m = new Member();
		
		m.setMemberNo(memberNo);
		m.setMemberPwd(changePwd);
		
		int result = new MemberService().updatePwd(m);
		
		
		if(result > 0) {
			session.setAttribute("alertMsg", "수정에 성공하였습니다 로그인화면으로 이동합니다.");
			
			view = "/loginForm.me";
		}else {
			session.setAttribute("alertMsg", "수정에 실패했습니다.");
			view = "/pwdSearchForm.me";
		}
		
		return view;
	}
	
	public void idCheck(HttpServletRequest request, HttpServletResponse response) {
		String checkId = request.getParameter("checkId");
		
		int count = new MemberService().idCheck(checkId);
		
		response.setContentType("text/html; charset=UTF-8");

		try {
			response.getWriter().print(count > 0 ? "N" : "Y");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void reservationCancel(HttpServletRequest request, HttpServletResponse response) {
		
		int ticketNo = Integer.parseInt(request.getParameter("cancelKey"));
		

		
		int result = new MemberService().reservationCancel(ticketNo);
		
		response.setContentType("text/html; charset=UTF-8");

		try {
			response.getWriter().print(result > 0 ? "Y" : "N");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
