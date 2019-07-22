<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="transfer" method="post">
		转账账户：<input type="text" name ="accOutAccNo"/><br/>
		密码：<input type="password" name ="accOutPassword"/><br/>
		金额：<input type="text" name ="accOutBalance"/><br/>
		收款账号：<input type="text" name ="accInName"/><br/>
		收款姓名：<input type="text" name ="accInAccount"/><br/>
		<input type="submit" value="转账"/>
	</form>
</body>
</html>