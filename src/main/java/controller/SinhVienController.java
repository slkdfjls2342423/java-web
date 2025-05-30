package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LopHocDao;
import dao.SinhVienDao;
import entity.LopHoc;
import entity.SinhVien;

/**
 * Servlet implementation class SinhVien
 */
@WebServlet("/Sv")
public class SinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SinhVienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		switch (action) {
		case "list":
			List(request, response);
			break;
		case "addForm":
			AddForm(request, response);
			break;
		case "add":
			Add(request, response);
			break;
		case "delete":
			Delete(request, response);
			break;
		case "updateForm":
			UpdateForm(request, response);
			break;
		case "update":
			Update(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void List(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		java.util.List<SinhVien> ls=new SinhVienDao().getAll();
		request.setAttribute("ls", ls);
		request.getRequestDispatcher("View/ListSv.jsp").forward(request, response);
	}
	private void AddForm(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		java.util.List<LopHoc>ls=new LopHocDao().getAll();
		request.setAttribute("ls", ls);
		request.getRequestDispatcher("View/AddForm.jsp").forward(request, response);
	}
	private void Add(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		SinhVien sv=new SinhVien();
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			sv.setBirthday(sdf.parse(request.getParameter("birthday")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		sv.setName(request.getParameter("name"));
		sv.setDtb(Float.parseFloat(request.getParameter("dtb")));
		sv.setLophoc(new LopHocDao().get(Integer.parseInt(request.getParameter("lop"))));
		new SinhVienDao().add(sv);
		response.sendRedirect("Sv?action=list");
	}
	private void Delete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		new SinhVienDao().delete(id);
		response.sendRedirect("Sv?action=list");
	}
	private void UpdateForm(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		SinhVien sv=new SinhVienDao().get(id);
		request.setAttribute("sv", sv);
		java.util.List<LopHoc>ls=new LopHocDao().getAll();
		request.setAttribute("ls", ls);
		request.getRequestDispatcher("View/UpdateSv.jsp").forward(request, response);
	}
	private void Update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		SinhVien sv=new SinhVienDao().get(id);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			sv.setBirthday(sdf.parse(request.getParameter("birthday")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		sv.setName(request.getParameter("name"));
		sv.setDtb(Float.parseFloat(request.getParameter("dtb")));
		sv.setLophoc(new LopHocDao().get(Integer.parseInt(request.getParameter("lop"))));
		new SinhVienDao().update(sv);
		response.sendRedirect("Sv?action=list");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
