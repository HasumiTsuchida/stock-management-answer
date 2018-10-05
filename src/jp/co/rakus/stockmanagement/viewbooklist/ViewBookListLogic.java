package jp.co.rakus.stockmanagement.viewbooklist;

import java.util.List;

import jp.co.rakus.stockmanagement.common.Book;
import jp.co.rakus.stockmanagement.common.BookDao;

/**
 * 書籍一覧を取得するロジッククラスです.
 * 
 * @author rakus
 * 
 */
public class ViewBookListLogic {

	/**
	 * 書籍一覧を取得します
	 * @return 書籍一覧情報
	 */
	public static List<Book> execute() {

		List<Book> bookList = BookDao.findAll();

		return bookList;
	}
}
