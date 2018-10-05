package jp.co.rakus.stockmanagement.updatestock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在庫数を変更するサーブレット.
 * 
 * @author rakus
 * 
 */
@WebServlet("/UpdateStockServlet")
public class UpdateStockServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得します
		String stringBookId = request.getParameter("id");
		String stringStock = request.getParameter("stock");

		// 数値チェック
		List<String> errorList = validate(stringBookId, stringStock);

		// エラーなら書籍詳細画面へ
		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);

			RequestDispatcher rd = request
					.getRequestDispatcher("/ViewBookDetailServlet");
			rd.forward(request, response);
			return;
		}

		// 在庫更新
		int bookId = Integer.parseInt(stringBookId);
		int stock = Integer.parseInt(stringStock);
		UpdateStockLogic.execute(bookId, stock);

		RequestDispatcher rd = request.getRequestDispatcher("/ViewBookListServlet");
		rd.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet!!");
		doPost(request, response);
	}

	/**
	 * 書籍情報変更時に不正な値が含まれていないか確認します
	 * 
	 * @param stringBookId
	 *            書籍ID
	 * @param stringStock
	 *            変更する在庫数
	 * @return エラーメッセージが入っているリストを返します。エラーが無い場合は0件のリストを返します
	 */
	private List<String> validate(String stringBookId, String stringStock) {
		List<String> errorList = new ArrayList<String>();

		int bookId;
		int stock;
		try {
			bookId = Integer.parseInt(stringBookId);
			stock = Integer.parseInt(stringStock);

			if (bookId < 0 || stock < 0) {
				errorList.add("入力された値が不正です");
			}

		} catch (NumberFormatException e) {
			errorList.add("入力された値が不正です");
		}

		return errorList;
	}

}
