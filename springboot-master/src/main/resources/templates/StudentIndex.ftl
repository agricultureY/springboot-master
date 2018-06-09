<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生管理</title>
	</head>
	<body>
		<a href="/springboot-master/StudentAdd.html">添加学生</a>
		<table>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>邮箱</th>
				<th>生日</th>
				<th>操作</th>
			</tr>
			<#list students as stu>
				<tr>
					<td>${stu.id}</td>
					<td>${(stu.stuName)!''}</td>
					<td>${(stu.stuAge)!''}</td>
					<td>${(stu.email)!''}</td>
					<td>${(stu.birth)!''}</td>
					<td>
						<a href="/springboot-master/student/getStudentById.do?id=${stu.id}">修改</a>
						<a href="/springboot-master/student/deleteStudent.do?id=${stu.id}">删除</a>
					</td>
				</tr>
			</#list>
		</table>
		<p>number:${number}</p>
		<p>numberOfElements:${numberOfElements}</p>
		<p>size:${size}</p>
		<p>totalElements:${totalElements}</p>
		<p>totalPage:${totalPage}</p>
	</body>
</html>