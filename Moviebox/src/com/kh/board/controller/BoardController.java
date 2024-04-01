package com.kh.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.common.model.vo.PageInfo;

public class BoardController {

	
	// 전체 화면 보기
	public String selectBoardList(HttpServletRequest request, HttpServletResponse response) {
		
		// 페이징바 
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;

		listCount = new BoardService().selectListCount();


		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 5;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		// 5 => 1, 6, 11, 16 ... n * 5(페이징단위) + 1 
		//			 startPage = n * pageLimit  + 1;
		// n = (currentPage - 1) / pageLimit
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
//		System.out.println(pi);
		
		ArrayList<Board> list = new BoardService().selectBoardList(pi);
		
		
		// 전체 목록 출력
//		ArrayList<Board> list = new BoardService().selectBoardList();
		request.setAttribute("boardList", list);
		request.setAttribute("pageInfo", pi);

		String view = "views/board/boardList.jsp";
		
		return view;
	}
	
	// 상세보기
	public String detailBoard(HttpServletRequest request, HttpServletResponse response) {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board board = new BoardService().detailBoard(boardNo);
		request.setAttribute("board", board);
		String view = "views/board/boardDetail.jsp";
		
		return view; 
	}
	
	// 카테고리 글 작성
	public String selectCategoryList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Category> list = new BoardService().selectCategoryList();
		request.setAttribute("category", list);
		
		String view = "views/board/boardInsertForm.jsp";
		
		return view;
	}
	
	
	// 글 작성
	public String insertBoard(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		int categoryNo = Integer.parseInt(request.getParameter("category"));
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		Board board = new Board();
		board.setCategoryNo(categoryNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setUserNo(userNo);
		
		int result = new BoardService().insertBoard(board);
		request.setAttribute("board", board);
		
		String view = "";
		
		if(result > 0) {
			session.setAttribute("alertMsg", "문의사항이 등록되었습니다.");
			view = "/list.board?currentPage=1";
		} else {
			session.setAttribute("alertMsg", "문의사항 작성 실패");
			view = "views/board/boardInsertForm.jsp";
		}
		
		return view;
	}
	
	
	// 글 수정
	public String updateBoard(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		int boardCategory = Integer.parseInt(request.getParameter("category"));
		
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		Board board = new Board();
		board.setCategoryNo(boardCategory);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardNo(boardNo);
		
		int result = new BoardService().updateBoard(board);
		request.setAttribute("board", result);
		
		String view = "";
		
		if(result > 0) {
			session.setAttribute("alertMsg", "수정 완료");
			view = "/detail.board?boardNo=" + boardNo;
		} else {
			session.setAttribute("alertMsg", "수정 실패");
			view = "view/board/boardUpdateForm.jsp";
		}
		
		return view;
	}
	
	
	public String updateBoardForm(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<Category> list = new BoardService().selectCategoryList();
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board board = new BoardService().detailBoard(boardNo);
		
		request.setAttribute("category", list);
		request.setAttribute("board", board);
		
		String view = "views/board/boardUpdateForm.jsp";
		
		return view;
	}
	
	
	public String deleteBoard(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String boardNo = request.getParameter("boardNo");
		int result = new BoardService().deleteBoard(boardNo);
		
		String view = "";
		
		if(result > 0) {
			session.setAttribute("alertMsg", "문의글이 삭제되었습니다.");
			view ="/list.board?currentPage=1";
		} else {
			session.setAttribute("alertMsg", "문의글 삭제 실패");
			view = "/list.board?currentPage=1";
		}
		
		return view;
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
