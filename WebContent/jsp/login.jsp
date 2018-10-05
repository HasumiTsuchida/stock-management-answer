<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>書籍在庫管理システム</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
  </head>

  <body>
	<div class="container">
		<div class="span8">
			<img src="img/logo.gif" >
			<div class="row">
<!-- --ここから上を編集する必要はありません------------------ -->
				<c:if test="${!empty errorMessage}">
					<ul class="error">
						<li><c:out value="${errorMessage}" /></li>
					</ul>
				</c:if>
			  <form action="<%= request.getContextPath() %>/LoginServlet" method="post">
				<table class="table table-striped">
				  <tr>
				    <th nowrap>
				      メールアドレス
				    </th>
				    <td>
				      <input type="text" name="mailAddress" placeholder="Email">
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      パスワード
				    </th>
				    <td>
				      <input type="password" name="password" placeholder="Password">
				    </td>
				  </tr>
				  <tr>
				  	<td></td>
				    <td>
						<input class="btn" type="submit" value="ログイン">
				    </td>
				  </tr>
				</table>
			  </form>

<a href="<%= request.getContextPath() %>/ViewInsertMemberServlet" id="toInsertMember">メンバー登録はこちらから</a>

<!-- --ここから下を編集する必要はありません------------------ -->
			</div>
		</div>
	</div>
  </body>
</html>
