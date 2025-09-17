<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Currency converter</h1>
<br/>
<form action="${pageContext.request.contextPath}/convert">
    <p>Nhập số tiền USD: </p>
    <input type="number" name="usd">

    <button type="submit">Tính</button>
</form>

</body>
</html>