package FireAlarm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Staff.staffne;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class userRegistationClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtRegistation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userRegistationClient frame = new userRegistationClient();
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
	public userRegistationClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 25));
		lblFirstName.setBounds(96, 148, 182, 47);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 25));
		lblLastName.setBounds(96, 229, 161, 47);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 25));
		lblEmail.setBounds(96, 317, 128, 47);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 25));
		lblPhoneNumber.setBounds(96, 389, 182, 47);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 25));
		lblPassword.setBounds(96, 482, 161, 47);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(308, 148, 210, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(308, 229, 210, 38);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(308, 317, 210, 38);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(308, 389, 210, 38);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(308, 482, 210, 38);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					
					String fname = textField.getText();
					String lname = textField_1.getText();
					String email = textField_2.getText();
				    String phonenumber = textField_3.getText();
				    String pasword = textField_4.getText();
					
				
				    RegistationInterface dbq =(RegistationInterface)Naming.lookup("rmi://localhost:1061/db");
					
					String result=dbq.insert(fname,lname,email,phonenumber,pasword);
						
					
					JOptionPane.showMessageDialog(null, result, "success", JOptionPane.INFORMATION_MESSAGE);
					
					setVisible(false);
					MainFire location =new MainFire();
					location.setVisible(true);
					
					}catch(Exception e1) {
						e1.printStackTrace();
					}
		
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 31));
		btnNewButton.setBounds(323, 544, 195, 60);
		contentPane.add(btnNewButton);
		
		txtRegistation = new JTextField();
		txtRegistation.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 34));
		txtRegistation.setBackground(new Color(255, 204, 102));
		txtRegistation.setEditable(false);
		txtRegistation.setText("    Registation");
		txtRegistation.setBounds(498, 36, 338, 99);
		contentPane.add(txtRegistation);
		txtRegistation.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				setVisible(false);
				LoginClient login = new LoginClient();
				login.setVisible(true);
				
			}
		});
		btnLogin.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 31));
		btnLogin.setBackground(new Color(255, 255, 204));
		btnLogin.setBounds(599, 544, 128, 60);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(userRegistationClient.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 617);
		contentPane.add(lblNewLabel);
	}
}
