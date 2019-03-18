package Form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Menu extends JFrame
{
	JPanel panel;

	JLabel lb_Title = new JLabel();
	JButton bt_PayList = new JButton("구매내역");
	JButton bt_Shopping = new JButton("장바구니");
	JButton bt_Best = new JButton("인기상품 Top5");
	JButton bt_Logout = new JButton("Logout");
	JButton bt_Juice = new JButton("음료");
	JButton bt_Food = new JButton("푸드");
	JButton bt_Product = new JButton("상품");

	public Menu()
	{
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		setTitle("새 프래임");
		setBounds(163, 40, 726, 550);
		setDefaultCloseOperation(1);

		panel = new JPanel();
		panel.setLayout(null);

		makeComponent();

		getContentPane().add(panel, BorderLayout.CENTER);
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

		bt_Juice.setBounds(0, 60, 60, 50);
		panel.add(bt_Juice);

		bt_Food.setBounds(0, 110, 60, 50);
		panel.add(bt_Food);

		bt_Product.setBounds(0, 160, 60, 50);
		panel.add(bt_Product);

		bt_Logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubㅁㄴㅇ
				dispose();
				Main.tx_ID.setText("");
				Main.ps_PS.setText("");
			}
		});
		
	}
}
