package Form;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Menu extends JFrame
{
	JPanel panel;

	private final JLabel lb_Title = new JLabel();
	private final JButton bt_PayList = new JButton("구매내역");
	private final JButton bt_Shopping = new JButton("장바구니");
	private final JButton bt_Best = new JButton("인기상품 Top5");
	private final JButton bt_Logout = new JButton("Logout");
	private final JButton bt_Juice = new JButton("음료");
	private final JButton bt_Food = new JButton("푸드");
	private final JButton bt_Product = new JButton("상품");
	private final JPanel panel_1;
	
	private final JLabel label = new JLabel("주문메뉴 : ");
	private final JLabel label_1 = new JLabel("가격 : ");
	private final JLabel label_2 = new JLabel("수량 : ");
	private final JLabel label_3 = new JLabel("사이즈 : ");
	private final JLabel label_4 = new JLabel("총금액 : ");
	
	FoodList fl;
	public JTextField m_Name;
	public JTextField m_Price;
	public JTextField m_totalPrice;
	public JLabel m_Icon = new JLabel();
	public JComboBox m_Count;
	public JComboBox m_Size;
	public Menu()
	{
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		setTitle("새 프래임");
		setBounds(163, 40, 578, 500);
		setDefaultCloseOperation(1);

		panel = new JPanel();
		panel.setLayout(null);

		makeComponent();
		fl = new FoodList(this, this);
		getContentPane().add(panel, BorderLayout.CENTER);

		panel_1 = new JPanel();
		panel_1.setBounds(60, 60, 500, 410);
		panel_1.add(fl.FoodPanel("음료"));
		panel.add(panel_1);
		
		
		m_Icon.setBounds(599, 160, 125, 125);
		panel.add(m_Icon);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(736, 160, 61, 16);
		
		panel.add(label);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(736, 188, 61, 16);
		
		panel.add(label_1);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(736, 214, 61, 16);
		
		panel.add(label_2);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(736, 242, 61, 16);
		
		panel.add(label_3);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(736, 270, 61, 16);
		
		panel.add(label_4);
		
		m_Name = new JTextField();
		m_Name.setEditable(false);
		m_Name.setBounds(809, 155, 130, 26);
		panel.add(m_Name);
		m_Name.setColumns(10);
		
		m_Price = new JTextField();
		m_Price.setEditable(false);
		m_Price.setBounds(809, 183, 130, 26);
		panel.add(m_Price);
		m_Price.setColumns(10);
		
		Integer [] array_mCount = {1,2,3,4,5,6,7,8,9,10};
		m_Count = new JComboBox<Integer>(array_mCount);
		m_Count.setBounds(809, 210, 130, 27);
		panel.add(m_Count);
	
		m_Count.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
			       m_totalPrice.setText(String.valueOf(Calculate_price(Main.grade, Integer.parseInt(m_Price.getText()), 
							m_Count.getSelectedItem(), m_Size.getSelectedItem())));
		    }
		});
		
		String[] array_mSize = {"M","L"};
		m_Size = new JComboBox<String>(array_mSize);
		m_Size.setBounds(809, 238, 130, 27);
		panel.add(m_Size);
		
		m_Size.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
			       m_totalPrice.setText(String.valueOf(Calculate_price(Main.grade, Integer.parseInt(m_Price.getText()), 
							m_Count.getSelectedItem(), m_Size.getSelectedItem())));
		    }
		});
		
		m_totalPrice = new JTextField();
		m_totalPrice.setEditable(false);
		m_totalPrice.setBounds(809, 265, 130, 26);

		panel.add(m_totalPrice);
		m_totalPrice.setColumns(10);
		
		JButton button = new JButton("장바구니에 담기");
		button.setBounds(646, 329, 117, 29);
		panel.add(button);
		
		JButton button_1 = new JButton("구매하기");
		button_1.setBounds(775, 329, 117, 29);
		panel.add(button_1);
	}
	
	

	public void makeComponent()
	{
		lb_Title.setBounds(0, 0, 500, 25);
		lb_Title.setText("회원명 : " + Main.name + " / 회원등급 : " + Main.grade + " / 총 누적 포인트 : " + Main.point);
		panel.add(lb_Title);
		bt_PayList.setBounds(5, 30, 90, 25);
		panel.add(bt_PayList);
		
		bt_Shopping.setBounds(100, 30, 90, 25);
		panel.add(bt_Shopping);

		bt_Best.setBounds(195, 30, 120, 25);
		panel.add(bt_Best);

		bt_Logout.setBounds(320, 30, 80, 25);
		panel.add(bt_Logout);
		bt_Juice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fl = new FoodList(Menu.this, Menu.this);
				panel_1.removeAll();
				panel_1.revalidate();
				panel_1.repaint();
				setSize(578, 500);
				panel_1.add(fl.FoodPanel("음료"));
				panel.add(panel_1);
			}
		});

		bt_Juice.setBounds(0, 60, 60, 50);
		panel.add(bt_Juice);
		bt_Food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fl = new FoodList(Menu.this, Menu.this);
				panel_1.removeAll();
				panel_1.revalidate();
				panel_1.repaint();
				setSize(578, 500);
				panel_1.add(fl.FoodPanel("푸드"));
				panel.add(panel_1);
			}
		});

		bt_Food.setBounds(0, 110, 60, 50);
		panel.add(bt_Food);
		bt_Product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fl = new FoodList(Menu.this, Menu.this);
				setSize(578, 500);
				panel_1.removeAll();
				panel_1.revalidate();
				panel_1.repaint();
				panel_1.add(fl.FoodPanel("상품"));
				panel.add(panel_1);
			}
		});

		bt_Product.setBounds(0, 160, 60, 50);
		panel.add(bt_Product);

		bt_Logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				Main.tx_ID.setText("");
				Main.ps_PS.setText("");
			}
		});
		
	}
	
	
	public int Calculate_price(String member_Grade, int Price, Object Count, Object Size)
	{
		int totalPrice = 0;
		if(Size == "L")
		{
			totalPrice = (Price+1000) * Integer.parseInt(Count.toString());
			if(member_Grade.equals("Bronze"))
			{				
				 totalPrice -= (totalPrice * 0.03);
			}
			else if(member_Grade.equals("Silver"))
			{
				totalPrice -= (totalPrice * 0.05);
			}
			else if(member_Grade.equals("Gold"))
			{
				totalPrice -= (totalPrice * 0.03);
			}
		}else {
			totalPrice = (Price) * Integer.parseInt(Count.toString());
			if(member_Grade.equals("Bronze"))
			{	
				 totalPrice -= (totalPrice * 0.03);	
			}
			else if(member_Grade.equals("Silver"))
			{
				totalPrice -= (totalPrice * 0.05);
			}
			else if(member_Grade.equals("Gold"))
			{
				totalPrice -= (totalPrice * 0.03);
			}
		}
		
		return totalPrice;
	}

}
