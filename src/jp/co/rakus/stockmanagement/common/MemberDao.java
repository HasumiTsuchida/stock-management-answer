package jp.co.rakus.stockmanagement.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * menbersテーブルを操作するData Access Object.
 * 
 * @author rakus
 * 
 */
public class MemberDao {
	//初期記載の「members」から「member」にテーブル変更 author 土田
	//コメント追加
	private final static String tableName = "member";

	/**
	 * メンバー情報を登録します.
	 * 
	 * @param member
	 *            登録したいメンバー情報
	 * @exception 何らかのエラーが発生した場合はRuntimeExceptionを発生します
	 */
	public static void insert(Member member) {
		String sql = "insert into " + tableName
				+ " (name, mail_address, password) " + "values(?, ?, ?)";

		Connection con = DBManager.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getMailAddress());
			pstmt.setString(3, member.getPassword());

			pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			ex.printStackTrace();
			throw new RuntimeException("メンバー情報の登録に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con);
		}
	}

	/**
	 * メールアドレスとパスワードが一致するメンバー情報を取得します.
	 * 
	 * @param mailAddress
	 *            メールアドレス
	 * @param password
	 *            パスワード
	 * @return メンバー情報 一致するメンバーがいなければnullを返します
	 * @exception 何らかのエラーが発生した場合はRuntimeExceptionを発生します
	 */
	public static Member findByMailAddressAndPassword(String mailAddress,
			String password) {
		String sql = "select id,name,password,mail_address" + " from "
				+ tableName + " where mail_address = ? and password = ?";

		Connection con = DBManager.createConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, mailAddress);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setMailAddress(rs.getString("mail_address"));
				member.setPassword(rs.getString("password"));
			}
			return member;

		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			throw new RuntimeException("メンバー情報の取得に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con);
		}
	}
}
