package FireAlarm;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Librarian;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtLoginFireAlarm;
	private JButton btnHome;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginClient frame = new LoginClient();
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
	public LoginClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(185, 202, 108, 50);
		contentPane.add(lblNewLabel_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPassword.setBounds(185, 286, 142, 50);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(472, 212, 249, 41);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(472, 296, 249, 41);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tekton Pro Ext", Font.BOLD, 26));
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String email = textField.getText();
					String pass = textField_1.getText();

					RegistationInterface dbq = (RegistationInterface) Naming.lookup("rmi://localhost:1061/db");

					String result = dbq.insertlogin(email, pass);

					if ( (result != null)  ) {
						
						if(   (email.equals("malith@gmail.com")  )) {
							
							JOptionPane.showMessageDialog(null, result, "Admin Login", JOptionPane.INFORMATION_MESSAGE);
							
							setVisible(false);
							Home hh = new Home();
							hh.setVisible(true);
							
						}
					
						
					
					else  {
						JOptionPane.showMessageDialog(null, result, "User Login", JOptionPane.INFORMATION_MESSAGE);
						
						setVisible(false);
						sensorfulldatashow hh = new sensorfulldatashow();
						hh.setVisible(true);
					}
					}
					
//System.out.println(result);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please Type Valid Login ", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnNewButton.setBounds(496, 403, 193, 50);
		contentPane.add(btnNewButton);

		txtLoginFireAlarm = new JTextField();
		txtLoginFireAlarm.setEditable(false);
		txtLoginFireAlarm.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 26));
		txtLoginFireAlarm.setBackground(new Color(255, 255, 204));
		txtLoginFireAlarm.setText("Login Fire Alarm System");
		txtLoginFireAlarm.setBounds(363, 50, 368, 74);
		contentPane.add(txtLoginFireAlarm);
		txtLoginFireAlarm.setColumns(10);

		btnHome = new JButton("Home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				setVisible(false);
				MainFire hh = new MainFire();
				hh.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tekton Pro Ext", Font.BOLD, 26));
		btnHome.setBackground(new Color(204, 255, 255));
		btnHome.setBounds(888, 50, 148, 50);
		contentPane.add(btnHome);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(LoginClient.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 617);
		contentPane.add(lblNewLabel);
	}
}
