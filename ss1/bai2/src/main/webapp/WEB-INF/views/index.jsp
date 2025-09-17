<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Dictionary App</title>
</head>
<body>
<h2>Từ điển Anh - Việt</h2>
<form action="${pageContext.request.contextPath}/dictionary" method="post">
  <input type="text" name="eng" placeholder="Nhập từ tiếng Anh">
  <button type="submit">Dịch</button>
</form>

</body>
</html>