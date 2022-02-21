package Frames;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */
import javax.swing.*;

import Interfaces.IAddUserFrame;
import Models.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Class AddUserFrame: Generates user interface 
 * 	and includes functions for adding user.
 */
public class AddUserFrame extends JFrame implements IAddUserFrame{
	
	private static JLabel password1, label;
	private static JTextField username;
	private static JButton button;
	private static JPasswordField Password;
	
	AddUserFrame() {
		
		final JLabel panel = new JLabel();
		this.setIconImage(null);
		this.setTitle("Add user");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocation(new Point(680, 300));
		this.setSize(600, 300);
		
		label = new JLabel("Username");
		label.setBounds(200, 8, 70, 20);
		panel.add(label);
		
		username = new JTextField();
		username.setBounds(200, 27, 193, 28);
		panel.add(username);
		
		password1 = new JLabel("Password");
		password1.setBounds(200, 55, 70, 20);
		panel.add(password1);
		
		Password = new JPasswordField();
		Password.setBounds(200, 75, 193, 28);
		panel.add(Password);
		
		button = new JButton("Add User");
		button.setBounds(200, 110, 90, 25);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		panel.add(button);
		
		this.setVisible(true);
		this.add(panel);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				User tmp_user = createUser(username.getText(), Password.getText());
				saveUser(tmp_user);
			}
		});
	}

	/**
	 * @apiNote check IAddUserFrame.java for more info
	 */
	@Override
	public User createUser(String username, String password) {
		
		User newUser = new User(username, password);
		return newUser;
	}

	/**
	 * @apiNote check IAddUserFrame.java for more info
	 */
	@Override
	public void saveUser(User user) {
		
		if(!isUserExist(user.name)) {
			LockFrame.userList.add(user);
			writeFile(user);
		}
		else {
			JOptionPane optionPane = new JOptionPane("User with same username is already exists!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Failure");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	/**
	 * @apiNote check IAddUserFrame.java for more info
	 */
	@Override
	public boolean isUserExist(String username) {
		
		for(int i=0; i<LockFrame.userList.size(); i++) {
			
			if(LockFrame.userList.get(i).name.equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @apiNote check IAddUserFrame.java for more info
	 */
	@Override
	public void writeFile(User user) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(LockFrame.user_file, true));
            writer.newLine();
            writer.write(user.toString());
            System.out.println("file write completed");
            writer.close();
            
            JOptionPane optionPane = new JOptionPane("User has added successfully!", JOptionPane.INFORMATION_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Successful");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			
			LockFrame lockFrame = new LockFrame();
			dispose();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
