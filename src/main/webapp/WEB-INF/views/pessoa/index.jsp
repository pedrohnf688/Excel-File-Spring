
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      
      <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/pessoa/importExcel">
      Excel file <input type="file" name="files">
      </br>
      
      <input type="submit" value="Import">
      
      </form>
      
</body>
</html>