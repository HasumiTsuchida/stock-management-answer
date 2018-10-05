package jp.co.rakus.stockmanagement.login;

import jp.co.rakus.stockmanagement.common.Member;
import jp.co.rakus.stockmanagement.common.MemberDao;

/**
 * ログイン処理を行うロジッククラスです.
 * 
 * @author rakus
 * 
 */
public class LoginLogic {

	/**
	 * ログイン処理を行います.
	 * 
	 * @param mailAddress
	 *            メールアドレス
	 * @param password
	 *            パスワード
	 * @return 引数で渡されたメールアドレスやパスワードが一致するメンバーがいればそのメンバー情報を返します.
	 *         一致するメンバーがいなければnullを返します
	 */
	public static Member execute(String mailAddress, String password) {

		Member member = MemberDao.findByMailAddressAndPassword(mailAddress,
				password);

		return member;
	}
}
