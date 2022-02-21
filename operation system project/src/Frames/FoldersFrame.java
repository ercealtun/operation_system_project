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
import Models.Folder;

/*
 * Class FoldersFrame: Generates user interface 
 * 	and includes functions for folder operation routings.
 */
public class FoldersFrame extends JFrame implements ITableLister {
	
	FoldersFrame() {
		
		JTable table;
		
		final JLabel panel = new JLabel();
		this.setIconImage(null);
		this.setTitle("Folders");
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
		
		JButton add_button = new JButton("Add folder");
		add_button.setBounds(220, 400, 120, 30);
		add_button.setForeground(Color.WHITE);
		add_button.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.add(add_button);
		
		JButton delete_button = new JButton("Delete folder");
		delete_button.setBounds(420, 400, 120, 30);
		delete_button.setForeground(Color.WHITE);
		delete_button.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.add(delete_button);
		
		JButton back_button = new JButton("Back");
		back_button.setBounds(620, 400, 120, 30);
		back_button.setForeground(Color.WHITE);
		back_button.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.add(back_button);
		
		this.setVisible(true);
		this.add(panel);
		
		add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				AddFolderFrame addFolderFrame = new AddFolderFrame();
				dispose();
			}
		});
		
		delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				DeleteFolderFrame deleteFolderFrame = new DeleteFolderFrame();
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
		
		String[][] data = new String[ThisComputerFrame.folderList.size()][3];
		
		for(int i=0; i<ThisComputerFrame.folderList.size(); i++) {
			
			data[i][0] = ThisComputerFrame.folderList.get(i).name;
			data[i][1] = Integer.toString(ThisComputerFrame.folderList.get(i).size);
			data[i][2] = ThisComputerFrame.folderList.get(i).createDate;
		}
		
		return data;
	}
}
