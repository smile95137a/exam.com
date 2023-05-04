<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdnjs.cloudflare.com/ajax/libs/tinymce/4.7.6/tinymce.min.js"></script>
<script>
	tinyMCE.init({
		// 初始化參數設定[註1]
		selector : "textarea", // 目標物件
		auto_focus : "editor1", // 聚焦物件
		language : "zh_TW", // 語系(CDN沒有中文，需要下載原始source才有)
		theme : "modern", // 模板風格
		plugins : "advlist autolink link image lists charmap print preview", // 套件設定: 進階清單、自動連結、連結、上傳圖片、清單、特殊字元表、列印、預覽
		mobile : { // 行動裝置設定
			theme : "mobile", // 模板風格
			plugins : [ "autosave", "lists", "autolink" ], // 套件設定: 自動儲存、清單、自動連結
			toolbar : [ "undo", "bold", "italic", "styleselect" ]
		// 工具列設定: 復原、粗體、斜體、樣式表
		}
	});
</script>
</head>
<body>
	<form:form method="POST" modelAttribute="board">
		<table>
			<tr>
				<td><label for="title">標題:</label></td>
				<td><input path="title" id="title" value="${board.title}"/></td>
			</tr>
			<tr>
				<td><label for="startDate">發佈日期:</label></td>
				<td><input type="date" path="startDate" id="startDate" value="${board.startDate}" /></td>
			</tr>
			<tr>
				<td><label for="endDate">截止日期:</label></td>
				<td><input type="date" path="endDate" id="endDate"  value="${board.endDate}"/></td>
			</tr>
			<tr>
				<td><label for="author">公佈者:</label></td>
				<td><input path="author" id="author"  value="${board.author}"/></td>
			</tr>
			<tr>
				<td><label for="context">公布內容:</label></td>
				<td><textarea path="context" id="context"  value="${board.context}"></textarea></td>
			</tr>
		</table>
		<button type="submit">確定修改</button>
	</form:form>
		<form action="<c:url value='/list' />" method="GET">
		<input type="submit" value="Go back to list" />
	</form>
</body>
</html>