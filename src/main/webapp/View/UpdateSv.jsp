<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sua sinh vien</title>
</head>
<body>
	<h1>Sua Sinh Vien</h1>
	<form action="Sv">
	<input type="hidden" name="id" value="${sv.id }">
	name: <input type="text" name="name" value="${sv.name }"><br><br>
	birthday: <input type="date" name="birthday" value="<fmt:formatDate value="${sv.birthday }" pattern="yyyy-MM-dd"/>"><br><br>
		
	dtb: <input type="text" name="dtb" value="${sv.dtb }"><br><br>
	lop hoc: <select name="lop">
		<c:forEach var="lop" items="${ls }">
			<option value="${lop.id }" ${lop.id == sv.lophoc.id?"selected":"" }>${lop.name }</option>
		</c:forEach>
	</select> <br><br>
	<button type="submit" name="action" value="update">Sua sinh vien</button> <br><br>
	</form>
</body>
</html>