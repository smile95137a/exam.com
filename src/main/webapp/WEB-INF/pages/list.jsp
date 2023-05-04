<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<H1>公佈欄</H1>
	<%-- 	<a href="<c:url value='/create' />">Add New Article</a> --%>
	<form action="<c:url value='/create' />" method="GET">
		<input type="submit" value="Add New Article" />
	</form>
	<table>
		<tr>
			<th>標題</th>
			<th>發佈日期</th>
			<th>截止日期</th>
		</tr>
		<c:forEach items="${resultList}" var="result">
			<c:url var="update" value="/update">
					<c:param name="boardId" value="${result.boardId}" />
				</c:url>
				<c:url var="delete" value="/delete">
					<c:param name="boardId" value="${result.boardId}" />
				</c:url>
				<c:url var="content" value="/content">
					<c:param name="boardId" value="${result.boardId}" />
				</c:url>
			<tr>
				<td><a href="${content}"><c:out value="${result.title}"></c:out></a></td>
				<td><c:out value="${result.startDate}"></c:out></td>
				<td><c:out value="${result.endDate}"></c:out></td>
				<td><a href="${update}">Update</a> | <a href="${delete}">Delete</a></td> 
			</tr>
				
		</c:forEach>
	</table>
</body>
</html>