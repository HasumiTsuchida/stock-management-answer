package jp.co.rakus.stockmanagement.common;

/**
 * Memberクラスが作成できているかテストするクラス.
 * 
 * @author rakus
 * 
 */
public class MemberTest {
	public static void main(String[] args) {
		// Memberクラスのオブジェクトを作成
		Member member = new Member(1, "ラクス", "rakus@rakus.co.jp", "rakus");

		// getterメソッドの確認
		System.out.println("id = " + member.getId());
		System.out.println("name = " + member.getName());
		System.out.println("password = " + member.getPassword());
		System.out.println("mailAddress = " + member.getMailAddress());
		System.out.println();

		// setterメソッドの確認
		member.setId(100);
		member.setName("山田");
		member.setPassword("yamada");
		member.setMailAddress("yamada@rakus.co.jp");

		// 正しく値がセットされたか確認
		System.out.println("id = " + member.getId());
		System.out.println("name = " + member.getName());
		System.out.println("password = " + member.getPassword());
		System.out.println("mailAddress = " + member.getMailAddress());
	}
}
