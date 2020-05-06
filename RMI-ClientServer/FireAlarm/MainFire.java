package FireAlarm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Staff.attendance;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFire extends JFrame {

	private JPanel contentPane;
	private JTextField txtFireAlarmSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFire frame = new MainFire();
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
	public MainFire() {
		MainFire.this.setTitle("Fire Alarm Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFireAlarmSystem = new JTextField();
		txtFireAlarmSystem.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 26));
		txtFireAlarmSystem.setBackground(new Color(255, 204, 102));
		txtFireAlarmSystem.setEditable(false);
		txtFireAlarmSystem.setText("       Fire Alarm System");
		txtFireAlarmSystem.setBounds(422, 34, 360, 114);
		contentPane.add(txtFireAlarmSystem);
		txtFireAlarmSystem.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				setVisible(false);
				LoginClient ss = new LoginClient();
				ss.setVisible(true);
				
			}
		});
		btnLogin.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 24));
		btnLogin.setBackground(new Color(255, 255, 204));
		btnLogin.setBounds(455, 519, 327, 60);
		contentPane.add(btnLogin);
		
		JTextPane txtpnWeAtBosch = new JTextPane();
		txtpnWeAtBosch.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 19));
		txtpnWeAtBosch.setText("We at Bosch care about your safety. With over 80 years of experience in fire alarm systems, we provide you with smart products and solutions, designed to let you rest assured that your lives will not only be protected, but quickly and effectively saved.#SLIIT");
		txtpnWeAtBosch.setBounds(357, 215, 540, 139);
		contentPane.add(txtpnWeAtBosch);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				userRegistationClient uu=new userRegistationClient();
				uu.setVisible(true);
			}
		});
		btnRegister.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 24));
		btnRegister.setBackground(new Color(255, 255, 204));
		btnRegister.setBounds(444, 417, 327, 60);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainFire.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 617);
		contentPane.add(lblNewLabel);
	}
}
