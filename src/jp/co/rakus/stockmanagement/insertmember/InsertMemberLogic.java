package jp.co.rakus.stockmanagement.insertmember;

import jp.co.rakus.stockmanagement.common.Member;
import jp.co.rakus.stockmanagement.common.MemberDao;

/**
 * メンバーを登録するロジッククラスです.
 * @author rakus
 *
 */
public class InsertMemberLogic {

	/**
	 * メンバーを登録します
	 * @param member メンバー情報
	 */
	public static void execute(Member member){
		MemberDao.insert(member);
	}
}
