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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Interfaces.IAddFolderFrame;
import Models.Folder;

/*
 * Class AddFolderFrame: Generates user interface 
 * 	and includes functions for adding folder.
 */
public class AddFolderFrame extends JFrame implements IAddFolderFrame {

	private static JLabel name, size;
	private static JTextField name_field, size_field;
	private static JButton button;
	
	AddFolderFrame() {
		
		final JLabel panel = new JLabel();
		this.setIconImage(null);
		this.setTitle("Add folder");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocation(new Point(680, 300));
		this.setSize(600, 300);
		
		name = new JLabel("Name");
		name.setBounds(200, 8, 70, 20);
		panel.add(name);
		
		name_field = new JTextField();
		name_field.setBounds(200, 28, 193, 28);
		panel.add(name_field);
		
		size = new JLabel("Size");
		size.setBounds(200, 55, 70, 20);
		panel.add(size);
		
		size_field = new JTextField();
		size_field.setBounds(200, 75, 193, 28);
		panel.add(size_field);		

		button = new JButton("Add folder");
		button.setBounds(200, 110, 120, 25);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		panel.add(button);
		
		this.setVisible(true);
		this.add(panel);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				
				if(Integer.parseInt(size_field.getText())>0){
					Folder newFolder = new Folder(name_field.getText(), Integer.parseInt(size_field.getText()), date.format(formatter));
					addFolder(newFolder);
				}
				else {
					JOptionPane optionPane = new JOptionPane("Folder size must be greater than 0!", JOptionPane.ERROR_MESSAGE);    
					JDialog dialog = optionPane.createDialog("Failure");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}
			}
		});
	}

	/**
	 * @apiNote check IAddFolderFrame.java for more info
	 */
	@Override
	public void addFolder(Folder folder) {
		
		if(isSpaceAvaible(folder.size)) {
			ThisComputerFrame.folderList.add(folder);
			JOptionPane optionPane = new JOptionPane("Folder has added successfully!", JOptionPane.INFORMATION_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Successful");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			MainFrame lockFrame = new MainFrame();
			dispose();
		}
		else {
			JOptionPane optionPane = new JOptionPane("Not enough space is available!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Failure");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	/**
	 * @apiNote check IAddFolderFrame.java for more info
	 */
	@Override
	public boolean isSpaceAvaible(int newFolderSize) {
		
		System.out.println(LockFrame.emptyCapacity);
		return newFolderSize <= (LockFrame.emptyCapacity);
	}

}
