package Form;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Admin extends JFrame{
	JPanel panel = new JPanel();
	
	JButton bt_menu_insert = new JButton("메뉴 등록");
	JButton bt_menu = new JButton("메뉴 관리");
	JButton bt_Logout = new JButton("로그아웃");
	
	public Admin()
	{
		setSize(200,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		
		makeCompoment();
		
		getContentPane().add(panel);
	}
	
	public void makeCompoment()
	{
		
	}
}
