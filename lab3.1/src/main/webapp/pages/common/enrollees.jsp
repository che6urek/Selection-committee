<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>enrollees</title>
</head>
<body>
<table>
    <c:forEach items="${enrollees}" var="enrolle">
        <tr>
            <td><c:out value="${enrolle.id}"/></td>
            <td> ${enrolle.name}</td>
            <td> ${enrolle.surname}</td>
            <td> ${enrolle.patonymic}</td>
            <td> ${enrolle.gender}</td>
            <td> ${enrolle.specialityid}</td>
            <td> ${enrolle.schoolMark}</td>
            <td> ${enrolle.medicalClearance}</td>
        </tr>
    </c:forEach>
</table>
<nav>
    <ul>
        <c:if test="${currentPage != 1}">
            <li>
                <a href="${pageContext.request.contextPath}/controller?command=enrollees_show&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li><a>${i} <span>(current)</span></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/controller?command=enrollees_show&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li><a href="${pageContext.request.contextPath}/controller?command=enrollees_show&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>
</body>
</html>
