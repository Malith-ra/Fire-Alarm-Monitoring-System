package FireAlarm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import Staff.attendance;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.Naming;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

public class Admin extends JFrame  {



	
	private JPanel contentPane;
	private static JTable table;
	private JTextField txtFireAlarmDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1);
					Admin frame = new Admin();
					frame.setVisible(true);
				
					
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					String[][] data = tableshow();

					for (int i = 0; i < data.length; i++) {
						dtm.addRow(data[i]);
					}
					
				
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(29, 132, 743, 475);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 719, 449);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sensor ID", "RoomNo", "OwnerId", "LocationNo", "FloorNo", "SensorName", "Status","CO2 Level","Smoke Level"
			}
		));
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Edit Sensor");
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					 RegistationInterface dbq =(RegistationInterface)Naming.lookup("rmi://localhost:1061/db");
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					// System.out.print(jtable1.getSelectedRow());
					int i = table.getSelectedRow();

					String SensorID = (String) table.getValueAt(i, 0);
					//String RoomId = (String) table.getValueAt(i, 1);
					String RoomId = (String) table.getValueAt(i, 1);
					String OwnerId = (String) table.getValueAt(i, 2);
					String LocationId = (String) table.getValueAt(i, 3);
					String FloorId = (String) table.getValueAt(i, 4);
					String SensorName = (String) table.getValueAt(i, 5);

					
						
						String edit=dbq.editdetails(SensorID, RoomId, OwnerId, LocationId, FloorId, SensorName);
							
						
						JOptionPane.showMessageDialog(null, edit, "success", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Invalid Details",
							"Please Enter Valid Records To Update Data..!", JOptionPane.ERROR_MESSAGE);
				}
			}



		});
		btnNewButton.setFont(new Font("Tekton Pro Ext", Font.BOLD, 30));
		btnNewButton.setBounds(788, 417, 262, 53);
		contentPane.add(btnNewButton);
		
		txtFireAlarmDetails = new JTextField();
		txtFireAlarmDetails.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 26));
		txtFireAlarmDetails.setBackground(new Color(255, 204, 153));
		txtFireAlarmDetails.setText("     Fire Alarm Details Edit");
		txtFireAlarmDetails.setBounds(359, 13, 385, 106);
		contentPane.add(txtFireAlarmDetails);
		txtFireAlarmDetails.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Admin Home");
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(868, 13, 182, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnDeleteSensor = new JButton("Delete Sensor");
		btnDeleteSensor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					 RegistationInterface dbq =(RegistationInterface)Naming.lookup("rmi://localhost:1061/db");
				DefaultTableModel dtm =(DefaultTableModel) table.getModel();
				//System.out.print(jtable1.getSelectedRow());
				int i = table.getSelectedRow();
				
				
				String sensorid = (String)table.getValueAt(i, 0);
				
				
				String delete=dbq.delete(sensorid);
					
				
				JOptionPane.showMessageDialog(null, delete, "success", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Invalid Delete",
					"delete erroe..!", JOptionPane.ERROR_MESSAGE);
		}
	
				Admin.this.dispose();
        		new Admin().setVisible(true);	
				
			}
		});
		btnDeleteSensor.setForeground(Color.BLACK);
		btnDeleteSensor.setFont(new Font("Tekton Pro Ext", Font.BOLD, 30));
		btnDeleteSensor.setBackground(new Color(255, 255, 204));
		btnDeleteSensor.setBounds(788, 511, 262, 53);
		contentPane.add(btnDeleteSensor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 617);
		contentPane.add(lblNewLabel);
	}




	

	

	
	
	static String[][] tableshow() {
		try {
			URL url = new URL("http://localhost:5000/api/sensor");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;

				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}

				JSONObject json = new JSONObject(response.toString());



				JSONArray sensors = json.getJSONObject("data").getJSONArray("sensor");
				JSONArray datas = new JSONArray();
				
				JSONArray obj = new JSONArray();
				JSONArray floor = new JSONArray();
				JSONArray room = new JSONArray();
				JSONArray owner = new JSONArray();
				

				for (int i = 0; i < sensors.length(); i++) {
					
					

					datas.put(sensors.getJSONObject(i).getJSONArray("SensorData"));
				//	datas.put(sensors.getJSONObject(i).getJSONObject("Location"));
					obj.put(sensors.getJSONObject(i).getJSONObject("Location"));
					floor.put(sensors.getJSONObject(i).getJSONObject("Floor"));
					room.put(sensors.getJSONObject(i).getJSONObject("Room"));
				owner.put(sensors.getJSONObject(i).getJSONObject("User"));
					
//					System.out.println(datas);
//					System.out.println(obj);
				}
				String[][] d = new String[datas.length()][9];
	//			"Sensor ID", "RoomNo", "OwnerId", "LocationNo", "FloorNo", "SensorName"

				for (int j = 0; j < d.length; j++) {
					d[j][0] = String.valueOf(datas.getJSONArray(j).getJSONObject(0).getInt("sensorId"));
					d[j][1] = String.valueOf(room.getJSONObject(j).getInt("id"));
					d[j][2] = String.valueOf(owner.getJSONObject(j).getInt("id"));
					d[j][3] = String.valueOf(obj.getJSONObject(j).getInt("id"));
					d[j][4] = String.valueOf(floor.getJSONObject(j).getInt("id"));
					d[j][5] = String.valueOf(sensors.getJSONObject(j).getString("name"));
					d[j][6] = String.valueOf(sensors.getJSONObject(j).getInt("status"));
					
					d[j][7] = String.valueOf(datas.getJSONArray(j).getJSONObject(0).getInt("co2Level"));
					d[j][8] = String.valueOf(datas.getJSONArray(j).getJSONObject(0).getInt("smokeLevel"));
					
				
					
				}
				
				return d;

			}

		} catch (Exception e) {
			System.out.println(e);
			// return (e.toString());

		}
		return null;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
