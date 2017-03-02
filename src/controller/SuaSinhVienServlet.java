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
 * Servlet implementation class SuaSinhVienServlet
 */
public class SuaSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaSinhVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("Đã zô SuaSinhVienServlet");
		
		//lấy listKhoa
		ArrayList<Khoa> listKhoa=new ArrayList<Khoa>();
		KhoaBO khoaBO=new KhoaBO();
		listKhoa=khoaBO.getListKhoa();
		
		SinhVienBO sinhVienBO=new SinhVienBO();
		
		//lấy mã sv
		String msv=request.getParameter("msv");
		System.out.println("SuaSinhVienServlet - msv:"+msv);
		
		//gởi đi listKhoa
		request.setAttribute("listKhoa",listKhoa);
		
		//nêu bấm nút sửa
		if("submit".equals(request.getParameter("submit")))
		{
		System.out.println("SuaSinhVienServlet: da bam nut'");
		
		String tensv=request.getParameter("tensv");
		System.out.println(tensv);
		String gioitinh=request.getParameter("gioitinh");
		System.out.println(gioitinh);
		String makhoa=request.getParameter("khoa");
		System.out.println(makhoa);
	
			if(sinhVienBO.suaSinhVien(msv,tensv,gioitinh,makhoa)){
			response.sendRedirect("DanhSachSinhVienServlet");
			}
			else
			{
			response.sendRedirect("Error.jsp");
			}
		}
		else
		{
		SinhVien sinhVien=sinhVienBO.getThongTinSinhVien(msv);
		request.setAttribute("sinhVien",sinhVien);
		
		// chuyển trang tới suaSinhVien.jsp
		RequestDispatcher rd=request.getRequestDispatcher("suaSinhVien.jsp");
		rd.forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
	}

}
