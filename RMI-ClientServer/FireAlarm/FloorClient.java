package FireAlarm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FloorClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtFloor;
	private JButton btnHome;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FloorClient frame = new FloorClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FloorClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocationid = new JLabel("LocationID");
		lblLocationid.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 34));
		lblLocationid.setBounds(156, 189, 204, 34);
		contentPane.add(lblLocationid);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(547, 191, 194, 37);
		contentPane.add(textField_1);
		
		JLabel lblFloorName = new JLabel("Floor Name");
		lblFloorName.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 34));
		lblFloorName.setBounds(156, 273, 288, 34);
		contentPane.add(lblFloorName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(547, 273, 194, 37);
		contentPane.add(textField_2);
		
		JLabel lblFloorNo = new JLabel("Floor No");
		lblFloorNo.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 34));
		lblFloorNo.setBounds(156, 351, 204, 34);
		contentPane.add(lblFloorNo);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(547, 351, 194, 37);
		contentPane.add(textField_3);
		
		JLabel lblNoOfRooms = new JLabel("No Of Rooms");
		lblNoOfRooms.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 34));
		lblNoOfRooms.setBounds(156, 431, 288, 34);
		contentPane.add(lblNoOfRooms);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(547, 433, 194, 37);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Add Floor");
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
try {
					
					
					//String name = textField_3.getText();
					String locationId = textField_1.getText();
					String floorName = textField_2.getText();
					String floorNo = textField_3.getText();
					String noOfRooms = textField_4.getText();
				   
					
				
				    RegistationInterface dbq =(RegistationInterface)Naming.lookup("rmi://localhost:1061/db");
					
					String floorinsert=dbq.floorinsert(locationId,floorName,floorNo,noOfRooms);
						
					
					JOptionPane.showMessageDialog(null, floorinsert, "success", JOptionPane.INFORMATION_MESSAGE);
					
					setVisible(false);
					Home location =new Home();
					location.setVisible(true);
					
					}catch(Exception e1) {
						e1.printStackTrace();
					}
		
				
				
			}
		});
				
				
				
				
				
				
				
	
		btnNewButton.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		btnNewButton.setBounds(547, 530, 194, 50);
		contentPane.add(btnNewButton);
		
		txtFloor = new JTextField();
		txtFloor.setEditable(false);
		txtFloor.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 46));
		txtFloor.setBackground(new Color(255, 255, 204));
		txtFloor.setText("     Floor ");
		txtFloor.setBounds(476, 64, 228, 64);
		contentPane.add(txtFloor);
		txtFloor.setColumns(10);
		
		btnHome = new JButton("Home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				Home hh=new Home();
				hh.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		btnHome.setBackground(new Color(204, 255, 255));
		btnHome.setBounds(871, 74, 139, 50);
		contentPane.add(btnHome);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FloorClient.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 617);
		contentPane.add(lblNewLabel);
	}

}
