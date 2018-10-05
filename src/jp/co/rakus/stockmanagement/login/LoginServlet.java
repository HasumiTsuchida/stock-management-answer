package jp.co.rakus.stockmanagement.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.rakus.stockmanagement.common.Member;

/**
 * ログイン処理を行うサーブレット.
 * 
 * @author rakus
 * 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得します
		String mailAddress = request.getParameter("mailAddress");
		String password = request.getParameter("password");

		// ログイン処理を行います
		Member member = LoginLogic.execute(mailAddress, password);

		// ログインに失敗したらエラーメッセージをリクエストスコープに入れて
		// ログイン画面に戻ります
		if (member == null) {
			request.setAttribute("errorMessage", "メールアドレスかパスワードが違います");
			RequestDispatcher rd = request
					.getRequestDispatcher("/ViewLoginServlet");
			rd.forward(request, response);
			return;
		}

		// ログインが成功した場合は
		// メンバー情報をセッションスコープに格納します
		// 最後に書籍一覧を表示するサーブレットへフォワードします
		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		RequestDispatcher rd = request
				.getRequestDispatcher("/ViewBookListServlet");
		rd.forward(request, response);
	}

}
