package Frames;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * Class MainFrame: Generates user interface 
 * 	and includes functions for desktop operation routings.
 */
public class MainFrame extends JFrame {

	public static final int frameWidth = 960;
	public static final int frameHeight = 540;

	MainFrame() {

		Icon user_ico = new ImageIcon("operation system project\\\\src\\Assets\\user.png");
		Icon pc_ico = new ImageIcon("operation system project\\\\src\\Assets\\this-pc.png");
		Icon recycle_ico = new ImageIcon("operation system project\\\\src\\Assets\\trash-icon.png");
		Icon power = new ImageIcon("operation system project\\\\src\\Assets\\logout.png");
		Icon folderx = new ImageIcon("operation system project\\\\src\\Assets\\folder-explorer.png");
		
		final JLabel panel = new JLabel(new ImageIcon("operation system project\\\\src\\Assets\\mainframe-bg.jpg"));
		this.setIconImage(null);
		this.setTitle("Beeos");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocation(new Point(500, 200));
		this.setSize(frameWidth, frameHeight);
		
		JButton user_button = new JButton(user_ico);
		user_button.setBounds(30, 150, 128, 128);
		user_button.setContentAreaFilled(false);
		user_button.setBorderPainted(false);
		panel.setLayout(null);
		panel.add(user_button);
		
		JLabel user_label = new JLabel();
		user_label.setText(LockFrame.loggedUser.name);
		user_label.setBounds(70, 230, 128, 128);
		user_label.setFont(new java.awt.Font("Arial Black", Font.BOLD, 16));
		user_label.setForeground(Color.WHITE);
		panel.add(user_label);

		JButton thisPc_button = new JButton(pc_ico);
		thisPc_button.setBounds(230, 150, 128, 128);
		thisPc_button.setContentAreaFilled(false);
		thisPc_button.setBorderPainted(false);
		panel.setLayout(null);
		panel.add(thisPc_button);
		
		JLabel thisPc_label = new JLabel();
		thisPc_label.setText("This computer");
		thisPc_label.setBounds(230, 230, 200, 128);
		thisPc_label.setFont(new java.awt.Font("Arial Black", Font.BOLD, 16));
		thisPc_label.setForeground(Color.WHITE);
		panel.add(thisPc_label);

		JButton recycleBin_button = new JButton(recycle_ico);
		recycleBin_button.setBounds(420, 150, 128, 128);
		recycleBin_button.setContentAreaFilled(false);
		recycleBin_button.setBorderPainted(false);
		panel.setLayout(null);
		panel.add(recycleBin_button);
		
		JLabel recycleBin_label = new JLabel();
		recycleBin_label.setText("Trash bin");
		recycleBin_label.setBounds(435, 230, 128, 128);
		recycleBin_label.setFont(new java.awt.Font("Arial Black", Font.BOLD, 16));
		recycleBin_label.setForeground(Color.WHITE);
		panel.add(recycleBin_label);
		
		JButton power_button = new JButton(power);
		power_button.setBounds(610, 150, 128, 128);
		power_button.setContentAreaFilled(false);
		power_button.setBorderPainted(false);
		panel.setLayout(null);
		panel.add(power_button);
		
		JLabel power_label = new JLabel();
		power_label.setText("Shutdown");
		power_label.setBounds(625, 230, 128, 128);
		power_label.setFont(new java.awt.Font("Arial Black", Font.BOLD, 16));
		power_label.setForeground(Color.WHITE);
		panel.add(power_label);
				
		JButton folders_button = new JButton(folderx);
		folders_button.setBounds(800, 150, 128, 128);
		folders_button.setContentAreaFilled(false);
		folders_button.setBorderPainted(false);
		panel.setLayout(null);
		panel.add(folders_button);
		
		JLabel folders_label = new JLabel();
		folders_label.setText("Folders");
		folders_label.setBounds(825, 230, 128, 128);
		folders_label.setFont(new java.awt.Font("Arial Black", Font.BOLD, 16));
		folders_label.setForeground(Color.WHITE);
		panel.add(folders_label);
		
		this.setVisible(true);
		this.add(panel);

		user_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				UserFrame userFrame = new UserFrame();
				dispose();
			}
		});

		thisPc_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				ThisComputerFrame thisComputerFrame = new ThisComputerFrame();
				dispose();
			}
		});

		recycleBin_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				TrashFrame trashFrame = new TrashFrame();
				dispose();
			}
		});
		
		power_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				int confirmed = JOptionPane.showConfirmDialog(null, "Do you want to end your session", "Exit?", JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					LockFrame lockFrame = new LockFrame();
					dispose();
				}
			}
		});

		folders_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				FoldersFrame foldersFrame = new FoldersFrame();
				dispose();
			}
		});		
	}
}