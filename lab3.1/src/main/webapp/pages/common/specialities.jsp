<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>specialities</title>
</head>
<body>
<table>
    <c:forEach items="${specialities}" var="speciality">
        <tr>
            <td><c:out value="${speciality.id}"/></td>
            <td> ${speciality.name}</td>
            <td> ${speciality.facultyId}</td>
            <td> ${speciality.places}</td>
            <td> ${speciality.enrolled}</td>
        </tr>
    </c:forEach>
</table>
<nav>
    <ul>
        <c:if test="${currentPage != 1}">
            <li>
                <a href="${pageContext.request.contextPath}/controller?command=specialities_show&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li><a>${i} <span>(current)</span></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/controller?command=specialities_show&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li><a href="${pageContext.request.contextPath}/controller?command=specialities_show&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>
</body>
</html>
