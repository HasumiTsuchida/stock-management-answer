package jp.co.rakus.stockmanagement.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.co.rakus.stockmanagement.common.Member;

/**
 * ログインチェックフィルタ.
 * 
 * @author igamasayuki
 *
 */
@WebFilter("/*")
public class LoginCheckFilter implements Filter {

	/**
	 * ログインチェックを行わないURLパターン
	 */
	private final static String MATCHPARAM = "(^.*Login.*)|(^.*InsertMember.*)|(^.+[.](gif|css|jpg)$)";

	/**
	 * ログインチェックを行う本体となるメソッド.
	 * <pre>
	 *　　ログインされていなければ(スコープにMemberオブジェクトがなければ)ログイン画面へ遷移します。
	 *　　ただし、ログインしていなくても遷移できるURL(ログイン関連処理やメンバー登録関連のURL)の場合は、
	 *　　指定のURLへ遷移します。
	 *
	 *　　ログインされていれば(スコープにMemberオブジェクトがあれば)指定のURLへ遷移します。
	 * 
	 *　　(ex)
	 *　　URLに"Login"や"InsertMember"が含まれるかどうかチェックし、
	 *　　含まれない場合：フィルタをかける
	 *　　/ViewBookListServlet
	 *　　含まれる場合：フィルタをかけない
	 *　　/ViewLoginServlet /LoginServlet
	 *　　/ViewInsertMemberServlet /InsertMemberServlet
	 * </pre>
	 * 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ここに前処理
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// リクエストされたURLのURI以下を取得
		String urlparam = (httpServletRequest.getRequestURI());
		// URI部分を破棄する
		String replaced = urlparam.replaceAll(
				httpServletRequest.getContextPath(), "");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		Member member = (Member) session.getAttribute("member");

		Pattern pattern = Pattern.compile(MATCHPARAM);
		Matcher matcher = pattern.matcher(replaced);
		if (!(matcher.find())) {
			// ログインされていなければ(スコープにMemberオブジェクトがなければ)ログイン画面へ戻す
			if (member == null) {
				RequestDispatcher rdloginError = request
						.getRequestDispatcher("/ViewLoginServlet");
				rdloginError.forward(request, response);
				return;
			}
		}
		chain.doFilter(request, response);
		// ここに後処理
	}

	/**
	 * フィルタを初期化するためのメソッド.
	 * 
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * Webアプリケーションによって破棄されるときに呼び出されるメソッド.
	 * 
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

}
