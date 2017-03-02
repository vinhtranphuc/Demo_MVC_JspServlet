package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.SinhVienBO;

/**
 * Servlet implementation class XoaSinhVienServlet
 */
public class XoaSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSinhVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	String msv=request.getParameter("msv");
	request.setAttribute("msv", msv);
	
	System.out.println("XoaSinhVienServlet msv:"+msv);
	SinhVienBO sinhVienBO=new SinhVienBO();
	if("submit".equals(request.getParameter("submit")))
	{
		if(sinhVienBO.xoaSinhVien(msv))
			response.sendRedirect("DanhSachSinhVienServlet");
		else
			response.sendRedirect("Error.jsp");
	}
	else
	{
	RequestDispatcher rd=request.getRequestDispatcher("xoaSinhVien.jsp");
	rd.forward(request,response);
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
	}
}
