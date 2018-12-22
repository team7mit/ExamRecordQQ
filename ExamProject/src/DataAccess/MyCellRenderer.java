package DataAccess;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyCellRenderer extends JLabel implements TableCellRenderer{
	
public MyCellRenderer() {
		
		setOpaque(true);  
	}
	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) 
	{    
		System.out.println(Integer.parseInt(table.getValueAt(row, table.getColumnCount()-1).toString()));
    if(Integer.parseInt(table.getValueAt(row, column).toString()) < 40) {
    this.setBackground(Color.red);
    }
    else if(Integer.parseInt(table.getValueAt(row, column).toString()) > 85) {
    	this.setBackground(Color.green);
    }
    this.setHorizontalAlignment(JLabel.CENTER);
    this.setText(table.getValueAt(row, column).toString());
    return(this);
	}

}
