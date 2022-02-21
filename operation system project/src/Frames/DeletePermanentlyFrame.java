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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Interfaces.IDeleteFolderFrame;
import Models.Folder;

/*
 * Class DeletePermanentlyFrame: Generates user interface 
 * 	and includes functions for delete folders permanently.
 */
public class DeletePermanentlyFrame extends JFrame implements IDeleteFolderFrame {

	DeletePermanentlyFrame() {
		
		final JLabel panel = new JLabel();
		this.setIconImage(null);
		this.setTitle("Delete permanently");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocation(new Point(680, 300));
		this.setSize(600, 300);
		
		JLabel label = new JLabel("Select folder");
		label.setBounds(200, 60, 100, 20); 
		panel.add(label);
		
		final JComboBox<String> folders = new JComboBox<>(listToArray());
		folders.setBounds(200, 80, 193, 28);
		panel.add(folders);
		
		JButton button = new JButton("Delete folder permanently");
		button.setBounds(200, 120, 200, 25);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		panel.add(button);
		
		this.setVisible(true);
		this.add(panel);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				String selected = (String) folders.getSelectedItem();
				deleteFolder(findFolderIndex(selected), null);
			}
		});
	}

	/**
	 * @apiNote check IDeleteFolderFrame.java for more info
	 */
	@Override
	public void deleteFolder(int folderIndex, Folder folder) {
		
		ThisComputerFrame.deletedFolderList.remove(folderIndex);
		JOptionPane optionPane = new JOptionPane("Folder has deleted permanently!", JOptionPane.INFORMATION_MESSAGE);    
		JDialog dialog = optionPane.createDialog("Successful");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		MainFrame lockFrame = new MainFrame();
		dispose();
	}
	
	/**
	 * @apiNote check IDeleteFolderFrame.java for more info
	 */
	@Override
	public Folder findFolder(String folderName) {
		
		return null;
	}
	
	/**
	 * @apiNote check IDeleteFolderFrame.java for more info
	 */
	@Override
	public int findFolderIndex(String folderName) {
		
		for(int i=0; i<ThisComputerFrame.deletedFolderList.size(); i++) {
			if(folderName.equals(ThisComputerFrame.deletedFolderList.get(i).name)) {
				return i;
			}
		}
		
		return 0;
	}
	
	/**
	 * @apiNote check IDeleteFolderFrame.java for more info
	 */
	@Override
	public String[] listToArray() {
		
		int lenght = ThisComputerFrame.deletedFolderList.size();
		
		String[] userArray = new String[lenght];
		
		for(int i=0; i<lenght; i++) {
			userArray[i] = ThisComputerFrame.deletedFolderList.get(i).name;
		}
		
		return userArray;
	}
}
