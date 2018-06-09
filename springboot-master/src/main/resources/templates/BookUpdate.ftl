<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
</head>
<body>
	<form action="/springboot-master/book/updateBook.do" method="post">
		<input type="hidden" name="id" value="${book.id}"/>
		名称：<input type="text" name="bookName" value="${book.bookName}"/><br/>
		作者：<input type="text" name="bookAuthor" value="${book.bookAuthor}"/><br/>
		<button type="submit">提交</button>
	</form>
</body>
</html>