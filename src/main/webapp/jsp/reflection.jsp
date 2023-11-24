<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <script type="text/javascript" src="js/script1.js"></script>
</head>
<body>
<h1>Reflection in action</h1>

<c:if test="${not empty mensaje}">
  <span style="color: green"><c:out escapeXml="false" value="${mensaje}" /></span>
</c:if>

<br />
<br />

<form action="Servlet1" method="post">
  <input type="hidden" name="formulario" value="index" />
  Volver: <input type="submit" value="OK">
</form>

</body>
</html>
