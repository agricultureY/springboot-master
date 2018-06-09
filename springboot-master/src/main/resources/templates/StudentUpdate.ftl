<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改学生</title>
<script type="text/javascript" src="/springboot-master/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function formSubmit(){
		var _param={id:$("#id").val(),
				stuName:$("#stuName").val(),
				stuAge:$("#stuAge").val(),
				email:$("#email").val(),
				birth:$("#birth").val()};
		$.post("saveStudent.do",_param,
            function(result){
				var res = eval('(' + result + ')');
				if(res.flag){
					//$.post("student/findPageStudent.do");
					window.location.href='findPageStudent.do';
				}else{					
	                alert(res.msg);
				}
            }
        );
	}
</script>
</head>
<body>
	<input type="hidden" id="id" name="id" value="${student.id}"/>
	姓名：<input type="text" id="stuName" name="stuName" value="${(student.stuName)!''}"/><br/>
	年龄：<input type="text" id="stuAge" name="stuAge" value="${(student.stuAge)!''}"/><br/>
	邮箱：<input type="text" id="email" name="email" value="${(student.email)!''}"/><br/>
	生日：<input type="date" id="birth" name="birth" value="${(student.birth)!''}"/><br/>
	<button type="button" onclick="formSubmit()">提交</button>
</body>
</html>