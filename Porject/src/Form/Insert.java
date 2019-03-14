package Form;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

class Insert extends JFrame
{
	public static Connection conn;
	public static Statement stmt;
	
	JPanel panel;

	JLabel lb_Name = new JLabel("�̸�");
	JLabel lb_ID = new JLabel("���̵�");
	JLabel lb_PW = new JLabel("��й�ȣ");
	JLabel lb_Barth = new JLabel("�������");
	JLabel lb_Year = new JLabel("��");
	JLabel lb_Month = new JLabel("��");
	JLabel lb_Day = new JLabel("��");
	
	JComboBox cox_Year = new JComboBox();
	JComboBox cox_month = new JComboBox();
	JComboBox cox_Day = new JComboBox();

	JTextField tx_Name = new JTextField();
	JTextField tx_ID = new JTextField();
	JTextField tx_PW = new JTextField();
	
	JButton bt_Insert = new JButton("���ԿϷ�");
	JButton bt_Close = new JButton("���");

	public Insert()
	{

		setTitle("ȸ������");
		setVisible(true);
		setSize(365,220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);

		panel = new JPanel();
		panel.setLayout(null);

		makeComponent();

		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void makeComponent()
	{
		lb_Name.setBounds(40, 10, 40, 25);
		panel.add(lb_Name);

		lb_ID.setBounds(30, 40, 40, 25);
		panel.add(lb_ID);

		lb_PW.setBounds(20, 70, 60, 25);
		panel.add(lb_PW);

		lb_Barth.setBounds(40, 100, 60, 25);
		panel.add(lb_Barth);

		cox_Year.setBounds(95, 100, 60, 25);
		panel.add(cox_Year);
		cox_Year.addItem("2019");

		lb_Year.setBounds(160, 100, 20, 25);
		panel.add(lb_Year);

		cox_month.setBounds(180, 100, 50, 25);
		panel.add(cox_month);
		cox_month.addItem("03");

		lb_Month.setBounds(235, 100, 25, 25);
		panel.add(lb_Month);

		cox_Day.setBounds(255, 100, 45, 25);
		panel.add(cox_Day);
		cox_Day.addItem("14");
		
		lb_Day.setBounds(305, 100, 25, 25);
		panel.add(lb_Day);

		tx_Name.setBounds(80, 10, 250, 25);
		panel.add(tx_Name);

		tx_ID.setBounds(80, 40, 250, 25);
		panel.add(tx_ID);

		tx_PW.setBounds(80, 70, 250, 25);
		panel.add(tx_PW);

		bt_Insert.setBounds(95, 140, 95, 25);
		panel.add(bt_Insert);

		bt_Close.setBounds(200, 140, 60, 25);
		panel.add(bt_Close);
		
		bt_Insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost/coffee?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","1234");
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("Select * from user");
					int index = 0;
					
					while(rs.next())
					{
						index = rs.getInt(1) + 1;
					}
					
					String name = tx_Name.getText();
					String id = tx_ID.getText();
					String pw = tx_PW.getText();
					String bd = cox_Year.getSelectedItem().toString() + "-" + cox_month.getSelectedItem().toString() + "-" + cox_Day.getSelectedItem().toString();
					int point = 0;
					String grade = "�Ϲ�";
					
					stmt.executeUpdate("insert into user(u_no, u_id, u_pw, u_name, u_bd, u_point, u_grade) values('"+index+"','"+id+"','"+pw+"','"+name+"','"+bd+"','"+point+"','"+grade+"')");
					JOptionPane.showMessageDialog(null, "����� �Ϸ�Ǿ����ϴ�.");
					
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
					// TODO: handle exception
				}
			}
		});
	}

}
