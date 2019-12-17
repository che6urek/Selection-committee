<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Selection committee</title>
</head>
<body class="page">
    <a href="${pageContext.request.contextPath}/controller?command=faculties_show&recordsPerPage=2&currentPage=1">faculties</a>
    <a href="${pageContext.request.contextPath}/controller?command=specialities_show&recordsPerPage=2&currentPage=1">specialities</a>
    <a href="${pageContext.request.contextPath}/controller?command=students_show&recordsPerPage=2&currentPage=1">students</a>
    <a href="${pageContext.request.contextPath}/controller?command=enrollees_show&recordsPerPage=2&currentPage=1">enrollees</a>
    <br>
</body>
</html>
