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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import Interfaces.IThisComputerFrame;
import Models.Folder;

/*
 * Class ThisComputerFrame: Generates user interface 
 * 	and includes functions for system information.
 */
public class ThisComputerFrame extends JFrame implements IThisComputerFrame {
	
	public static ArrayList<Folder> folderList = new ArrayList<Folder>();
	public static ArrayList<Folder> deletedFolderList = new ArrayList<Folder>();
	
	ThisComputerFrame() {
		
		final JLabel panel = new JLabel();
		this.setIconImage(null);
		this.setTitle("This computer");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocation(new Point(500, 200));
		this.setSize(MainFrame.frameWidth, MainFrame.frameHeight);
		
		LockFrame.usedCapacity = totalusedCapacity();
		LockFrame.emptyCapacity = LockFrame.totalCapacity - LockFrame.usedCapacity;
		
		JLabel name_label = new JLabel("Pc Name: XP360");
		name_label.setBounds(200, 180, 120, 20); 
		name_label.setForeground(Color.BLACK);
		panel.add(name_label);
		
		JLabel userCount_label = new JLabel("User count: "+ LockFrame.UserCount);
		userCount_label.setBounds(200, 230, 120, 20); 
		userCount_label.setForeground(Color.BLACK);
		panel.add(userCount_label);
		
		JLabel logged_label = new JLabel("Current user: "+ LockFrame.loggedUser.name);
		logged_label.setBounds(200, 280, 120, 20); 
		logged_label.setForeground(Color.BLACK);
		panel.add(logged_label);
		
		JLabel cap_label = new JLabel("Total capacity: " + LockFrame.totalCapacity + " Mb");
		cap_label.setBounds(500, 180, 150, 20); 
		cap_label.setForeground(Color.BLACK);
		panel.add(cap_label);
		
		JLabel empty_label = new JLabel("Empty: " + LockFrame.emptyCapacity + " Mb");
		empty_label.setBounds(500, 230, 150, 20); 
		empty_label.setForeground(Color.BLACK);
		panel.add(empty_label);
		
		JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setStringPainted(true);
		if(computePercent(LockFrame.usedCapacity, LockFrame.totalCapacity) >= 80) { progressBar.setForeground(Color.RED); }
		progressBar.setBounds(500, 280, 200, 50);
		progressBar.setValue(computePercent(LockFrame.usedCapacity, LockFrame.totalCapacity));
		progressBar.setStringPainted(true);
		panel.add(progressBar);
		
		JButton back_button = new JButton("Back");
		back_button.setBounds(620, 400, 120, 30);
		back_button.setForeground(Color.WHITE);
		back_button.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.add(back_button);
		
		this.setVisible(true);
		this.add(panel);
		
		back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				MainFrame mainFrame = new MainFrame();
				dispose();
			}
		});
	}
	
	/**
	 * @apiNote check IThisComputerFrame.java for more info
	 */
	@Override
	public int totalusedCapacity() {
		
		int usedCapacity = 0;
		
		for(int i=0; i<folderList.size(); i++) {
			
			usedCapacity += folderList.get(i).size;
		}
		
		return usedCapacity;
	}
	
	/**
	 * @apiNote check IThisComputerFrame.java for more info
	 */
	@Override
	public int computePercent(int usedCap, int totalCap) {
		
		return (usedCap * 100)/(totalCap);
	}
	
	/**
	 * @apiNote creates sample folder objects and 
	 * 	adds them to ArrayList<Folder> folderList.
	 */
	public static void createFolders() {
		
		folderList.add(new Folder("Pictures",  300, "8-01-20"));
		folderList.add(new Folder("Downloads", 200, "12-02-21"));
		folderList.add(new Folder("Audios",    150, "2-03-20"));
		folderList.add(new Folder("Games", 	   800, "15-12-21"));
		folderList.add(new Folder("Videos",    320, "7-05-20"));		
	}
}
