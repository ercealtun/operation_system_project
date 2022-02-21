package Frames;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import Interfaces.ITableLister;

/*
 * Class TrashFrame: Generates user interface 
 * 	and includes functions for deleted folders.
 */
public class TrashFrame extends JFrame implements ITableLister {

	TrashFrame() {
		
		JTable table;
		
		final JLabel panel = new JLabel();
		this.setIconImage(null);
		this.setTitle("Trash bin");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocation(new Point(500, 200));
		this.setSize(MainFrame.frameWidth, MainFrame.frameHeight);
		
		String[][] data = listTodArray();
		String[] columnNames = { "Name", "Size", "Creation time"};
		
		JLabel name_label = new JLabel();
		name_label.setText("Name");
		name_label.setBounds(355, 40, 200, 100);
		name_label.setForeground(Color.BLACK);
		panel.add(name_label);
		
		JLabel size_label = new JLabel();
		size_label.setText("Size(Mb)");
		size_label.setBounds(440, 40, 200, 100);
		size_label.setForeground(Color.BLACK);
		panel.add(size_label);
		
		JLabel date_label = new JLabel();
		date_label.setText("Creation date");
		date_label.setBounds(522, 40, 200, 100);
		date_label.setForeground(Color.BLACK);
		panel.add(date_label);
		
		table = new  JTable(data, columnNames);
		table.setBounds(355, 100, 250, 200);
		table.setVisible(true);
		panel.add(table);
		
		JButton delete_button = new JButton("Delete folder");
		delete_button.setBounds(320, 400, 120, 30);
		delete_button.setForeground(Color.WHITE);
		delete_button.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.add(delete_button);
		
		JButton back_button = new JButton("Back");
		back_button.setBounds(520, 400, 120, 30);
		back_button.setForeground(Color.WHITE);
		back_button.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.add(back_button);
		
		this.setVisible(true);
		this.add(panel);
		
		delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				DeletePermanentlyFrame deletePermanentlyFrame = new DeletePermanentlyFrame();
				dispose();
			}
		});
		
		back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				MainFrame mainFrame = new MainFrame();
				dispose();
			}
		});
	}
	
	/**
	 * @apiNote check ITableLister.java for more info
	 */
	@Override
	public String[][] listTodArray () {
		
		String[][] data = new String[ThisComputerFrame.deletedFolderList.size()][3];
		
		for(int i=0; i<ThisComputerFrame.deletedFolderList.size(); i++) {
			
			data[i][0] = ThisComputerFrame.deletedFolderList.get(i).name;
			data[i][1] = Integer.toString(ThisComputerFrame.deletedFolderList.get(i).size);
			data[i][2] = ThisComputerFrame.deletedFolderList.get(i).createDate;
		}
		
		return data;
	}
}
