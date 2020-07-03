<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${book.categoryName}</title>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
</head>

<style>
body {
	margin : 2em;
}
</style>
<body>

	<div class="list">
		<c:forEach var="book" items="${bookList}">
		<div class="image">
			<img src="${book.coverLargeUrl}">
		</div>
		<div class="content">
			<a class="header">${book.title}</a>
			<div class="meta">
				<span class="date">${book.author} / ${book.publisher}</span>
			</div>
			<!-- <div class="description">
				${book.description}
			</div> -->
		</div>
		<div class="extra content">
			<a>
				<i class="fa fa-star" aria-hidden="true"></i>
				${book.customerReviewRank}
			</a>
		</div>
		</c:forEach>
	</div>
</body>
</html>