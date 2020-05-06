package FireAlarm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.fabric.Server;



public class RMIServer extends UnicastRemoteObject implements RegistationInterface, Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread is running...");
		while (true) {
			tableshow();
//			sms frame1 = new sms();
//			frame1.setVisible(true);
			
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	protected RMIServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String token;
	public static ArrayList<String> id;

	public static void main(String[] args) throws RemoteException {
		RMIServer m1 = new RMIServer();
		Thread t1 = new Thread(m1);
		t1.start();
		

		Registry reg = LocateRegistry.createRegistry(1061);

		RMIServer q = new RMIServer();
		reg.rebind("db", q);
		System.out.println("Server is right now...");
	}

	@Override
	public String insert(String fname, String lname, String email, String phonenumber, String pasword)
			throws RemoteException {

		try {
			URL url = new URL("http://localhost:5000/api/user");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");

			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);

			String jsonInputString = "{ \"firstName\":\"" + fname + "\" , \"lastName\":\"" + lname + "\" ,\"email\":\""
					+ email + "\",\"password\":\"" + pasword + "\",\"phoneNumber\":\"" + phonenumber + "\" }";
			System.out.println(jsonInputString);
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
				// System.out.println(os);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;

				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				// System.out.println(response);
			}

			return "Registation successfully";

		} catch (Exception e) {
			System.out.println(e);
			return (e.toString());

		}

	}

	@Override
	public String locationinsert(String id, String fname, String address, String noOfFloors) throws RemoteException {

		try {
			URL url = new URL("http://localhost:5000/api//location");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("x-auth-token", token);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			System.out.println(token);

			String jsonInputString = "{\"ownerId\":"+ id +",\"name\":\""+fname+"\",\"address\":\""+ address+"\",\"noOfFloors\":"+noOfFloors+"}";
			System.out.println(jsonInputString);
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
				// System.out.println(os);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;

				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				// System.out.println(response.append(i));
			}

			return "Location Added";

		} catch (Exception e) {
			System.out.println(e);
			return (e.toString());

		}

	}

	@Override
	public String floorinsert(String locationId, String floorName, String floorNo, String noOfRooms)
			throws RemoteException {

	

			try {
				URL url = new URL("http://localhost:5000/api/floor");

				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("x-auth-token", token);
				con.setRequestProperty("Content-Type", "application/json");
				con.setRequestProperty("Accept", "application/json");
				con.setDoOutput(true);
				System.out.println(token);

				String jsonInputString = "{\"locationId\":"+ locationId +",\"name\":\""+floorName+"\",\"floorNo\":"+ floorNo+",\"noOfRooms\":"+noOfRooms+"}";
				System.out.println(jsonInputString);
				try (OutputStream os = con.getOutputStream()) {
					byte[] input = jsonInputString.getBytes("utf-8");
					os.write(input, 0, input.length);
					// System.out.println(os);
				}

				try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
					StringBuilder response = new StringBuilder();
					String responseLine = null;

					while ((responseLine = br.readLine()) != null) {
						response.append(responseLine.trim());
					}
					 System.out.println(response);
				}

				return "Floor  Added";

			} catch (Exception e) {
				System.out.println(e);
				return (e.toString());
			}
			
		
	}

	@Override
	public String roominsert(String floorId, String roomName, String roomNo, String noOfSensors)
			throws RemoteException {

		try {
			URL url = new URL("http://localhost:5000/api/room");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("x-auth-token", token);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			System.out.println(token);

			String jsonInputString = "{\"floorId\":"+ floorId +",\"name\":\""+roomName+"\",\"roomNo\":"+ roomNo+",\"noOfSensors\":"+noOfSensors+"}";
			System.out.println(jsonInputString);
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
				// System.out.println(os);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;

				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				 System.out.println(response);
			}

			return "Room  Added";

		} catch (Exception e) {
			System.out.println(e);
			return (e.toString());
		}
		

	}

	@Override
	public String sensorinsert(String roomId, String ownerid, String locationId, String floorId, String name)
			throws RemoteException {

		try {
			URL url = new URL("http://localhost:5000/api/sensor");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("x-auth-token", token);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			System.out.println(token);

			String jsonInputString = "{\"roomId\":"+ roomId +",\"ownerId\":"+ownerid+",\"locationId\":"+ locationId+",\"floorId\":"+floorId+",\"name\":\""+name+ "\"}";
			System.out.println(jsonInputString);
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
				// System.out.println(os);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;

				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				 System.out.println(response);
			}

			return "Sensor  Added";

		} catch (Exception e) {
			System.out.println(e);
			return (e.toString());
		}
		

	}



	@Override
	public String insertlogin(String email, String pass) throws RemoteException {
		// TODO Auto-generated method stub

		try {
			URL url = new URL("http://localhost:5000/api/login");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");

			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);

			String jsonInputString = "{ \"email\":\"" + email + "\" , \"password\":\"" + pass + "\"}";

			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
				System.out.println(os);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;

				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}

				JSONObject json = new JSONObject(response.toString());
				JSONObject data = json.getJSONObject("data");
				token = (data.getString("token"));
				System.out.println(token);
			}

			// ResultSet rs=jsonInputString;

			return "Login Successfully";

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please Type Valid Login ", "Error", JOptionPane.ERROR_MESSAGE);
			return null;

		}

	}

	@Override
	public String showdata(String id, String Status, String Co2, String SmokeLevel, String LocationName,
			String FloorName, String UserName) {

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
				System.out.println(response.toString());

			}

			return "ko";

		} catch (Exception e) {
			System.out.println(e);
			return (e.toString());

		}

	}

	@Override
	public ArrayList<String> sms() throws RemoteException {

		
			return id;
		
	
	
		

	}



	static String tableshow() {
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

				for (int i = 0; i < sensors.length(); i++) {
					datas.put(sensors.getJSONObject(i).getJSONArray("SensorData"));

				}
				String[][] d = new String[datas.length()][3];
				ArrayList<String> tt = new ArrayList<String>();

				for (int j = 0; j < d.length; j++) {
					d[j][0] = String.valueOf(datas.getJSONArray(j).getJSONObject(0).getInt("sensorId"));
					d[j][1] = String.valueOf(datas.getJSONArray(j).getJSONObject(0).getInt("smokeLevel"));
					d[j][2] = String.valueOf(datas.getJSONArray(j).getJSONObject(0).getInt("co2Level"));

					if (((datas.getJSONArray(j).getJSONObject(0).getInt("smokeLevel")) > 5)
							|| ((datas.getJSONArray(j).getJSONObject(0).getInt("co2Level")) > 5)) {

						tt.add(d[j][0]);

						// System.out.println(id);

					}

				}

				if (tt.size() != 0) {
					Email();
					
		
				}

				id = tt;

			}

		} catch (Exception e) {
			System.out.println(e);

		}
		return null;

	}

