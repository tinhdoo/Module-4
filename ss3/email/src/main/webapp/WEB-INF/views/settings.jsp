<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Settings</title>
</head>
<body>
<h2>Settings</h2>

<form action="${pageContext.request.contextPath}/settings" method="post">
  <label>Languages:</label>
  <select name="language">
    <c:forEach var="lang" items="${languages}">
      <option value="${lang}" <c:if test="${settings.language == lang}">selected</c:if>>
          ${lang}
      </option>
    </c:forEach>
  </select>
  <br><br>

  <label>Page Size:</label>
  Show
  <select name="pageSize">
    <c:forEach var="ps" items="${pageSizes}">
      <option value="${ps}" <c:if test="${settings.pageSize == ps}">selected</c:if>>
          ${ps}
      </option>
    </c:forEach>
  </select>
  emails per page
  <br><br>

  <label>Spams filter:</label>
  <input type="checkbox" name="spamFilter" value="true"
         <c:if test="${settings.spamFilter}">checked</c:if>>
  Enable spams filter
  <br><br>

  <label>Signature:</label><br>
  <textarea rows="5" cols="40" name="signature">${settings.signature}</textarea>
  <br><br>

  <button type="submit">Update</button>
  <button type="reset">Cancel</button>
</form>

<c:if test="${not empty message}">
  <p style="color:green">${message}</p>
</c:if>

</body>
</html>
