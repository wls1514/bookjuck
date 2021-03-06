package com.test.bookjuck.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.bookjuck.dao.NoticeDAO;
import com.test.bookjuck.dto.NoticeDTO;

@WebServlet("/admin/notice/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		
		if (!session.getAttribute("id").equals("adm00")) {
			
			// 접근 권한 없음
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('access denied');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
		}
		
		// 1. 인코딩처리
		// 2. 데이터 가져오기
		// 3. DB 작업
		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		// 2.
		String seq=req.getParameter("seq");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		// 3.
		NoticeDTO dto=new NoticeDTO();
		NoticeDAO dao=new NoticeDAO();
		
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		int result=dao.edit(dto);
		
		if (result==1) {
			// 공지사항 수정 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/admin/notice/detail.do?seq="+seq);
		} else {
			// 글 수정 실패 -> 경고 + 뒤로 가기
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;
			
		}
	}

}