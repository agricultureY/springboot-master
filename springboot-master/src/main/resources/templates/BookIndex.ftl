<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图书管理</title>
	</head>
	<body>
		<a href="/springboot-master/BookAdd.html">添加图书</a>
		<table>
			<tr>
				<th>编号</th>
				<th>书名</th>
				<th>作者</th>
				<th>操作</th>
			</tr>
			<#list bookList as book>
				<tr>
					<td>${book.id}</td>
					<td>${book.bookName}</td>
					<td>${book.bookAuthor}</td>
					<td>
						<a href="/springboot-master/book/preUpdateBook/${book.id}">修改</a>
						<a href="/springboot-master/book/deleteBook.do?id=${book.id}">删除</a>
					</td>
				</tr>
			</#list>
		</table>
	</body>
</html>