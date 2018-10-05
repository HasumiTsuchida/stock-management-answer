package jp.co.rakus.stockmanagement.viewbookdetail;

import jp.co.rakus.stockmanagement.common.Book;
import jp.co.rakus.stockmanagement.common.BookDao;

/**
 * 1件の書籍情報を取得するロジッククラスです.
 * @author rakus
 *
 */
public class ViewBookDetailLogic {

	/**
	 * 1件の書籍情報を取得します.
	 * @param id 書籍ID
	 * @return 検索された書籍情報
	 */
	public static Book execute(int id) {

		Book book = BookDao.load(id);

		return book;
	}
}
