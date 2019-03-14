import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args)
	{
		DB_Connection db = new DB_Connection();
		DB_Query dq = new DB_Query();
		
		int FLAG_1 = db.createDB(dq.DB_NAME, dq.USER_ID, dq.USER_PW);
		int FLAG_2 = db.createTable(dq.DB_NAME, dq.USER_ID, dq.USER_PW);
		
		if(FLAG_1 != 1 && FLAG_2 != 1)
		{
			JOptionPane.showMessageDialog(null, "DB Setting 완료!!");
		}else {
			JOptionPane.showMessageDialog(null, "에러 발생\nDB생성 오류코드 :" + FLAG_2 + "\n테이블생성 오류코드 :" + FLAG_2);
		}
	}
}
