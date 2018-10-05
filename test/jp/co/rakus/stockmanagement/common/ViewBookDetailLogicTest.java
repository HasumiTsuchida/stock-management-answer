package jp.co.rakus.stockmanagement.common;

import jp.co.rakus.stockmanagement.viewbookdetail.ViewBookDetailLogic;

/**
 * 書籍一覧を表示するロジッククラスとDaoクラスが作成できているかテストするクラス.
 * 
 * @author rakus
 * 
 */
public class ViewBookDetailLogicTest {
	public static void main(String[] args) {
		Book book = ViewBookDetailLogic.execute(1);
		System.out.println("name=" + book.getName());
	}
}
