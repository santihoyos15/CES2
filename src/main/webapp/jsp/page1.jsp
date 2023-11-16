<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>
<body>
<h2>Page 1</h2>
  <c:if test="${not empty mensaje}">
    <h2><c:out escapeXml="false" value="${mensaje}"/></h2>
  </c:if>
  <form name="form2" action="Servlet1" method="POST">
    <input type="hidden" name="formulario" value="page1" />
    <input type="submit" value="Volver" name="submit1" />
  </form>
</body>
</html>

<%-- TODO continue on clase-6-2 15:48 --%>