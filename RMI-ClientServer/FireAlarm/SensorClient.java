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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class SensorClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtSensor;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SensorClient frame = new SensorClient();
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
	public SensorClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRoomId = new JLabel("Owner Id");
		lblRoomId.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		lblRoomId.setBounds(101, 222, 149, 51);
		contentPane.add(lblRoomId);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(444, 165, 213, 40);
		contentPane.add(textField);

		JButton btnNewButton = new JButton("Add Sensor");
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String roomId = textField.getText();
					String ownerid = textField_1.getText();
					String locationId = textField_2.getText();
					String floorId = textField_3.getText();
					String name = textField_4.getText();

					RegistationInterface dbq = (RegistationInterface) Naming.lookup("rmi://localhost:1061/db");

					String sensorinsert = dbq.sensorinsert(roomId, ownerid,locationId,floorId,name);

					JOptionPane.showMessageDialog(null, sensorinsert, "success", JOptionPane.INFORMATION_MESSAGE);


				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		btnNewButton.setBounds(487, 532, 230, 46);
		contentPane.add(btnNewButton);

		txtSensor = new JTextField();
		txtSensor.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 44));
		txtSensor.setText("    Sensor");
		txtSensor.setEditable(false);
		txtSensor.setBackground(new Color(255, 255, 204));
		txtSensor.setBounds(444, 48, 273, 78);
		contentPane.add(txtSensor);
		txtSensor.setColumns(10);

		JLabel label = new JLabel("Room Id");
		label.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		label.setBounds(101, 158, 149, 51);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(444, 229, 213, 40);
		contentPane.add(textField_1);

		JLabel lblLocationId = new JLabel("Location Id");
		lblLocationId.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		lblLocationId.setBounds(101, 286, 189, 51);
		contentPane.add(lblLocationId);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(444, 293, 213, 40);
		contentPane.add(textField_2);

		JLabel lblFloorId = new JLabel("Floor Id");
		lblFloorId.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		lblFloorId.setBounds(101, 364, 149, 51);
		contentPane.add(lblFloorId);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(444, 371, 213, 40);
		contentPane.add(textField_3);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		lblName.setBounds(101, 429, 149, 51);
		contentPane.add(lblName);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(444, 436, 213, 40);
		contentPane.add(textField_4);

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				Home hh = new Home();
				hh.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 30));
		btnHome.setBackground(new Color(204, 255, 255));
		btnHome.setBounds(901, 67, 136, 46);
		contentPane.add(btnHome);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(SensorClient.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 617);
		contentPane.add(lblNewLabel);
	}

}
