package kk;

import java.awt.event.*;

import javax.swing.*;

public class Combo {
	public Combo() {
	    JComboBox<Object> comboBox = new JComboBox<Object>();
	    comboBox.addItem(new Item("CEIT", "-"));
	    comboBox.addItem(new Item("EC", "X"));
	    comboBox.addItem(new Item("MC", "Y"));
	    comboBox.setMaximumRowCount(3);
	    comboBox.setSelectedIndex(0);
	    //comboBox.setPrototypeDisplayValue(" None of the above ");
	    comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 JComboBox c = (JComboBox) e.getSource();
			      Item item = (Item) c.getSelectedItem();
			      System.out.println(item.getId() + " : " + item.getDescription());
			}
	    	
	    });
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(comboBox);
	    frame.pack();
	    frame.setVisible(true);
	  }
	  public static void main(String[] args) {
	    new Combo();
	  }
	}
	/*class ItemRenderer extends BasicComboBoxRenderer {
	  @Override
	  public Component getListCellRendererComponent(JList list, Object value,
	      int index, boolean isSelected, boolean cellHasFocus) {
	    super.getListCellRendererComponent(list, value, index, isSelected,
	        cellHasFocus);
	    if (value != null) {
	      Item item = (Item) value;
	      setText(item.getDescription().toUpperCase());
	    }
	    if (index == -1) {
	      Item item = (Item) value;
	      setText("" + item.getId());
	    }
	    return this;
	  }
	}*/
	class Item {

	  private String id;
	  private String description;

	  public Item(String id, String description) {
	    this.id = id;
	    this.description = description;
	  }

	  public String getId() {
	    return id;
	  }

	  public String getDescription() {
	    return description;
	  }

	
	  public String toString() {
	    return description;
	  }

}