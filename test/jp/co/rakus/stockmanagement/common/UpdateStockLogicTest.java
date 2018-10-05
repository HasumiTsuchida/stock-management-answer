package jp.co.rakus.stockmanagement.common;

import jp.co.rakus.stockmanagement.updatestock.UpdateStockLogic;
import jp.co.rakus.stockmanagement.viewbookdetail.ViewBookDetailLogic;

public class UpdateStockLogicTest {
	
	public static void main(String[] args) {
		
		UpdateStockLogic.execute(1, 0);
		Book book = ViewBookDetailLogic.execute(1);
		System.out.println("id = " + book.getId());
		System.out.println("stock = " + book.getStock());
	}
	
}
