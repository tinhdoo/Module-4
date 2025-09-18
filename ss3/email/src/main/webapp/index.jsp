<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Settings</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 40px;
    }
    h1 {
      font-size: 24px;
      margin-bottom: 20px;
    }
    form {
      width: 400px;
    }
    .form-group {
      margin-bottom: 15px;
    }
    label {
      display: inline-block;
      width: 120px;
      font-weight: bold;
    }
    select, input[type="text"], textarea {
      width: 230px;
      padding: 5px;
      font-size: 14px;
    }
    input[type="checkbox"] {
      margin-right: 8px;
    }
    textarea {
      height: 80px;
      resize: none;
    }
    .buttons {
      margin-top: 20px;
    }
    button {
      padding: 6px 16px;
      font-size: 14px;
      border-radius: 4px;
      border: 1px solid #ccc;
      cursor: pointer;
      margin-right: 10px;
    }
    .btn-update {
      background-color: #2196f3;
      color: #fff;
      border: none;
    }
    .btn-cancel {
      background-color: #fff;
    }
    .btn-cancel:hover {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
<h1>Settings</h1>
<form action="/settings" method="post">
  <div class="form-group">
    <label for="lang">Languages:</label>
    <select id="lang" name="language">
      <option value="vie">Tiếng Việt</option>
      <option value="eng" selected>English</option>
      <option value="jpn">Japanese</option>
    </select>
  </div>

  <div class="form-group">
    <label for="pageSize">Page Size:</label>
    Show
    <select id="pageSize" name="pageSize">
      <option>100</option>
      <option>50</option>
      <option>25</option>
      <option>15</option>
      <option>10</option>
      <option>5</option>
    </select> emails per page
  </div>

  <div class="form-group">
    <label>Spams filter:</label>
    <input type="checkbox" name="spamFilter"> Enable spams filter
  </div>

  <div class="form-group">
    <label for="signature">Signature:</label>
    <textarea id="signature" name="signature"></textarea>
  </div>

  <div class="buttons">
    <button type="submit" class="btn-update">Update</button>
    <button type="reset" class="btn-cancel">Cancel</button>
  </div>
</form>
</body>
</html>
