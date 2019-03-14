import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.table.*;
import javax.swing.border.*;

class Main extends JFrame
{
	JPanel panel = new JPanel();

	JLabel lb_Title = new JLabel("STARBOX");
	JLabel lb_ID = new JLabel("ID : ");
	JLabel lb_PW = new JLabel("PW :");
	
	JTextField tx_ID = new JTextField();
	JPasswordField ps_PS = new JPasswordField();
	
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
				if(DB_Connection.searchmember(tx_ID.getText(), ps_PS.getText())[0] == "NotFound")
				{
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�.","Message",JOptionPane.ERROR_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null, DB_Connection.searchmember(tx_ID.getText(), ps_PS.getText())[0] + "ȸ���� ȯ���մϴ�.","Message",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	
	public static void main(String[] args)
	{
		new Main();
	}
	
}

