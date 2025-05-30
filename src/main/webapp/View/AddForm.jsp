<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Them sinh vien</title>
</head>
<body>
	<h1>Them Sinh Vien</h1>
	<form action="Sv">
	name: <input type="text" name="name"><br><br>
	birthday: <input type="date" name="birthday"><br><br>
	dtb: <input type="text" name="dtb"><br><br>
	lop hoc: <select name="lop">
		<c:forEach var="lop" items="${ls }">
			<option value="${lop.id }">${lop.name }</option>
		</c:forEach>
	</select> <br><br>
	<button type="submit" name="action" value="add">Them sinh vien</button> <br><br>
	</form>
</body>
</html>