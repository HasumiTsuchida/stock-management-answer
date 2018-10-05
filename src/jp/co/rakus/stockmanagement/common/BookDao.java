package jp.co.rakus.stockmanagement.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * booksテーブルを操作するData Access Object.
 * 
 * @author rakus
 * 
 */
public class BookDao {
	//初期記載の「books」から「book」にテーブル変更
	private final static String tableName = "book";

	/**
	 * 書籍一覧情報を取り出します.
	 * 
	 * @return 全書籍一覧 書籍が存在しない場合はサイズ0件の書籍一覧を返します
	 * @exception 何らかのエラーが発生した場合はRuntimeExceptionを発生します
	 */
	public static List<Book> findAll() {
		List<Book> bookList = new ArrayList<Book>();

		String sql = "select id,name,author,publisher,price,"
				+ "isbncode,saledate,explanation,image,stock from " + tableName
				+ " order by id";
		Connection con = DBManager.createConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();

				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setIsbncode(rs.getString("isbncode"));
				book.setSaleDate(rs.getDate("saledate"));
				book.setExplanation(rs.getString("explanation"));
				book.setImage(rs.getString("image"));
				book.setStock(rs.getInt("stock"));

				bookList.add(book);
			}
			return bookList;
		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			ex.printStackTrace();
			throw new RuntimeException("書籍情報の取得に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con);
		}
	}

	/**
	 * 主キーから書籍情報を取得します.
	 * 
	 * @param id
	 *            検索したい書籍ID
	 * @return 検索された書籍情報 書籍が存在しない場合はnullを返します
	 * @exception 何らかのエラーが発生した場合はRuntimeExceptionを発生します
	 */
	public static Book load(int id) {
		String sql = "select id,name,author,publisher,price,isbncode,saledate,explanation,image,stock"
				+ " from " + tableName + " where id = ?";
		Connection con = DBManager.createConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			Book book = null;
			if (rs.next()) {
				book = new Book();

				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setIsbncode(rs.getString("isbncode"));
				book.setSaleDate(rs.getDate("saledate"));
				book.setExplanation(rs.getString("explanation"));
				book.setImage(rs.getString("image"));
				book.setStock(rs.getInt("stock"));
			}
			return book;
		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			ex.printStackTrace();
			throw new RuntimeException("書籍情報の取得に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con);
		}
	}

	/**
	 * 書籍情報を変更します.
	 * 
	 * @param book
	 *            変更したい情報が入っている書籍情報
	 * @exception 何らかのエラーが発生した場合はRuntimeExceptionを発生します
	 */
	public static void update(Book book) {

		String sql = "update "
				+ tableName
				+ " set name = ?,author = ?,publisher = ?,price = ?,isbncode = ?,saledate = ?,explanation = ?,image = ?,stock = ? where id = ?";
		Connection con = DBManager.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getIsbncode());
			pstmt.setDate(6, new java.sql.Date(book.getSaleDate().getTime()));
			pstmt.setString(7, book.getExplanation());
			pstmt.setString(8, book.getImage());
			pstmt.setInt(9, book.getStock());

			pstmt.setInt(10, book.getId());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.err.println("SQL = " + sql);
			ex.printStackTrace();
			throw new RuntimeException("書籍情報の更新に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con);
		}
	}
}
