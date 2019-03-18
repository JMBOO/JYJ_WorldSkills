package Form;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DBMS.DB_Connection;

public class Main extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int point;
	public static String name;
	public static String grade;
	
	JPanel panel = new JPanel();

	JLabel lb_Title = new JLabel("STARBOX");
	JLabel lb_ID = new JLabel("ID : ");
	JLabel lb_PW = new JLabel("PW :");
	
	public static JTextField tx_ID = new JTextField();
	public static JPasswordField ps_PS = new JPasswordField();
	
	JButton bt_Login = new JButton("로그인");
	JButton bt_Insert = new JButton("회워가입");
	JButton bt_Close = new JButton("종료");

	String adminID = "admin";
	
	public Main()
	{
		setTitle("로그인");
		setVisible(true);
		setSize(405, 230);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel.setLayout(null);

		makeComponent();

		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void makeComponent()
	{

		lb_Title.setFont(new Font("Dialog.bold", 1, 25));
		lb_Title.setBounds(130, 30, 130, 30);
		panel.add(lb_Title);


		lb_ID.setBounds(65, 65, 40, 25);
		panel.add(lb_ID);

		tx_ID.setBounds(95, 65, 170, 25);
		panel.add(tx_ID);

		lb_PW.setBounds(55, 95, 40, 25);
		panel.add(lb_PW);

		ps_PS.setBounds(95, 95, 170, 25);
		panel.add(ps_PS);

		bt_Login.setBounds(275, 60, 88, 75);
		panel.add(bt_Login);

		bt_Insert.setBounds(95, 135, 90, 25);
		panel.add(bt_Insert);

		bt_Close.setBounds(190, 135, 70, 25);
		panel.add(bt_Close);
		
		bt_Insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Insert();
			}
		});
		
		bt_Login.addActionListener(new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tx_ID.getText().equals("") || ps_PS.getText().equals(""))
				{

					JOptionPane.showMessageDialog(null, "빈칸이 존재합니다.","메시지",JOptionPane.ERROR_MESSAGE);
				}else if(tx_ID.getText() == "admin" && ps_PS.getText() == "1234")
				{
					new Admin();
				}else if(DB_Connection.searchmember(tx_ID.getText(), ps_PS.getText())[0] == "NotFound")
				{
					JOptionPane.showMessageDialog(null, "회원정보가 틀립니다.다시입력해주세요.","Message",JOptionPane.ERROR_MESSAGE);

					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렸습니다.","Message",JOptionPane.ERROR_MESSAGE);

				}else
				{
					JOptionPane.showMessageDialog(null, DB_Connection.searchmember(tx_ID.getText(), ps_PS.getText())[0] + "회원님 환영합니다.","Message",JOptionPane.INFORMATION_MESSAGE);

					name = DB_Connection.searchmember(tx_ID.getText(), ps_PS.getText())[0];
					grade = DB_Connection.searchmember(tx_ID.getText(), ps_PS.getText())[1];
					point = Integer.parseInt(DB_Connection.searchmember(tx_ID.getText(), ps_PS.getText())[2]);
					Menu mn = new Menu();
					mn.setVisible(true);
					mn.setLocationRelativeTo(null);

				}
			}
		});
		
		bt_Close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args)
	{
		new Main();
	}
	
}

