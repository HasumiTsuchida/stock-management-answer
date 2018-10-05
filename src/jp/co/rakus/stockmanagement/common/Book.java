package jp.co.rakus.stockmanagement.common;

import java.util.Date;

/**
 * 書籍情報を保持するエンティティ.
 * 
 * @author rakus
 * 
 */
public class Book {
	/** id */
	private int id;
	/** 書籍名 */
	private String name;
	/** 著者 */
	private String author;
	/** 出版社 */
	private String publisher;
	/** 価格 */
	private int price;
	/** ISBNコード */
	private String isbncode;
	/** 発売日 */
	private Date saleDate;
	/** 説明 */
	private String explanation;
	/** 画像 */
	private String image;
	/** 在庫数 */
	private int stock;

	/**
	 * 　初期化用コンストラクタ
	 * 
	 * @param id
	 *            商品id
	 * @param name
	 *            名前
	 * @param author
	 *            著者
	 * @param publisher
	 *            出版社
	 * @param price
	 *            価格
	 * @param isbncode
	 *            ISBNコード
	 * @param saleDate
	 *            発売日
	 * @param explanation
	 *            説明文
	 * @param image
	 *            画像
	 * @param stock
	 *            在庫
	 */
	public Book(int id, String name, String author, String publisher,
			int price, String isbncode, Date saleDate, String explanation,
			String image, int stock) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.isbncode = isbncode;
		this.saleDate = saleDate;
		this.explanation = explanation;
		this.image = image;
		this.stock = stock;
	}
	
	/**
	 * 引数無しコンストラクタ.
	 */
	public Book() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIsbncode() {
		return isbncode;
	}

	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
