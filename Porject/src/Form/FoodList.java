package Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import DBMS.DB_Connection;

//import DB.DB_Connection;

public class FoodList {
   
   int num = 10;
   int count = 0;
   int high = 10;
   
   JPanel panel;
   JPanel pn_Sc;
   
    JScrollPane sc;
   
   JPanel[] pn_List = new JPanel[12];
   JLabel[] pn_Movie = new JLabel[12];
   
   JLabel[] tx_Age = new JLabel[12];
   
   JLabel[] lb_MovieName = new JLabel[12];
   JLabel[] lb_Grade = new JLabel[12];
   JLabel[] lb_Summary = new JLabel[12];
   JLabel[] lb_Slash = new JLabel[12];
   JLabel[] lb_MovieTime = new JLabel[12];
   
   JButton[] bt_Ticketing = new JButton[12];
   JButton[] bt_Review = new JButton[12];
   
   String MovieName[] = new String[12];
   
   ImageIcon icon;
   
   public JScrollPane FoodPanel(String foodType)
   {
    sc = new JScrollPane();
    
    JPanel panel = new JPanel();
    panel.setLayout(null);
       
    for(int i=0;i<DB_Connection.Menu_List(foodType).size();i++)
      {

         pn_List[i] = new JPanel();
         pn_List[i].setLayout(null);
         pn_List[i].setBounds(num, high, 150, 163);         
         panel.add(pn_List[i]);
         
         pn_Movie[i] = new JLabel();
         pn_Movie[i].setLayout(null);
         pn_Movie[i].setBounds(5, 5, 150, 163);
         pn_Movie[i].setBorder(new EtchedBorder());
         pn_List[i].add(pn_Movie[i]);

         lb_MovieName[i] = new JLabel(DB_Connection.Menu_List(foodType).get(i).get_MenuName());
         lb_MovieName[i].setBounds(10, 218, 150, 23);
         pn_List[i].add(lb_MovieName[i]);
         MovieName[i] = lb_MovieName[i].getText();

         icon = new ImageIcon("./이미지/"+lb_MovieName[i].getText()+".jpg");
         icon = new ImageIcon(icon.getImage().getScaledInstance(150, 163, Image.SCALE_DEFAULT));
         
         pn_Movie[i].setIcon(icon);

         lb_Summary[i] = new JLabel("개요 : " + DB_Connection.Menu_List(foodType).get(i).get_MenuPrice());
         lb_Summary[i].setBounds(150, 100, 100, 23);
         pn_List[i].add(lb_Summary[i]);

         num = num + 210;
         count++;
         if(count == 3)
         {
            num = 10;
            high = high + 223;
            count = 0;
         }             
      }
        panel.setPreferredSize(new Dimension(panel.getWidth(),830));
        sc.setPreferredSize(new Dimension(660, 830));
        sc.setViewportView(panel);
        
        return sc;
       
   }
}
