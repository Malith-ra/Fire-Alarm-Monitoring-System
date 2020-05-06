package FireAlarm;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;

public interface RegistationInterface extends Remote{

	String insert(String fname, String lname, String email, String phonenumber, String pasword) throws RemoteException;

	String locationinsert(String id, String fname, String address, String noOfFloors) throws RemoteException;

	String floorinsert(String locationId, String floorName, String floorNo, String noOfRooms) throws RemoteException;

	String roominsert(String floorId, String roomName, String roomNo, String noOfSensors) throws RemoteException;

	
	
	String insertlogin(String email, String pass) throws RemoteException;

	String showdata(String id,String Status,String Co2,String SmokeLevel,String LocationName,String FloorName,String UserName)throws RemoteException;

	



	String editdetails(String sensorID, String roomId, String ownerId, String locationId, String floorId,String sensorName)throws RemoteException;

	String sensorinsert(String roomId, String ownerid, String locationId, String floorId, String name)throws RemoteException;

	ArrayList<String> sms() throws RemoteException;

	String delete(String sensorid) throws RemoteException;


	


	


	

	

	

	
	
}
