package jp.co.rakus.stockmanagement.insertmember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.rakus.stockmanagement.common.Member;

/**
 * メンバー情報を登録するサーブレット.
 * 
 * @author rakus
 * 
 */
@WebServlet("/InsertMemberServlet")
public class InsertMemberServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得します
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String mailAddress = request.getParameter("mailAddress");
		String password = request.getParameter("password");

		// 入力値チェック
		// エラーならエラーリストをリクエストスコープに保存して
		// メンバー登録画面に戻ります
		List<String> errorList = validate(name, mailAddress, password);
		if (errorList.size() > 0) {

			request.setAttribute("errorList", errorList);

			// 入力した値がフォームに残るように
			request.setAttribute("name", name);
			request.setAttribute("mailAddress", mailAddress);
			request.setAttribute("password", password);

			RequestDispatcher rd = request
					.getRequestDispatcher("/ViewInsertMemberServlet");
			rd.forward(request, response);

			return;
		}

		// エラーがなければ登録します
		Member member = new Member(-1, name, mailAddress, password);
		InsertMemberLogic.execute(member);

		RequestDispatcher rd = request
				.getRequestDispatcher("/ViewLoginServlet");
		rd.forward(request, response);
	}

	/**
	 * メンバー登録時の入力値チェックを行います.
	 * 
	 * @param name
	 *            名前
	 * @param mailAddress
	 *            メールアドレス
	 * @param password
	 *            パスワード
	 * @return エラーメッセージが入っているリストを返します。エラーが無い場合は0件のリストを返します
	 */
	private static List<String> validate(String name, String mailAddress,
			String password) {
		List<String> errorList = new ArrayList<String>();
		String mailPattern = "^[^@]+@[^@]+$";

		if (name == null || "".equals(name)) {
			errorList.add("名前が入力されていません");
		}
		if (mailAddress == null || !mailAddress.matches(mailPattern)) {
			errorList.add("メールアドレスが不正です");
		}
		if (password == null || "".equals(password)) {
			errorList.add("パスワードが指定されていません");
		}

		return errorList;
	}

}
