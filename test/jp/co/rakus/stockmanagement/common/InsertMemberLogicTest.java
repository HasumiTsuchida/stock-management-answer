package jp.co.rakus.stockmanagement.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.rakus.stockmanagement.insertmember.InsertMemberLogic;

/**
 * Memberを登録するロジッククラスとDaoクラスが作成できているかテストするクラス.
 * 
 * @author rakus
 * 
 */
public class InsertMemberLogicTest {
	public static void main(String[] args) {
		// データを入れる
		Member Member = new Member(-1, "ラクス", "rakus@rakus.co.jp", "rakus");
		InsertMemberLogic.execute(Member);

		// 入れたデータを取り出して一致するかテスト
		String sql = "select name,mail_address,password" + " from members"
				+ " where name = 'ラクス'";
		Connection con = DBManager.createConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			String name = null;
			String password = null;
			String mailAddress = null;
			if (rs.next()) {
				name = rs.getString("name");
				mailAddress = rs.getString("mail_address");
				password = rs.getString("password");
			}
			if ("ラクス".equals(name) && "rakus@rakus.co.jp".equals(mailAddress)
					&& "rakus".equals(password)) {
				System.out.println("成功");
			} else {
				System.out.println("失敗");
			}
		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			ex.printStackTrace();
			System.out.println("失敗");
		} finally {
			DBManager.closeConnection(con);
		}
	}
}
