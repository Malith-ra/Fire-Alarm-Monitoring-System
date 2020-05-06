package FireAlarm;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import Staff.Salary;
import Staff.attendance;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class sensorfulldatashow extends JFrame implements Runnable{

	 static JTable getNewRenderedTable(final JTable table) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int col) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
				String status = (String) table.getValueAt(row, 1);
				String co2 = (String) table.getValueAt(row, 2);
				if ("6".equals(status)||"7".equals(status)||"8".equals(status)||"9".equals(status)||"10".equals(status)||"6".equals(co2)||"7".equals(co2)||"8".equals(co2)||"9".equals(co2)||"10".equals(co2)) {
					setBackground(Color.RED);
					setForeground(Color.WHITE);
				} else {
					setBackground(table.getBackground());
					setForeground(table.getForeground());
				}
				return this;
			}
		});
		return table;
	}

	@Override
	public void run() {
//	 TODO Auto-generated method stub

		while (true) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
			
				//	  JOptionPane.showMessageDialog(null, new JScrollPane(getNewRenderedTable(getTable())));
					try {
						sensorfulldatashow frame = new sensorfulldatashow();
						frame.setVisible(true);
					//	skkk();
						
//						sms frame1 = new sms();
//						frame1.setVisible(true);
						
						// loadDatatotable();
						DefaultTableModel dtm = (DefaultTableModel) table.getModel();
						
						String[][] data = tableshow();

						for (int i = 0; i < data.length; i++) {
							dtm.addRow(data[i]);
						}
						

						
						getNewRenderedTable(table);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			try {

				// setVisible(false);
				Thread.sleep(30000);
			setVisible(false);

				// setVisible(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtSensorData;

	/**
	 * Launch the application.
	 */

//	
//	static void skkk() {
//	
//	int i = 0;
//	int status = (int) table.getValueAt(1, 8);
//	
//	if(status==0) {
//		table.setBackground(Color.BLACK);
//         table.setForeground(Color.WHITE);
//		
//		
//	}
//	}
//	

	public static void main(String[] args) {

		sensorfulldatashow m1 = new sensorfulldatashow();
		Thread t1 = new Thread(m1);
		t1.start();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
//				try {
//					sensorfulldatashow frame = new sensorfulldatashow();
//					frame.setVisible(true);
//					// loadDatatotable();
//					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
//					String[][] data = tableshow();
//
//					for (int i = 0; i < data.length; i++) {
//						dtm.addRow(data[i]);
//						
//						 getNewRenderedTable(table);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sensorfulldatashow() {
		sensorfulldatashow.this.setTitle("User Sensor Status");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(56, 137, 964, 467);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 939, 441);
		panel.add(scrollPane);

		table = new JTable();
		table.setBorder(UIManager.getBorder("DesktopIcon.border"));
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"sensor id", "SmokeLevel", "Co2", "Location Name", "Floor NO", "RoomNo", "Status(Active)"
			}
		));
		scrollPane.setViewportView(table);
//		table.setBackground(Color.BLACK);
//         table.setForeground(Color.WHITE);

		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				setVisible(false);
				MainFire list = new MainFire();
				list.setVisible(true);
				setVisible(false);

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setFont(new Font("Tekton Pro Ext", Font.BOLD, 26));
		btnNewButton.setBounds(829, 36, 127, 51);
		contentPane.add(btnNewButton);

		txtSensorData = new JTextField();
		txtSensorData.setEditable(false);
		txtSensorData.setFont(new Font("Tekton Pro Ext", Font.BOLD, 26));
		txtSensorData.setBounds(276, 36, 347, 71);
		contentPane.add(txtSensorData);
		txtSensorData.setBackground(new Color(255, 204, 102));
		txtSensorData.setText("Fire Alarm Sensor Data");
		txtSensorData.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				sensorfulldatashow.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 617);
		contentPane.add(lblNewLabel);
	}

//	static void loadDatatotable() {
//		
//		try {
//			
//			String  id = null, Status = null, Co2 = null, SmokeLevel = null, LocationName = null, FloorName = null, UserName = null;
//		
//			
//		String rid=null, oid=null, lid=null,fid=null, name=null, create=null,up=null, delete=null, uid=null, fn=null, ln=null, em=null, pn=null, idr=null,
//			 nr=null, rno=null, nfse=null, fido=null, fnme=null, ffno=null, rmm=null, lidd=null, namel=null,
//			 add=null, nflors=null,
//			 dateid=null, ssid=null, col=null,smoke=null;
//		    RegistationInterface dbq =(RegistationInterface)Naming.lookup("rmi://localhost:1061/db");
//			
//			String showdata1=dbq.showdata(id, Status, Co2, SmokeLevel, LocationName, FloorName, UserName);
//				
//			
//			JOptionPane.showMessageDialog(null, showdata1, "success", JOptionPane.INFORMATION_MESSAGE);
//			
//		//	setVisible(false);
////			RoomClient location =new RoomClient();
////			location.setVisible(true);
//			
//			}catch(Exception e1) {
//				e1.printStackTrace();
//			}
//
//		
//		
//	}

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
				JSONArray status = new JSONArray();

				for (int i = 0; i < sensors.length(); i++) {

					datas.put(sensors.getJSONObject(i).getJSONArray("SensorData"));
					// datas.put(sensors.getJSONObject(i).getJSONObject("Location"));
					obj.put(sensors.getJSONObject(i).getJSONObject("Location"));
					floor.put(sensors.getJSONObject(i).getJSONObject("Floor"));
					room.put(sensors.getJSONObject(i).getJSONObject("Room"));
					// status.put(sensors.getJSONObject(i).getJSONObject("status"));

//					System.out.println(datas);
//					System.out.println(obj);
				}
				String[][] d = new String[datas.length()][7];

				for (int j = 0; j < d.length; j++) {
					d[j][0] = String.valueOf(datas.getJSONArray(j).getJSONObject(0).getInt("sensorId"));
					d[j][1] = String.valueOf(datas.getJSONArray(j).getJSONObject(0).getInt("smokeLevel"));
					d[j][2] = String.valueOf(datas.getJSONArray(j).getJSONObject(0).getInt("co2Level"));
					d[j][3] = String.valueOf(obj.getJSONObject(j).getString("name"));
					d[j][4] = String.valueOf(floor.getJSONObject(j).getInt("floorNo"));
					d[j][5] = String.valueOf(room.getJSONObject(j).getInt("roomNo"));
					d[j][6] = String.valueOf(sensors.getJSONObject(j).getInt("status"));

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
