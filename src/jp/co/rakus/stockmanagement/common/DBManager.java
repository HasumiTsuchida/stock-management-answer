package jp.co.rakus.stockmanagement.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB接続＆切断用共通クラス.
 * 
 * @author rakus
 * 
 */
public class DBManager {
	private final static String dbName = "student";
	private final static String url = "jdbc:postgresql://localhost:5432/"
			+ dbName;
	private final static String userName = "postgres";
	private final static String password = "postgres";

	/**
	 * DBに接続し、接続情報を呼び出し元に返します.
	 * 
	 * @return Connectionオブジェクト
	 * @exception 接続に失敗したらRuntimeExceptionをthrowします
	 */
	public static Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, userName,
					password);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB接続に失敗しました", e);
		}
	}

	/**
	 * 渡されたConnectionオブジェクトの接続を切断します.
	 * 
	 * @param con
	 *            Connectionオブジェクト
	 */
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
		}
	}
}
