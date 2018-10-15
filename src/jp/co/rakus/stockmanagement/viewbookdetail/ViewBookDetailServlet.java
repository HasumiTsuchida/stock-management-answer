package jp.co.rakus.stockmanagement.viewbookdetail;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.rakus.stockmanagement.common.Book;

/**
 * 書籍詳細画面を表示するサーブレット.
 * 
 * @author rakus
 * 
 */
@WebServlet("/ViewBookDetailServlet")
public class ViewBookDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得します
		String stringBookId = request.getParameter("id");
		int bookId = Integer.parseInt(stringBookId);

		// 書籍を検索しリクエストスコープに格納します
		Book book = ViewBookDetailLogic.execute(bookId);
		request.setAttribute("book", book);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/viewBookDetail.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
