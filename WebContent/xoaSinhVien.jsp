<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msv=(String) request.getAttribute("msv");
%>
<form action="XoaSinhVienServlet">
<h4 style="display:inline;">Bạn có muốn xóa Mã Sinh Viên:</h4><input style="display:inline;width: 27px;" name="msv" value="<%=msv%>"/>
<input type="submit" name="submit" value="submit"/>
<input type="button" name="comeback" value="quay lại"/>
</form>
</body>
</html>