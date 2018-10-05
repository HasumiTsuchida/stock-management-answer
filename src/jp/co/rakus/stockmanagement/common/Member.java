package jp.co.rakus.stockmanagement.common;

/**
 * メンバー情報を保持するエンティティ.
 * 
 * @author rakus
 * 
 */
public class Member {
	/** id(主キー) */
	private int id;
	/** 名前 */
	private String name;
	/** メールアドレス */
	private String mailAddress;
	/** パスワード */
	private String password;

	/**
	 * 初期化用コンストラクタ
	 * 
	 * @param id
	 *            id(主キー)
	 * @param name
	 *            名前
	 * @param mailAddress
	 *            メールアドレス
	 * @param password
	 *            パスワード
	 */
	public Member(int id, String name, String mailAddress, String password) {
		this.id = id;
		this.name = name;
		this.mailAddress = mailAddress;
		this.password = password;
	}

	/**
	 * 引数無しのコンストラクタ.
	 */
	public Member() {
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

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
