package jp.co.rakus.stockmanagement.viewbooklist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.rakus.stockmanagement.common.Book;

/**
 * 書籍一覧画面を表示するサーブレット.
 * 
 * @author rakus
 * 
 */
@WebServlet("/ViewBookListServlet")
public class ViewBookListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 表示する書籍一覧を取得し、リクエストスコープへ格納します
		List<Book> bookList = ViewBookListLogic.execute();
		request.setAttribute("bookList", bookList);

		// 書籍一覧画面へフォワードします
		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/viewBookList.jsp");
		rd.forward(request, response);
	}

}
