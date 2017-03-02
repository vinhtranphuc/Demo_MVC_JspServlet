package model.dao;

public class test {
	public static void main(String[] args) {
		SinhVienDAO sinhVienDAO=new SinhVienDAO();
		if(sinhVienDAO.xoaSinhVien("1"))
		{
		System.out.println("Đã xóa");
		}
		else System.out.println("Lỗi cmnr!");
	}
}
