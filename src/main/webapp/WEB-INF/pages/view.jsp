<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${contexts}" var="context">
    <table>
        <tbody>
            <tr>
                <h2><c:out value="${context.title}"></c:out></h2>
            </tr>
            <tr>
                <h5><c:out value="${context.startDate}"></c:out></h5>
            </tr>
            <tr>
                <h5><c:out value="${context.endDate}"></c:out></h5>
            </tr>
            <tr>
                <h5><c:out value="${context.author}"></c:out></h5>
            </tr>
            <tr>
                <h5><c:out value="${context.context}"></c:out></h5>
            </tr>
        </tbody>
    </table>
</c:forEach>
</body>
</html>