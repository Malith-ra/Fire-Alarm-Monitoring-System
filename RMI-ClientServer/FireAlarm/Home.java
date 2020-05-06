package FireAlarm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Staff.attendance;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField txtFireAlarm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		Home.this.setTitle("Fire Alarm Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFireAlarm = new JTextField();
		txtFireAlarm.setEditable(false);
		txtFireAlarm.setBackground(new Color(255, 204, 102));
		txtFireAlarm.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 27));
		txtFireAlarm.setText("    Fire Alarm Monitoring System Admin ");
		txtFireAlarm.setBounds(198, 50, 647, 78);
		contentPane.add(txtFireAlarm);
		txtFireAlarm.setColumns(10);
		
		JButton btnNewButton = new JButton("Show Sensor Status");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				Admin list = new Admin();
				list.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.setFont(new Font("Tekton Pro Ext", Font.BOLD, 18));
		btnNewButton.setBounds(473, 528, 219, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				setVisible(false);
				MainFire list = new MainFire();
				list.setVisible(true);
				
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 18));
		btnNewButton_1.setBounds(917, 50, 133, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnAddFloor = new JButton("Add Location");
		btnAddFloor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				LocationClient lc=new LocationClient();
				lc.setVisible(true);
				
				
			}
		});
		btnAddFloor.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 18));
		btnAddFloor.setBackground(new Color(255, 255, 204));
		btnAddFloor.setBounds(473, 200, 219, 46);
		contentPane.add(btnAddFloor);
		
		JButton button = new JButton("Add Floor");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				FloorClient lc=new FloorClient();
				lc.setVisible(true);
			}
		});
		button.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 18));
		button.setBackground(new Color(255, 255, 204));
		button.setBounds(473, 278, 219, 46);
		contentPane.add(button);
		
		JButton btnAddRoom = new JButton("Add Room");
		btnAddRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				setVisible(false);
				RoomClient lc=new RoomClient();
				lc.setVisible(true);
			
			
			}
		});
		btnAddRoom.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 18));
		btnAddRoom.setBackground(new Color(255, 255, 204));
		btnAddRoom.setBounds(473, 358, 219, 46);
		contentPane.add(btnAddRoom);
		
		JButton btnAddSensor = new JButton("Add Sensor");
		btnAddSensor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
				SensorClient lc=new SensorClient();
				lc.setVisible(true);
				
			}
		});
		btnAddSensor.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 18));
		btnAddSensor.setBackground(new Color(255, 255, 204));
		btnAddSensor.setBounds(473, 435, 219, 46);
		contentPane.add(btnAddSensor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 617);
		contentPane.add(lblNewLabel);
	}
}
