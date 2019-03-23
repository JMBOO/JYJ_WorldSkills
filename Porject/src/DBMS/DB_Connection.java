package DBMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Array.PayArray;

public class DB_Connection {

	public static Connection conn;
	public static Statement stmt;
	
	public static final String DBNAME = "coffee";
	
	public static final String DB_CONN = "jdbc:mysql://localhost/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	public static final String TB_CONN = "jdbc:mysql://localhost/"+DBNAME+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	
	public static final String USER_ID = "user";
	public static final String USER_PW = "1234";
	
	public static String[] searchmember(String id, String pw)
	{
		String[] returnvalue = new String[3];
		
		try {
			conn = DriverManager.getConnection(TB_CONN,USER_ID,USER_PW);
			stmt = conn.createStatement();
			
			String Select_Qurey = "SELECT u_name, u_grade, u_point FROM user WHERE u_id = '"+id+"' AND u_pw = '"+pw+"'";
			
			PreparedStatement psmt = conn.prepareStatement(Select_Qurey);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				returnvalue[0] = rs.getString("u_name");
				returnvalue[1] = rs.getString("u_grade");
				int point = rs.getInt("u_point");
				returnvalue[2] = Integer.toString(point);
			}
			
			if(returnvalue[0] == null)
			{
				returnvalue[0] = "NotFound";
			}
			
			conn.close();
			stmt.close();
			
			return returnvalue;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
			// TODO: handle exception
		}
	}
	
	public static ArrayList<PayArray> Pay_List(int no)
	{
		ArrayList<PayArray> PayListArray = new ArrayList<PayArray>();
		PayArray ply;
		
		try {
			conn = DriverManager.getConnection(TB_CONN, USER_ID, USER_PW);
			stmt = conn.createStatement();

			String Select_Qurey = "Select orderlist.o_date, menu.m_name, orderlist.o_price, orderlist.o_size, orderlist.o_count, orderlist.o_amount from menu join orderlist on menu.m_no = orderlist.m_no where orderlist.u_no = "+no;
			
			PreparedStatement psmt = conn.prepareStatement(Select_Qurey);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				ply = new PayArray(
						rs.getDate("o_date"),
						rs.getString("m_name"),
						rs.getInt("o_price"),
						rs.getString("o_size"),
						rs.getInt("o_count"),
						rs.getInt("o_amount")
						);
				PayListArray.add(ply);
			}
			
			return PayListArray;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
			// TODO: handle exception
		}
		
	}
	
	public static void userInsert(String id, String pw, String name, String bd)
	{
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/coffee?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",USER_ID,USER_PW);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from user");
			int index = 0;
			
			while(rs.next())
			{
				index = rs.getInt(1) + 1;
			}
			int point = 0;
			String grade = "일반";
			
			stmt.executeUpdate("insert into user(u_no, u_id, u_pw, u_name, u_bd, u_point, u_grade) values('"+index+"','"+id+"','"+pw+"','"+name+"','"+bd+"','"+point+"','"+grade+"')");
			JOptionPane.showMessageDialog(null, "등록이 완료되었습니다.");
			
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			// TODO: handle exception
		}
	}
	
	public static String searchUser(String id)
	{
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/coffee?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",USER_ID,USER_PW);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from user where u_id = '" + id + "'");
			String returnValue = "0";
			while(rs.next())
			{
				returnValue = rs.getString(2);
			}
			//System.out.println(rs);
			
			return returnValue;
		}catch(Exception e2)
		{
			System.out.println(e2.getMessage());
			return "1";
		}
	}
	
//	public static String searchUser(String id)
//	{
//		try {
//			String returnvalue = null;
//			
//			conn = DriverManager.getConnection(TB_CONN,USER_ID,USER_PW);
//			stmt = conn.createStatement();
//			
//			ResultSet rs = stmt.executeQuery("Select u_name from user where u_id = '"+id+"'");
//			
//			if(rs.getString(0) == null)
//			{
//				
//			}
//			
//			return returnvalue;
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//			// TODO: handle exception
//		}
//	}
	
}
