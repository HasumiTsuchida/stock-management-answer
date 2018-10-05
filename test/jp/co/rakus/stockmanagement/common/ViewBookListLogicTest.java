package jp.co.rakus.stockmanagement.common;

import java.util.List;

import jp.co.rakus.stockmanagement.viewbooklist.ViewBookListLogic;

/**
 * 書籍一覧を表示するロジッククラスとDaoクラスが作成できているかテストするクラス.
 * 
 * @author rakus
 * 
 */
public class ViewBookListLogicTest {
	public static void main(String[] args) {
		List<Book> bookList = ViewBookListLogic.execute();
		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			System.out.println("name=" + book.getName());
		}
	}
}
