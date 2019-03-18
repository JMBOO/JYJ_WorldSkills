
public class DB_Query {
	
	protected String DB_NAME = "coffee";
	protected String USER_ID = "root";
	protected String USER_PW = "1234";
	protected String USER_TABLE = "user";
	protected String ORDERLIST_TABLE = "orderlist";
	protected String MENU_TABLE = "menu";
	protected String SHOPPING_TABLE = "shopping";
	
	protected static String DROP_DB = "DROP DATABASE IF EXISTS ";
	protected static String CREATE_DB = "CREATE DATABASE ";
	
	public static final String DROP_USER = "DROP USER IF EXISTS ";
	public static final String CREATE_UESR = "CREATE USER ";

	
	public static String CREATE_TABLE_MENU = "CREATE TABLE menu(m_no int primary key not null auto_increment comment '분류',"
			+ "m_group varchar(10) comment '분류',"
			+ "m_name varchar(30) comment '메뉴명',"
			+ "m_price int comment '가격')";
	
	public static String CREATE_TABLE_ORDERLIST = "CREATE TABLE orderlist(o_no int primary key not null auto_increment comment '고유번호',"
			+ "o_date Date comment '구매일자',"
			+ "u_no int comment '회원번호 외래키',"
			+ "m_no int comment '메뉴번호 외래키',"
			+ "o_group varchar(10) comment '분류',"
			+ "o_size varchar(1) comment '사이즈',"
			+ "o_price int comment '가격',"
			+ "o_count int comment '수량',"
			+ "o_amount int comment '합계',"
			+ "foreign key (u_no) references user (u_no),"
			+ "foreign key (m_no) references menu (m_no))";
	
	public static String CREATE_TABLE_USER = "CREATE TABLE user(u_no int primary key not null auto_increment comment '고유번호',"
			+ "u_id varchar(20) comment '회원번호',"
			+ "u_pw varchar(4) comment '비밀번호',"
			+ "u_name varchar(5) comment '이름',"
			+ "u_bd varchar(14) comment '생년월일',"
			+ "u_point int comment '포인트',"
			+ "u_grade varchar(10) comment '회원등급')";
	
	public static String CREATE_TABLE_SHOPPING = "CREATE TABLE shopping(s_no int primary key not null auto_increment comment '고유번호',"
			+ "m_no int comment '메뉴번호 외래키',"
			+ "s_price int comment '가격',"
			+ "s_count int comment '개수',"
			+ "s_size varchar(1) comment '사이즈',"
			+ "s_amount int comment '합계',"
			+ "foreign key (m_no) references menu (m_no))";
}
