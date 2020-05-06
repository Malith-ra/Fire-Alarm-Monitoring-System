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
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class RoomClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtRoom;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomClient frame = new RoomClient();
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
	public RoomClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Floor Id");
		lblNewLabel_1.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(232, 177, 139, 52);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(595, 177, 177, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRoomName = new JLabel("Room Name");
		lblRoomName.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		lblRoomName.setBounds(232, 254, 186, 52);
		contentPane.add(lblRoomName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(595, 252, 177, 38);
		contentPane.add(textField_1);
		
		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		lblRoomNo.setBounds(232, 333, 214, 52);
		contentPane.add(lblRoomNo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(595, 342, 177, 38);
		contentPane.add(textField_2);
		
		JLabel lblNoOfSensors = new JLabel("No Of Sensors");
		lblNoOfSensors.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		lblNoOfSensors.setBounds(232, 416, 252, 52);
		contentPane.add(lblNoOfSensors);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(595, 425, 177, 38);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Add Room");
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					
					//String name = textField_3.getText();
					String floorId = textField.getText();
					String RoomName = textField_1.getText();
					String RoomNo = textField_2.getText();
					String NoOfSensors = textField_3.getText();
				   
					
				
				    RegistationInterface dbq =(RegistationInterface)Naming.lookup("rmi://localhost:1061/db");
					
					String roominsert=dbq.roominsert(floorId,RoomName,RoomNo,NoOfSensors);
						
					
					JOptionPane.showMessageDialog(null, roominsert, "success", JOptionPane.INFORMATION_MESSAGE);
					
					setVisible(false);
					Home location =new Home();
					location.setVisible(true);
					
					}catch(Exception e1) {
						e1.printStackTrace();
					}
		
				
		
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		btnNewButton.setBounds(567, 534, 205, 47);
		contentPane.add(btnNewButton);
		
		txtRoom = new JTextField();
		txtRoom.setEditable(false);
		txtRoom.setBackground(new Color(255, 255, 204));
		txtRoom.setText("   Room");
		txtRoom.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 43));
		txtRoom.setBounds(514, 62, 221, 70);
		contentPane.add(txtRoom);
		txtRoom.setColumns(10);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home hh=new Home();
				hh.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		btnHome.setBackground(new Color(204, 255, 255));
		btnHome.setBounds(900, 62, 139, 47);
		contentPane.add(btnHome);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RoomClient.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 617);
		contentPane.add(lblNewLabel);
	}

}
