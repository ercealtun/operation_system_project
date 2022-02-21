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
 * Class DeleteFolderFrame: Generates user interface 
 * 	and includes functions for delete folders.
 */
public class DeleteFolderFrame extends JFrame implements IDeleteFolderFrame {

	DeleteFolderFrame() {
		
		final JLabel panel = new JLabel();
		this.setIconImage(null);
		this.setTitle("Delete folder");
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
		
		JButton button = new JButton("Delete folder");
		button.setBounds(200, 120, 120, 25);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		panel.add(button);
		
		this.setVisible(true);
		this.add(panel);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				String selected = (String) folders.getSelectedItem();
				deleteFolder(findFolderIndex(selected), findFolder(selected));
			}
		});
	}
	
	/**
	 * @apiNote check IDeleteFolderFrame.java for more info
	 */
	@Override
	public void deleteFolder(int folderIndex, Folder folder) {
		
		ThisComputerFrame.folderList.remove(folderIndex);
		ThisComputerFrame.deletedFolderList.add(folder);
		JOptionPane optionPane = new JOptionPane("Folder has deleted successfully!", JOptionPane.INFORMATION_MESSAGE);    
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
		
		for(int i=0; i<ThisComputerFrame.folderList.size(); i++) {
			if(folderName.equals(ThisComputerFrame.folderList.get(i).name)) {
				return ThisComputerFrame.folderList.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * @apiNote check IDeleteFolderFrame.java for more info
	 */
	@Override
	public int findFolderIndex(String folderName) {
		
		for(int i=0; i<ThisComputerFrame.folderList.size(); i++) {
			if(folderName.equals(ThisComputerFrame.folderList.get(i).name)) {
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
		
		int lenght = ThisComputerFrame.folderList.size();
		
		String[] userArray = new String[lenght];
		
		for(int i=0; i<lenght; i++) {
			userArray[i] = ThisComputerFrame.folderList.get(i).name;
		}
		
		return userArray;
	}

}
