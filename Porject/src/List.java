import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.table.*;
import javax.swing.border.*;

class List extends JFrame
{
	JPanel panel = new JPanel();

	JLabel lb_Name = new JLabel("이현승회원님 구매내역");

	Vector lst_Payment_vector;
	JList lst_Payment;
	JScrollPane lst_Payment_scroll;
	JLabel lb_pay = new JLabel("총 결제금액");
	JTextField tx_pay = new JTextField();
	JButton bt_Close = new JButton("닫기");

	public List()
	{
		setTitle("구매내역");
		setVisible(true);
		setBounds(170, 20, 680, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panel.setLayout(null);

		makeComponent();

		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void makeComponent()
	{
		lb_Name.setFont(new Font("Dialog.plain", 0, 24));
		lb_Name.setBounds(210, 10, 255, 38);
		panel.add(lb_Name);

		lst_Payment_vector = new Vector();
		lst_Payment_vector.addElement("jList1");
		lst_Payment = new JList(lst_Payment_vector);
		lst_Payment_scroll = new JScrollPane(lst_Payment);
		lst_Payment_scroll.setBounds(0, 50, 670, 200);
		panel.add(lst_Payment_scroll);

		lb_pay.setFont(new Font("Dialog.plain", 0, 20));
		lb_pay.setBounds(110, 260, 110, 25);
		panel.add(lb_pay);

		tx_pay.setBounds(220, 260, 260, 30);
		panel.add(tx_pay);


		bt_Close.setBounds(485, 260, 60, 30);
		panel.add(bt_Close);
	}
	
	public static void main(String[] args)
	{
		new List();
	}
}