// Email yawana eka

	static void Email() {

		final String username = "vimukthipasindu64@gmail.com";
		final String password = "pasindu@123";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vimukthipasindu64@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("vimukthipasindu64@gmail.com,vimukthipasindu64@gmail.com"));
			message.setSubject("Warning Message");
			message.setText("These Sensor ids sensor Id  Values  are Increased :" + id);

			Transport.send(message);

			System.out.println("Email Send");
			System.out.println("SMS Send");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String editdetails(String sensorID, String roomId, String ownerId, String locationId, String floorId,
			String sensorName) throws RemoteException {
		// TODO Auto-generated method stub

		try {
			URL url = new URL("http://localhost:5000/api/sensor");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("x-auth-token", token);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			//System.out.println(token);
			String jsonInputString = "{ \"sensorId\":" + sensorID + ",\"roomId\":" + roomId + ",\"ownerId\":" + ownerId
					+ ",\"locationId\":" + locationId + ",\"floorId\":" + floorId + ",\"name\":\"" + sensorName
					+ "\" }";
			System.out.println(jsonInputString);
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				System.out.println(response);
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
			//	System.out.println(response.toString());
			}

			return "Data Edited";

		} catch (Exception e) {
			System.out.println(e);
			return (e.toString());

		}
		// return null;
		// return (e.toString());
	}

	@Override
	public String delete(String sensorid) throws RemoteException {
		
		
		try {
			URL url = new URL("http://localhost:5000/api/sensor");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("DELETE");
			con.setRequestProperty("x-auth-token", token);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			//System.out.println(token);
			String jsonInputString = "{ \"sensorId\":" + sensorid +  " }";
			//System.out.println(jsonInputString);
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				System.out.println(response);
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
			//	System.out.println(response.toString());
			}

			return "Data Deleted";

		} catch (Exception e) {
			System.out.println(e);
			return (e.toString());

		}



	}
	
}


