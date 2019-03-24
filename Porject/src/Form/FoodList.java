package Form;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import DBMS.DB_Connection;

public class FoodList extends JPanel{

   /**
	 * 19. 3. 24
	 * Developed by JM
	 */
	private static final long serialVersionUID = 1L;
	
	int num = 0;
	int count = 0;
	int high = 0;
	ImageIcon icon;
	
	//JPanel panel;
	JPanel pn_Sc;   
	JScrollPane sc;   
	JPanel[] pn_List = new JPanel[12];
	JButton[] m_Img = new JButton[12];
	JLabel[] m_Name = new JLabel[12];  
	Menu menu;
	JFrame frame;
	public FoodList(Menu menu, JFrame frame) {
		this.menu = menu;
		this.frame = frame;
	}
	
	public JScrollPane FoodPanel(String foodType)
	{
		
		//panel = new JPanel();
		setLayout(null);
       
		for(int i=0;i<DB_Connection.Menu_List(foodType).size();i++)
		{

			pn_List[i] = new JPanel();
			pn_List[i].setLayout(null);
			pn_List[i].setBounds(num, high, 150, 180);    

			add(pn_List[i]);
         
			m_Img[i] = new JButton();
			m_Img[i].setLayout(null);
			m_Img[i].setBounds(5, 5, 150, 160);
			m_Img[i].setBorder(new EtchedBorder());
			pn_List[i].add(m_Img[i]);

			m_Name[i] = new JLabel(DB_Connection.Menu_List(foodType).get(i).get_MenuName(), SwingConstants.CENTER);
			m_Name[i].setFont(m_Name[i].getFont().deriveFont(10.0f));
			m_Name[i].setBounds(0, 160, 150, 23);
			pn_List[i].add(m_Name[i]);

			icon = new ImageIcon("./이미지/"+m_Name[i].getText()+".jpg");
			icon = new ImageIcon(icon.getImage().getScaledInstance(150, 160, Image.SCALE_DEFAULT));
     
			m_Img[i].setIcon(icon);
			
			num = num + 160;
			count++;
			if(count == 3)
			{
				num = 0;
				high = high + 175;
				count = 0;
			}   
			
			int j = i;
			int price = DB_Connection.Menu_List(foodType).get(i).get_MenuPrice();
			
			m_Img[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				       menu.m_Name.setText(m_Name[j].getText());
				       menu.m_Price.setText(String.valueOf(price));
				       menu.m_Icon.setIcon(m_Img[j].getIcon());
				       menu.m_totalPrice.setText(String.valueOf(menu.Calculate_price(Main.grade, Integer.parseInt(menu.m_Price.getText()), 
								menu.m_Count.getSelectedItem(), menu.m_Size.getSelectedItem())));
				       frame.setSize(1000, 500);
				}
			});
//			
//			m_Img[i].addMouseListener(new MouseAdapter()  
//			{  
//				public void mouseClicked(MouseEvent e)  
//			    {  
//			       // you can open a new frame here as
//			       // i have assumed you have declared "frame" as instance variable
//			       menu.m_Name.setText(m_Name[j].getText());
//			       menu.m_Price.setText(String.valueOf(price));
//			       menu.m_Icon.setIcon(m_Img[j].getIcon());
//			       frame.setSize(1000, 500);
//			       //System.out.println(m_Name[j].getText());
//
//			    }  
//			}); 

		}
		setPreferredSize(new Dimension(this.getWidth(),730));
		sc = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sc.setPreferredSize(new Dimension(492, 400));
		//sc.setViewportView(this);
		return sc;
	}
}
