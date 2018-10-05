package jp.co.rakus.stockmanagement.common;

import jp.co.rakus.stockmanagement.login.LoginLogic;



/**
 * ログインをするロジッククラスとDaoクラスが作成できているかテストするクラス.
 * 
 * @author rakus
 * 
 */
public class LoginLogicTest {
	public static void main(String[] args) {
		  // 存在するユーザ
		  Member Member = null;
		  Member = LoginLogic.execute("rakus@rakus.co.jp","rakus");
		  if (Member != null){
			  System.out.println("id = " + Member.getId());
			  System.out.println("name = " + Member.getName());
			  System.out.println("password = " + Member.getPassword());
			  System.out.println("mailAddress = " + Member.getMailAddress());  
		  }else{
			  System.out.println( "メールアドレスかパスワードが違います" );
		  }

		  System.out.println("-----------------------------------");
	    
		  // 存在しないユーザ
		  Member = LoginLogic.execute("unknown@rakus.co.jp","unknown");
		  if (Member != null){
			  System.out.println("id = " + Member.getId());
			  System.out.println("name = " + Member.getName());
			  System.out.println("password = " + Member.getPassword());
			  System.out.println("mailAddress = " + Member.getMailAddress());  
		  }else{
			  System.out.println( "メールアドレスかパスワードが違います" );
		  }
	}
}
