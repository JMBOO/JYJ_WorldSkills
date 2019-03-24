package Form;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import DBMS.DB_Connection;

class Insert extends JFrame
{
	/**
	 * 수정중
	 */
	private static final long serialVersionUID = 1L;
	public static Connection conn;
	public static Statement stmt;
	
	JPanel panel;

	JLabel lb_Name = new JLabel("이름");
	JLabel lb_ID = new JLabel("아이디");
	JLabel lb_PW = new JLabel("비밀번호");
	JLabel lb_Barth = new JLabel("생년월일");
	JLabel lb_Year = new JLabel("년");
	JLabel lb_Month = new JLabel("월");
	JLabel lb_Day = new JLabel("일");
	
	/*JComboBox cox_Year = new JComboBox();
	JComboBox cox_month = new JComboBox();
	JComboBox cox_Day = new JComboBox();*/

	
	JComboBox<String> jcomtodayyear,jcomtodaymonth,jcomtodayday;
	ArrayList<String> cox_Year;
	ArrayList<String> cox_Month;
	ArrayList<String> cox_Day;
	
	//현재 날짜를 가져오기 위한 클래스
	Calendar calendar = Calendar.getInstance();
	
	JTextField tx_Name = new JTextField();
	JTextField tx_ID = new JTextField();
	JTextField tx_PW = new JTextField();
	
	JButton bt_Insert = new JButton("가입완료");
	JButton bt_Close = new JButton("취소");

	public Insert()
	{

		setTitle("회원가입");
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
		
		int toYear = calendar.get(Calendar.YEAR);
		int toMonth = calendar.get(Calendar.MONTH)+1;
		int toDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		cox_Year = new ArrayList<String>();
		cox_Month = new ArrayList<String>();
		cox_Day = new ArrayList<String>();
		
		//년
		for(int i = toYear; i>=toYear-40; i--)
		{
			cox_Year.add(String.valueOf(i));
		}
		
		//월
		for(int i = 1; i<= toMonth; i++)
		{
			cox_Month.add(addZeroString(i));
		}
		
		//일
		for(int i = 1; i<= toDay; i++)
		{
			cox_Day.add(addZeroString(i));
		}
		
		lb_Name.setBounds(40, 10, 40, 25);
		panel.add(lb_Name);

		lb_ID.setBounds(30, 40, 40, 25);
		panel.add(lb_ID);

		lb_PW.setBounds(20, 70, 60, 25);
		panel.add(lb_PW);

		lb_Barth.setBounds(20, 100, 60, 25);
		panel.add(lb_Barth);
		
		jcomtodayyear = new JComboBox<String>(cox_Year.toArray(new String[cox_Year.size()]));
		jcomtodayyear.setBounds(80, 100, 85, 25);
		jcomtodayyear.setSelectedItem(String.valueOf(toYear));
		panel.add(jcomtodayyear);
		
		//cox_Year.addItem("2019");

		lb_Year.setBounds(165, 100, 20, 25);
		panel.add(lb_Year);

		jcomtodaymonth = new JComboBox<String>(cox_Month.toArray(new String[cox_Month.size()]));
		jcomtodaymonth.setBounds(180, 100, 70, 25);
		//String mcom = toMonth >= 10?String.valueOf(toMonth):"0" + toMonth;
		jcomtodaymonth.setSelectedItem(toMonth);
		panel.add(jcomtodaymonth);
//		cox_month.addItem("03");

		lb_Month.setBounds(245, 100, 25, 25);
		panel.add(lb_Month);

		jcomtodayday = new JComboBox<String>(cox_Day.toArray(new String[cox_Day.size()]));		
		jcomtodayday.setBounds(255, 100, 70, 25);
		//String dcom = toDay >= 10?String.valueOf(toDay):"0" + toDay;
		panel.add(jcomtodayday);
		jcomtodayday.setSelectedItem(toDay);
//		cox_Day.addItem("14");
		
		lb_Day.setBounds(325, 100, 25, 25);
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
				if(tx_Name.getText().equals("") || tx_ID.getText().equals("") || tx_PW.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "누락된 항목이 있습니다.", "메시지", JOptionPane.ERROR_MESSAGE);
				}else
				{
					//String bd = cox_Year.getSelectedItem().toString() + "-" + cox_month.getSelectedItem().toString() + "-" + cox_Day.getSelectedItem().toString();
					
					if(DB_Connection.searchUser(tx_ID.getText()).equals("0"))
					{
						DB_Connection.userInsert(tx_ID.getText(), tx_PW.getText(), tx_Name.getText(), "222");
					}	
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
	
	//한자리 날짜 앞에 0붙이기
	private String addZeroString(int i)
	{
		String Value = Integer.toString(i);
		if(Value.length() == 1)
		{
			Value = "0" + Value;
		}
		
		return Value;
	}

}
