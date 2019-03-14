import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Connection {

	public static Connection conn;
	public static Statement stmt;
	
	public static final String DBNAME = "coffee";
	
	public static final String DB_CONN = "jdbc:mysql://localhost/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	public static final String TB_CONN = "jdbc:mysql://localhost/"+DBNAME+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	
	public static final String USER_ID = "root";
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
	
}
