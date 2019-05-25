<%--
  Created by IntelliJ IDEA.
  User: Dmitriy Yegorov
  Date: 25-May-19
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Update Book Info</title>
    <style>
        .error {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h2><spring:message code="lbl.updatePage"/></h2>
<br/>
<form:form method="post" action="/books/updatingBook" modelAttribute="book">
    <table>
        <tr>
            <td><spring:message code="lbl.name" text="Name"/></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.author" text="Author"/></td>
            <td><form:input path="author"/></td>
            <td><form:errors path="author" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.year" text="Year"/></td>
            <td><form:input path="year"/></td>
            <td><form:errors path="year" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.genre" text="Genre"/></td>
            <td><form:input path="genre"/></td>
            <td><form:errors path="genre" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
