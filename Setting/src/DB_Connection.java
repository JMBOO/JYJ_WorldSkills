import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.sql.Date;

public class DB_Connection {
	public static Connection conn = null;
	public static Statement stmt = null;
	
	//유저 생성
	public int createUser(String userID, String userPW)
	{
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",userID, userPW);
			stmt = conn.createStatement();
			
			stmt.executeUpdate(DB_Query.DROP_USER + "'user'@'localhost'");
			stmt.executeUpdate("create user 'user'@'localhost' identified by '1234';");
					
			conn.close();
			stmt.close();
			
			return 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 1;
			// TODO: handle exception
		}
	}
	
	//db생성
	public int createDB(String DBNAME, String userID, String userPW)
	{
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",userID, userPW);
			stmt = conn.createStatement();
			
			stmt.executeUpdate(DB_Query.DROP_DB + DBNAME);
			stmt.executeUpdate(DB_Query.CREATE_DB + DBNAME);
			
			//유저 권한주기 - 조회, 삽입, 삭제, 업데이트
			stmt.executeUpdate("grant select, insert, delete, update on coffee.* to 'user'@'localhost';");
			
			conn.close();
			stmt.close();
			
			return 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 1;
			// TODO: handle exception
		}
	}
	
	//테이블 생성
	public int createTable(String DBNAME, String userID, String userPW)
	{	
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+DBNAME+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",userID, userPW);
			stmt = conn.createStatement();
			
			stmt.executeUpdate(DB_Query.CREATE_TABLE_MENU);
			stmt.executeUpdate(DB_Query.CREATE_TABLE_USER);
			stmt.executeUpdate(DB_Query.CREATE_TABLE_ORDERLIST);
			stmt.executeUpdate(DB_Query.CREATE_TABLE_SHOPPING);
			
			importTXT("menu");
			importTXT("user");
			importTXT("orderlist");
			
			conn.close();
			stmt.close();
			
			return 0;
		} catch (Exception e) {
		System.out.println(e.getMessage());
		return 1;
			// TODO: handle exception
		}	
	}
	
	//텍스트 파일 읽어오
	private void importTXT(String Name)
	{
		String[] menu_array = new String[4];
		String[] orderlist_array = new String[9];
		String[] user_array = new String[7];
		String[] shopping_array = new String[6];
		
		try{
            //파일 객체 생성
            File file = new File("./DataFiles/"+Name+".txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            int i = 0;
            while((line = bufReader.readLine()) != null){
            	if(i == 0)
            	{
            		i++;
            	}else {
            		if(Name == "menu")
            		{
            			if(line != null)
            			{
            				menu_array = line.split("\t");
            			}
            			stmt.executeUpdate("INSERT INTO menu(m_no, m_group, m_name, m_price)" + 
            					"VALUES("+Integer.parseInt(menu_array[0])+",'"+menu_array[1]+"','"+menu_array[2]+"',"+Integer.parseInt(menu_array[3])+");");
            		}else if(Name == "orderlist")
            		{		
            			if(line != null)
            			{
            				orderlist_array = line.split("\t");
            			}
            			Date date = Date.valueOf(orderlist_array[1]);
            			stmt.executeUpdate("INSERT INTO orderlist(o_no, o_date, u_no, m_no, o_group, o_size, o_price, o_count, o_amount)" + 
            					"VALUES("+Integer.parseInt(orderlist_array[0])+",'"+date+"',"+Integer.parseInt(orderlist_array[2])+","+Integer.parseInt(orderlist_array[3])+
            					",'"+orderlist_array[4]+"','"+orderlist_array[5]+"',"+Integer.parseInt(orderlist_array[6])+","+Integer.parseInt(orderlist_array[7])+","+Integer.parseInt(orderlist_array[8])+");");
            		}else if(Name == "user")
            		{
            			if(line != null)
            			{
            				user_array = line.split("\t");
            			}
            			stmt.executeUpdate("INSERT INTO user(u_no, u_id, u_pw, u_name, u_bd, u_point, u_grade)" + 
            					"VALUES("+Integer.parseInt(user_array[0])+",'"+user_array[1]+"','"+user_array[2]+"','"+user_array[3]+
            					"','"+user_array[4]+"',"+Integer.parseInt(user_array[5].replace(" ", ""))+",'"+user_array[6]+"');");
            		}	
            	}
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}		
	}
}