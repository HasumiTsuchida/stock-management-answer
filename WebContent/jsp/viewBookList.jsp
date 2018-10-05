<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>書籍一覧</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
  </head>

  <body>
	<div class="container">
		<a href="<%=request.getContextPath() %>/LogoutServlet">ログアウト</a>
		<h3>書籍一覧</h3>
		<div class="span8">
			<div class="row">
<!-- --ここから上を編集する必要はありません(ログアウト以外)------------------ -->


				<table class="table table-striped">
				  <tr>
				    <th nowrap>書籍</th>
				    <th nowrap>在庫数</th>
				  </tr>
				  <c:forEach var="book" items="${bookList}">
				  <tr>
				    <td>
				      <a href="<%= request.getContextPath() %>/ViewBookDetailServlet?id=${book.id}"><c:out value="${book.name}" /></a>
				    </td>
				    <td><c:out value="${book.stock}"></c:out></td>
				  </tr>
				  </c:forEach>
				</table>


<!-- --ここから下を編集する必要はありません------------------ -->
			</div>
		</div>
	</div>
  </body>
</html>
