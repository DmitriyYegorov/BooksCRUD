<%--
  Created by IntelliJ IDEA.
  User: Dmitriy Yegorov
  Date: 29-May-19
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show All Books from Database</title>
    <style>
        .error {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h2><spring:message code="lbl.searchPage"/></h2>
<table>
    <tr>
        <th>Name</th>
        <th>Author</th>
        <th>Year</th>
        <th>Genre</th>
    </tr>
    <c:forEach items="${booksList}" var="tempBook">
        <c:url var="updateLink" value="/books/updateForm">
            <c:param name="bookId" value="${tempBook.id}"/>
        </c:url>
        <c:url var="deleteLink" value="/books/deleteBook">
            <c:param name="bookId" value="${tempBook.id}"/>
        </c:url>
        <tr>
            <td>${tempBook.name}</td>
            <td>${tempBook.author}</td>
            <td>${tempBook.year}</td>
            <td>${tempBook.genre}</td>
            <td><a href="${updateLink}">Update</a></td>
            <td><a href="${deleteLink}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
