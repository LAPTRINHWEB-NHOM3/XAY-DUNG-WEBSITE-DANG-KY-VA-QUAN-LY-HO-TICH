package DAO;

import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entities.KhaiSinh.DangKyKhaiSinh;
import Entities.NguoiDungA;

public class DAO_NGUOIDUNG extends ConnectDAO {

	public DAO_NGUOIDUNG(String URL, String Username, String Password) {
		super(URL, Username, Password);
		// TODO Auto-generated constructor stub
	}
	
	public NguoiDungA SeacrhNguoiDung(String UserName, String Password) throws SQLException
	{
		    String sql = "SELECT * FROM NGUOIDUNG   " +
		    			 "WHERE 					" +
		    			 "NGUOIDUNG_USERNAME = ?    " +
		    			 "AND COQUAN_ID      = ?	" +
		    			 "AND NGUOIDUNG_PASS = ?		" ; 
	         
	        Connection();
	        
	        System.out.println("CƠ QUAN ID = " + Consts.COQUAN_ID);
	        
	        System.out.println("Hello");
	        PreparedStatement statement = DBConnection.prepareStatement(sql);
	        statement.setString(1, UserName);
	        statement.setInt(2, Consts.Get_COQUAN_ID());
	        statement.setString(3, Password);
	         
	        ResultSet resultSet = statement.executeQuery();
	        
	        NguoiDungA US = new NguoiDungA();
	        
	        while(resultSet.next())
	        {
	        	US.setQuyen(resultSet.getString("NGUOIDUNG_QUYEN"));
	        	US.setID(resultSet.getInt("NGUOIDUNG_ID"));
	        	
	        }
	      
	        return US;
	}
	
	public ResultSet Get_MACANBO(String MaCoQuan) throws SQLException
	 {
		    int ID = Integer.parseInt(MaCoQuan);
		 
	        String sql = "SELECT NGUOIDUNG_ID, NGUOIDUNG_MACANBO FROM NGUOIDUNG WHERE COQUAN_ID = ?";
	         
	        Connection();
	        
	        System.out.println("Hello");
	        PreparedStatement statement = DBConnection.prepareStatement(sql);
	        statement.setInt(1, ID);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	       return resultSet;
	      
	 }
	
	
	public ResultSet loadUser(String MaCoQuan) throws SQLException
	 {
		    int ID = Integer.parseInt(MaCoQuan);
		 
	        String sql = "SELECT * FROM GET_NGUOIDUNG_TABLE(?)";
	         
	        Connection();
	        
	        System.out.println("Hello");
	        PreparedStatement statement = DBConnection.prepareStatement(sql);
	        statement.setInt(1, ID);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	       return resultSet;
	      
	 }
	
	public boolean UPDATE_NGUOIDUNG(NguoiDungA user) throws SQLException
	{

		 Connection();
	 String StrSql = "EXEC PROC_UPDATE_NGUOIDUNG" +
				    "                         ?" + 
			 		"						 ,?" + 
			 		"						 ,?" + 
			 		"						 ,?" + 
			 		"						 ,?" + 
			 		"						 ,?" + 
		 		    "						 ,?" + 
	 		        "			             , ?" ;
	 		
	 
	 PreparedStatement statement = DBConnection.prepareStatement(StrSql);
	 statement.setString(1,user.getMaCanBo()); //Trạng Thái: 1 là trạng thái chưa xử lý	
	 statement.setString(2, user.getHoVaTen());
	 statement.setDate(3,user.getNgaySinh());
	 statement.setString(4,user.getEmail());
	 statement.setString(5, user.getSDT());
	 statement.setInt(6, user.getTrangThai());
	 statement.setString(7, user.getQuyen());
	 statement.setString(8, user.getChucVu());

	 statement.executeUpdate();
	 
	 statement.close();
	 DisConnection();
	 
	return true;
	}
	
	public boolean UPDATE_PASS(NguoiDungA user) throws SQLException
	{

		 Connection();
		 String StrSql = "EXEC PROC_RESET_PASSWORD" +
					    "                         ?" + 
				 		"						 ,?" ;
				 		
		 		
		 
		 PreparedStatement statement = DBConnection.prepareStatement(StrSql);
		 statement.setString(1,user.getMaCanBo()); //Trạng Thái: 1 là trạng thái chưa xử lý	
		 statement.setString(2, user.getPassword());
		 
	
		 statement.executeUpdate();
		 
		 statement.close();
		 DisConnection();
	 
	return true;
	}
	
	 public boolean INSERT_NGUOIDUNG(NguoiDungA user) throws SQLException
	 {
			 Connection();
		 String StrSql = "EXEC PROC_THEM_NGUOIDUNG" +
					    "                         ?" + 
				 		"						 ,?" + 
				 		"						 ,?" + 
				 		"						 ,?" + 
				 		"						 ,?" + 
				 		"						 ,?" + 
			 		    "						 ,?" + 
		 		        "			             , ?" + 
				 		"						 , ?" + 
				 		"						 , ?" + 
				 		"						 , ?" ;
		 		
		 
		 PreparedStatement statement = DBConnection.prepareStatement(StrSql);
		 statement.setString(1,user.getMaCanBo()); //Trạng Thái: 1 là trạng thái chưa xử lý	
		 statement.setString(2, user.getHoVaTen());
		 statement.setDate(3,user.getNgaySinh());
		 statement.setString(4,user.getEmail());
		 statement.setString(5, user.getSDT());
		 statement.setString(6, user.getUsername());
		 statement.setString(7, user.getPassword());
		 statement.setInt(8, user.getTrangThai());
		 statement.setString(9, user.getQuyen());
		 statement.setInt(10, user.getCoQuan_ID());
		 statement.setString(11, user.getChucVu());
	
		 statement.executeUpdate();
		 
		 statement.close();
		 DisConnection();
		 
		return true;
	 }


}
