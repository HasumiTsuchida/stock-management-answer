<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>メンバー登録画面</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
  </head>

  <body>
	<div class="container">
		<h3>メンバー登録画面</h3>
		<div class="span8">
			<div class="row">
<!-- --ここから上を編集する必要はありません------------------ -->
			<ul class="error">
				<c:forEach var="error" items="${errorList}">
					<li><c:out value="${error}" /></li>
				</c:forEach>
			</ul>
			  <form action="<%= request.getContextPath() %>/InsertMemberServlet" method="post">
				<table class="table table-striped">
				  <tr>
				    <th nowrap>
				      氏名
				    </th>
				    <td>
				      <input type="text" name="name" placeholder="Name" value="<c:out value="${name}"/>">
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      メールアドレス
				    </th>
				    <td>
				      <input type="text" name="mailAddress" placeholder="Email" value="<c:out value="${mailAddress}"/>">
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      パスワード
				    </th>
				    <td>
				      <input type="password" name="password" placeholder="Password" value="<c:out value="${password}"/>">
				    </td>
				  </tr>
				  <tr>
				  	<td></td>
				    <td>
						<input class="btn" type="submit" value="登録">
				    </td>
				  </tr>
				</table>
			  </form>


<!-- --ここから下を編集する必要はありません------------------ -->
			</div>
		</div>
	</div>
  </body>
</html>