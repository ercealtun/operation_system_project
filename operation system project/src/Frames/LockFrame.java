package Frames;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import Interfaces.ILockFrame;
import Models.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Class LockFrame: Generates user interface 
 * 	and includes functions for Authorization 
 * 	and creation of necessary lists.
 */
public class LockFrame extends JFrame implements ILockFrame{

	public static File user_file = new File("operation system project\\src\\Source\\Users.txt");
	public static ArrayList<User> userList = new ArrayList<User>();
	public static User loggedUser;
	public static int UserCount;
	public static final int totalCapacity = 3000;
	public static int usedCapacity;
	public static int emptyCapacity;
		
	public LockFrame() {
		
		Icon account = new ImageIcon("operation system project\\\\src\\Assets\\account.png");
		Icon shutdown = new ImageIcon("operation system project\\\\src\\Assets\\shutdown.png");
		final JLabel panel = new JLabel(new ImageIcon("operation system project\\\\src\\Assets\\lockframe-bg.jpeg"));
		this.setTitle("LOGIN PAGE");
		this.setLocation(new Point(500, 200));
		this.add(panel);
		this.setSize(MainFrame.frameWidth, MainFrame.frameHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Driver.control++;
		readUsers(); 
		UserCount = userList.size();
		if(Driver.control<=1) { ThisComputerFrame.createFolders(); }
		LockFrame.usedCapacity = totalusedCapacity();
		LockFrame.emptyCapacity = LockFrame.totalCapacity - LockFrame.usedCapacity;
		
		JButton user_button = new JButton(account);
		user_button.setBounds(350, 40, 250, 250);
		user_button.setContentAreaFilled(false);
		user_button.setBorderPainted(false);
		user_button.setFocusable(false);
		panel.setLayout(null);
		panel.add(user_button);
		
		JLabel label = new JLabel("Select user");
		label.setBounds(380, 258, 70, 20); 
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		final JComboBox<String> users = new JComboBox<>(listToArray());
		users.setBounds(380, 277, 193, 28);
		users.setForeground(Color.black);
		panel.add(users);
		
		JLabel password1 = new JLabel("Password");
		password1.setBounds(380, 305, 70, 20);
		password1.setForeground(Color.WHITE);
		panel.add(password1);
		
		JPasswordField password_field = new JPasswordField();
		password_field.setBounds(380, 325, 193, 28);
		panel.add(password_field);
		
		JButton button = new JButton("Login");
		button.setBounds(430, 360, 90, 25);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		panel.add(button);
		
		JButton power_button = new JButton(shutdown);
		power_button.setBounds(850, 410, 128, 128);
		power_button.setContentAreaFilled(false);
		power_button.setBorderPainted(false);
		power_button.setFocusable(false);
		panel.setLayout(null);
		panel.add(power_button);
		
		this.setVisible(true);
		this.add(panel);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				if(loginConfiguration(findUser((String) users.getSelectedItem()), password_field.getText())) {
					loggedUser = findUser((String) users.getSelectedItem());
					System.out.println("login succesfull");
					MainFrame mf = new MainFrame();		
					dispose();
				}	
				else {
					JOptionPane optionPane = new JOptionPane("Wrong password", JOptionPane.ERROR_MESSAGE);    
					JDialog dialog = optionPane.createDialog("Failure");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}
			}
		});
		
		power_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				int confirmed = JOptionPane.showConfirmDialog(null, "Do you want to shutdown system?", "Shutdown",
						JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}
	
	/**
	 * @apiNote check ILockFrame.java for more info
	 */
	@Override
	public void readUsers() {
		
		try {
            
    		Scanner read = new Scanner(user_file);
            while(read.hasNextLine()) {

                String line = read.nextLine();
                String Str[] = line.split(" ");
                String tmp_username = Str[0];
                String tmp_password = Str[1];                                        
                if(!isUserExist(tmp_username)) {
                	User tmp_user = new User(tmp_username, tmp_password);
                	userList.add(tmp_user);
                }
                
            }
            read.close();
    		
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}

	/**
	 * @apiNote check ILockFrame.java for more info
	 */
	@Override
	public boolean loginConfiguration(User user, String password) {
			
		return user.password.equals(password);
	}
	
	/**
	 * @apiNote check ILockFrame.java for more info
	 */
	@Override
	public User findUser(String username) {
		
		for(int i=0; i<userList.size(); i++) {
			if(username.equals(userList.get(i).name)) {
				return userList.get(i);
			}
		}
		
		return null;
	}

	/**
	 * @apiNote check ILockFrame.java for more info
	 */
	@Override
	public String[] listToArray() {
		
		int lenght = userList.size();
		
		String[] userArray = new String[lenght];
		
		for(int i=0; i<lenght; i++) {
			userArray[i] = userList.get(i).name;
		}
		
		return userArray;
	}

	/**
	 * @apiNote check ILockFrame.java for more info
	 */
	@Override
	public boolean isUserExist(String username) {
		
		for(int i=0; i<userList.size(); i++) {
			
			if(userList.get(i).name.equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @apiNote computes total used capacity and returns it.
	 */
	public static int totalusedCapacity() {
		
		int usedCapacity = 0;
		
		for(int i=0; i<ThisComputerFrame.folderList.size(); i++) {
			
			usedCapacity += ThisComputerFrame.folderList.get(i).size;
		}
		
		return usedCapacity;
	}
}
