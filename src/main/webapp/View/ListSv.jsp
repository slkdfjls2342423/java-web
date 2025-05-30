<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sach sinh vien</title>
</head>
<body>
	<h1>Danh sach sinh vien</h1>
	<table>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>birthday</th>
		<th>dtb</th>
		<th>lop hoc</th>
	</tr>
	<c:forEach var="sv" items="${ls }">
		<tr>
			<td>${sv.id }</td>
			<td>${sv.name }</td>
			<td>
				<fmt:formatDate value="${sv.birthday }" pattern="dd/MM/yyyy"/>
			</td>
			<td>${sv.dtb }</td>
			<td>${sv.lophoc.name }</td>
			<td><a href="Sv?action=delete&id=${sv.id }">delete</a> </td>
			<td><a href="Sv?action=updateForm&id=${sv.id }">update</a> </td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>