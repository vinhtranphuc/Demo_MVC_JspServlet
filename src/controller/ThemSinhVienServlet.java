package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Khoa;
import model.bo.KhoaBO;
import model.bo.SinhVienBO;

/**
 * Servlet implementation class ThemSinhVienServlet
 */
public class ThemSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSinhVienServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
	//lấy và gởi mã sinh viên tự tăng cho client
	SinhVienBO sinhVienBO=new SinhVienBO();
	String msv=sinhVienBO.getMaSvTuTang();
	request.setAttribute("msv",msv);
	
	// nếu bấm nút thêm
	if("submit".equals(request.getParameter("submit")))
	{
		String tensv=request.getParameter("tensv");
		System.out.println("ThemSVSVL - tensv: "+tensv);
		String gioitinh=request.getParameter("gioitinh");
		System.out.println("ThemSVSVL - gioitinh: "+gioitinh);
		String makhoa=request.getParameter("khoa");
		System.out.println("ThemSVSVL - khoa: "+makhoa);
		
		if(sinhVienBO.themSinhVien(msv,tensv, gioitinh, makhoa))
		{
			response.sendRedirect("DanhSachSinhVienServlet");
		}
		else
		{
			response.sendRedirect("Error.jsp");
		}
	}
	else
	{
	//lấy và gửi ds khoa cho client
	ArrayList<Khoa> listKhoa=new ArrayList<Khoa>();
	KhoaBO khoaBO=new KhoaBO();
	listKhoa=khoaBO.getListKhoa();
	request.setAttribute("listKhoa",listKhoa);
	
	// chuyển trang
	RequestDispatcher rd=request.getRequestDispatcher("themSinhVien.jsp");
	rd.forward(request,response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
