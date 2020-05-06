package FireAlarm;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LocationClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtLocation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationClient frame = new LocationClient();
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
	public LocationClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Owner Id");
		label_1.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 35));
		label_1.setBounds(118, 184, 237, 43);
		contentPane.add(label_1);
		
		JLabel lblLoationName = new JLabel("Loation Name");
		lblLoationName.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 35));
		lblLoationName.setBounds(118, 240, 280, 62);
		contentPane.add(lblLoationName);
		
		JLabel label_3 = new JLabel("Address");
		label_3.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 35));
		label_3.setBounds(118, 315, 221, 48);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("No Of Floors");
		label_4.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 35));
		label_4.setBounds(118, 387, 267, 43);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(501, 257, 207, 34);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(501, 325, 207, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(501, 394, 207, 34);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Add Location");
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					
					//String name = textField_3.getText();
					String id = textField_3.getText();
					String fname = textField.getText();
					String address = textField_1.getText();
					String NoOfFloors = textField_2.getText();
				   
					
				
				    RegistationInterface dbq =(RegistationInterface)Naming.lookup("rmi://localhost:1061/db");
					
					String locationinsert=dbq.locationinsert(id,fname,address,NoOfFloors);
						
					
					JOptionPane.showMessageDialog(null, locationinsert, "success", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					Home location =new Home();
					location.setVisible(true);
					
					
					}catch(Exception e1) {
						e1.printStackTrace();
					}
		
				
				
			}
		});
		btnNewButton.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 31));
		btnNewButton.setBounds(449, 498, 259, 55);
		contentPane.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setBounds(501, 191, 207, 34);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		txtLocation = new JTextField();
		txtLocation.setEditable(false);
		txtLocation.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 34));
		txtLocation.setBackground(new Color(255, 255, 204));
		txtLocation.setText("     Location");
		txtLocation.setBounds(462, 33, 246, 69);
		contentPane.add(txtLocation);
		txtLocation.setColumns(10);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Home hh=new Home();
				hh.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 31));
		btnHome.setBackground(new Color(204, 255, 255));
		btnHome.setBounds(921, 41, 129, 55);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LocationClient.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 617);
		contentPane.add(lblNewLabel);
		
		
		
		
		

		
	}
		
		
			

}

