<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>
<body>
<h1>Pagina 2</h1>

<c:if test="${not empty datos}">
  <p>
    <c:out escapeXml="false" value="${datos}"/>
  </p>
</c:if>

<br />
<br />

<c:if test="${not empty datos2}">
  <p>
    <c:forEach var="cliente" items="${datos2}">
      <c:out escapeXml="false" value="${cliente}"/>
    </c:forEach>
  </p>
</c:if>

</body>
</html>
