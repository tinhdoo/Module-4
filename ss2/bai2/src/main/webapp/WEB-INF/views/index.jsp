<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<form action="${pageContext.request.contextPath}/calculator">
    <input type="number" name="numA" value="${param.numA}">
    <input type="number" name="numB" value="${param.numB}">
    <br><br>
    <button name="calculator" value="add">Addition(+)</button>
    <button name="calculator" value="sub">Subtraction(-)</button>
    <button name="calculator" value="mul">Multiplication(x)</button>
    <button name="calculator" value="div">Division(/)</button>
</form>

<c:if test="${not empty result}">
    <p>Result of ${calculator} : ${result}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

</body>
</html>