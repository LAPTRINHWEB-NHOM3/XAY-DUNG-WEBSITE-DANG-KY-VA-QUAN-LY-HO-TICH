package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Consts;
import DAO.DAO_DK_KHAISINH;
import DAO.DAO_NGUOIDUNG;
import DAO.DAO_PHUONG;
import DAO.DAO_QUAN;
import DAO.DAO_QUYEN;
import DAO.DAO_THANHPHO;
import Entities.NguoiDungA;

/**
 * Servlet implementation class ThemNhanVienServlet
 */
@WebServlet("/ThemNhanVien.php")
public class ThemNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ThemNhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		NguoiDungA user = new NguoiDungA();
		DAO_QUAN QUAN  = new DAO_QUAN(Consts.ServerUrl, Consts.UserName, Consts.Pass);
		DAO_PHUONG PHUONG = new DAO_PHUONG(Consts.ServerUrl, Consts.UserName, Consts.Pass);
		DAO_THANHPHO TP = new DAO_THANHPHO(Consts.ServerUrl, Consts.UserName, Consts.Pass);
	    DAO_QUYEN Quyen  = new DAO_QUYEN(Consts.ServerUrl,Consts.UserName, Consts.Pass );
	    
		user.setHoVaTen(request.getParameter("user_HoVaten"));
		try {
			user.setNgaySinh(request.getParameter("user_NgaySinh"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setMaCanBo(request.getParameter("user_MACANBO"));
		user.setEmail(request.getParameter("user_Email"));
		user.setSDT(request.getParameter("user_SDT"));
		System.out.println(request.getParameter("user_SDT"));
		user.setPassword(user.getMaCanBo());
		user.setUsername(user.getMaCanBo());
		
		user.setCoQuan_ID(1);
		
		String TranhThai = request.getParameter("user_TrangThai");
		System.out.println("Trang thái: " + TranhThai);
		if(TranhThai==null)
			user.setTrangThai("0");
		else
			user.setTrangThai("1");
		
		DAO_NGUOIDUNG USER_DAO = new DAO_NGUOIDUNG(Consts.ServerUrl, Consts.UserName, Consts.Pass);
		
		
	
			user.setQuyen(request.getParameter("user_Quyen"));
		
		try {
			USER_DAO.INSERT_NGUOIDUNG(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("Thanh cong them nhan vien");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CONTENT/jsp/AdminNguoiDung.jsp");
	    response.sendRedirect("admin");
		return;
	}

}
