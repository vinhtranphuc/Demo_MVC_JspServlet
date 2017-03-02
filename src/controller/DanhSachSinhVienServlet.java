package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Khoa;
import model.bean.SinhVien;
import model.bo.KhoaBO;
import model.bo.SinhVienBO;

/**
 * Servlet implementation class DanhSachSinhVienServlet
 */
public class DanhSachSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DanhSachSinhVienServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Đã zô DanhSachSinhVienServlet");
	ArrayList<SinhVien> listSinhVien=new ArrayList<SinhVien>();
	
	KhoaBO khoaBO=new KhoaBO();
	ArrayList<Khoa> listKhoa=new ArrayList<Khoa>();
	listKhoa=khoaBO.getListKhoa();
	request.setAttribute("listKhoa",listKhoa);
	
	SinhVienBO sinhVienBO=new SinhVienBO();
	String maKhoa=request.getParameter("maKhoa");
	System.out.println("DSSVSV when submit - Ma khoa:"+maKhoa);
	
	if(maKhoa==null||maKhoa.length()==0)
		listSinhVien=sinhVienBO.getListSinhVien();
	else{
		listSinhVien=sinhVienBO.getListSinhVien(maKhoa);
	}
	
	request.setAttribute("listSinhVien",listSinhVien);
	
	RequestDispatcher rd=request.getRequestDispatcher("danhSachSinhVien.jsp");
	rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}
}
