<%@page import="model.bean.SinhVien"%>
<%@page import="model.bean.Khoa"%>
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
<h1>Danh Sách Sinh Viên</h1>
<form action="DanhSachSinhVienServlet" method="get"> 
	Chọn khoa:
	 <select style="width: 165px" name="maKhoa">
		<option value="1">Chọn Khoa </option>
		<% ArrayList<Khoa> listKhoa= (ArrayList<Khoa>) request.getAttribute("listKhoa");
			for(Khoa khoa:listKhoa){
		%>
		<option value="<%=khoa.getMaKhoa()%>"> <%=khoa.getTenKhoa()%> </option>
		<%}%>
	</select>
	<input type="submit" value="Xem"></input>
	<div>
	<a href="ThemSinhVienServlet" 
	style="display: block;
	margin-top: 10px;
    display: block;
    width: 78px;
    height: 16px;
    background: #c4cdd0;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    margin-bottom: -6px;
    font-weight: bold;">Thêm</a>
	</div>
</form>
<form>
	<table border="1"
	style=" border-spacing: 10px;
	    margin-top: 20px;"
	>
	<thead>
		<tr>
			<th>Mã SV</th>
			<th>Họ tên</th>
			<th>Giới tính</th>
			<th>Khoa</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<% ArrayList<SinhVien> listSinhVien=(ArrayList<SinhVien>) request.getAttribute("listSinhVien");
	for(SinhVien sv:listSinhVien){
	%>
		<tr>
			<td><%=sv.getMasv()%></td>
			<td><%=sv.getHoTen()%></td>
			<td><%=sv.getGioiTinh()%></td>
			<td><%=sv.getTenKhoa()%></td>
 	<td>
         <a href="SuaSinhVienServlet?msv=<%=sv.getMasv()%>">Sửa</a>
         <a href="XoaSinhVienServlet?msv=<%=sv.getMasv()%>" style="margin-left: 30px;">Xóa</a>
   </td>
		</tr>
		  <%} %>
	</tbody>
	</table>
</form>
</body>
</html>
