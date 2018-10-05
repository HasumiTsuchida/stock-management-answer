package jp.co.rakus.stockmanagement.common;

import java.sql.Timestamp;

/**
 * Bookクラスが作成できているかテストするクラス.
 * 
 * @author rakus
 * 
 */
public class BookTest {

	public static void main(String[] args) {
		Book book = new Book(999, "書籍名", "著者", "出版社", 1000, "ISBNコード",
				new Timestamp(new java.util.Date().getTime()), "説明文", "画像", 100);
		System.out.println("getId() : " + book.getId());
		System.out.println("getName() ： " + book.getName());
		System.out.println("getAuthor() ： " + book.getAuthor());
		System.out.println("getPublisher() ： " + book.getPublisher());
		System.out.println("getPrice() ： " + book.getPrice());
		System.out.println("getIsbncode() ： " + book.getIsbncode());
		System.out.println("getSaledate() ： " + book.getSaleDate());
		System.out.println("getExplanation() ： " + book.getExplanation());
		System.out.println("getImage() ： " + book.getImage());
		System.out.println("getStock() ： " + book.getStock());
	}

}
