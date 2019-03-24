package Form;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class TestForm extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestForm()
	{
		JFrame frame = new JFrame();
	    frame.getContentPane().setLayout(new BorderLayout());

	    MyTableModel model = new MyTableModel();

	    JTable table = new JTable(model);
	    table.setRowHeight(400);
	    //for(int i = 0; i<3; i++)
	    //{
	    	table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer("./이미지/아이스 커피.jpg"));
	    	table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer("./이미지/콜드 브루.jpg"));
	    	table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer("./이미지/리프 파이.jpg"));
	    //}
	    
	    //table.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
	    //table.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
	    JScrollPane pane = new JScrollPane(table);
	    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    frame.getContentPane().add(BorderLayout.CENTER, pane);
	    frame.setSize(684, 470);
	    frame.setVisible(true);
	  }
	}

	class MyTableModel extends AbstractTableModel {
	  public Object getValueAt(int row, int column) {
	    return "";
	  }

	  public int getColumnCount() {
	    return 3;
	  }

	  public int getRowCount() {
	    return 5;
	  }
	}

	class ImageRenderer extends DefaultTableCellRenderer {
	  JLabel lbl = new JLabel();
	  ImageIcon icon;
	  public ImageRenderer(String img)
	  {
		 icon = new ImageIcon(img);
	  }
	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
		      boolean hasFocus, int row, int column) {
		    //lbl.setText("콜드 브루");
			  
		    lbl.setIcon(icon);
		    return lbl;
		  }
	}
