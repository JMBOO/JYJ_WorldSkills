import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args)
	{
		DB_Connection db = new DB_Connection();
		DB_Query dq = new DB_Query();
		
		int FLAG_1 = db.createUser(dq.ROOT_ID, dq.ROOT_PW);
		int FLAG_2 = db.createDB(dq.DB_NAME, dq.ROOT_ID, dq.ROOT_PW);
		int FLAG_3 = db.createTable(dq.DB_NAME, dq.ROOT_ID, dq.ROOT_PW);
		
		if(FLAG_1 != 1 & FLAG_2 != 1 & FLAG_3 != 1)
		{
			JOptionPane.showMessageDialog(null, "DB Setting 완료!!");
		}else {
			JOptionPane.showMessageDialog(null, "에러 발생\n유저생성 오류코드 :" + FLAG_1 + "\nDB생성 오류코드 :" + FLAG_2 + "\n테이블생성 오류코드 :" + FLAG_3);
		}
	}
}
