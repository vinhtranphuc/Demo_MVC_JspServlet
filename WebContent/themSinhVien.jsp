<%@page import="model.bean.Khoa"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ThemSinhVienServlet" method="post">
	<h4> Sửa Sinh Viên</h4>
	<table>
		<tr>
			<td>Mã Sinh Viên:</td>
			<td><input type="text" name="msv" value="<%=request.getAttribute("msv")%>"></input> </td>
		</tr>
		<tr>
			<td>Tên Sinh Viên: </td>
			<td><input type="text" name="tensv" value=""></input> </td>
		</tr>
		<tr>
			<td>Giới tính </td>
			<td>
				<input type="radio" value="1" name="gioitinh" checked="true">Nam
				<input type="radio" value="0" name="gioitinh">Nữ
			 </td>
		</tr>
		<tr>
		<td>Khoa</td>
			<td> 
			<select name="khoa">
			<% ArrayList<Khoa> listKhoa=(ArrayList<Khoa>) request.getAttribute("listKhoa");
				for(Khoa khoa: listKhoa){
			%>
			<option value="<%=khoa.getMaKhoa()%>"><%=khoa.getTenKhoa()%></option>
			<%}; %>
			</select>
			</td>
		</tr>
		<tr>
			<td  colspan="2"> 
				<center>
				<input type="submit" value="submit" name="submit" style=" width: 58px;">					
				<input type="button" value="Quay lại">
				</center>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
