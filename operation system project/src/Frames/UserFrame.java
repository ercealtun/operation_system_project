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
 * Class UserFrame: Generates user interface 
 * 	and includes functions for user operation routings.
 */
public class UserFrame extends JFrame implements ITableLister {
	
	private static int userCount = LockFrame.userList.size();

	UserFrame() { //user update, delete, add, get
		
		JTable table;

		final JLabel panel = new JLabel();
		this.setIconImage(null);
		this.setTitle("User");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocation(new Point(500, 200));
		this.setSize(MainFrame.frameWidth, MainFrame.frameHeight);
		
		String[][] data = listTodArray();
		String[] columnNames = { "Name", "Password"};
		
		JLabel settings_label = new JLabel();
		settings_label.setText("Users");
		settings_label.setBounds(380, 40, 200, 100);
		settings_label.setForeground(Color.BLACK);
		panel.add(settings_label);
		
		table = new  JTable(data, columnNames);
		table.setBounds(380, 100, 200, 100);
		table.setVisible(true);
		panel.add(table);
		
		JButton add_button = new JButton("Add user");
		add_button.setBounds(320, 400, 120, 30);
		add_button.setForeground(Color.WHITE);
		add_button.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.add(add_button);
		
		JButton back_button = new JButton("Back");
		back_button.setBounds(520, 400, 120, 30);
		back_button.setForeground(Color.WHITE);
		back_button.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.add(back_button);
		
		this.setVisible(true);
		this.add(panel);
		
		add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				AddUserFrame addUserFrame = new AddUserFrame();
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
		
		String[][] data = new String[userCount][2];
		
		for(int i=0; i<userCount; i++) {
			
			data[i][0] = LockFrame.userList.get(i).name;
			data[i][1] = LockFrame.userList.get(i).password;
		}
		
		return data;
	}
}
