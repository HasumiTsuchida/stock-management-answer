<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>書籍在庫数変更画面</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
  </head>

  <body>
	<div class="container">
		<a href="<%=request.getContextPath() %>/LogoutServlet">ログアウト</a>
		<h3>書籍在庫数変更画面</h3>
		<div class="span8">
			<div class="row">
<!-- --ここから上を編集する必要はありません(ログアウト以外)------------------ -->

				<ul class="error">
					<c:forEach var="error" items="${errorList}">
						<li><c:out value="${error}" /></li>
					</c:forEach>
				</ul>
				<table class="table table-striped">
				  <tr>
				    <th nowrap>
				      書籍名
				    </th>
				    <td>
				      <c:out value="${book.name}"/>
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      著者
				    </th>
				    <td>
				      <c:out value="${book.author}"/>
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      出版社
				    </th>
				    <td>
				      <c:out value="${book.publisher}"/>
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      価格
				    </th>
				    <td>
				      <c:out value="${book.price}"/>円
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      ISBNコード
				    </th>
				    <td>
				      <c:out value="${book.isbncode}"/>
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      発売日
				    </th>
				    <td>
				      <c:out value="${book.saleDate}"/>
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      説明
				    </th>
				    <td>
				      <c:out value="${book.explanation}"/>
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      画像
				    </th>
				    <td>
				      <img src="img/<c:out value="${book.image}"/>"/>
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      在庫数
				    </th>
				    <td>
						<form action="<%=request.getContextPath() %>/UpdateStockServlet" method="post">
							<input type="text" name="stock"  value="<c:out value="${book.stock}"/>">
							<input type="hidden" name="id" value="<c:out value="${book.id}"/>">
							<input class="btn" type="submit" value="更新">
						</form>
				    </td>
				  </tr>
				</table>


<!-- --ここから下を編集する必要はありません------------------ -->
			</div>
		</div>
	</div>
  </body>
</html>
