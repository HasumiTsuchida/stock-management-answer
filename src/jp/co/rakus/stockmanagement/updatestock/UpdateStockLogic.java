package jp.co.rakus.stockmanagement.updatestock;

import jp.co.rakus.stockmanagement.common.Book;
import jp.co.rakus.stockmanagement.common.BookDao;

/**
 * 書籍の在庫数を変更するロジッククラス.
 * @author rakus
 *
 */
public class UpdateStockLogic {

	/**
	 * 書籍の在庫数を変更します.
	 */
	public static void execute(int id,int stock) {

		Book book = BookDao.load(id);
		book.setStock(stock);
		BookDao.update(book);

	}
}
