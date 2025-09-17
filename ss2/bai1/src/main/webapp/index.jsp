<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="${pageContext.request.contextPath}/save" method="post">
  <input type="checkbox" name="condiments" value="lettuce"> Lettuce
  <input type="checkbox" name="condiments" value="tomato"> Tomato
  <input type="checkbox" name="condiments" value="mustard"> Mustard
  <input type="checkbox" name="condiments" value="sprouts"> Sprouts
  <button type="submit">Save</button>
</form>
</body>
</html>