package FireAlarm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class sms extends JFrame implements Runnable{
	
	
	@Override
	public void run() {
//	 TODO Auto-generated method stub

		while (true) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
			
				//	  JOptionPane.showMessageDialog(null, new JScrollPane(getNewRenderedTable(getTable())));
					try {
						sms frame = new sms();
						frame.setVisible(true);
				
						table();
						
					
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			try {

				// setVisible(false);
				Thread.sleep(15000);
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
	private JTextField txtMessageInbox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		sms m1 = new sms();
		Thread t1 = new Thread(m1);
		t1.start();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					sms frame = new sms();
//					frame.setVisible(true);
////					table();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public sms() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 147, 709, 295);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 41, 685, 201);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 153));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SMS Sensor IDs"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		scrollPane.setViewportView(table);
		
		txtMessageInbox = new JTextField();
		txtMessageInbox.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 38));
		txtMessageInbox.setBackground(new Color(255, 204, 153));
		txtMessageInbox.setEditable(false);
		txtMessageInbox.setText("         Messages");
		txtMessageInbox.setBounds(172, 53, 387, 55);
		contentPane.add(txtMessageInbox);
		txtMessageInbox.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(sms.class.getResource("/Attendance/e4d33bf1eb5d1621b5f283601f12c1b6.jpg")));
		lblNewLabel.setBounds(0, 0, 733, 458);
		contentPane.add(lblNewLabel);
	}
	
	
	static String table() {
		
		try {
			

		  
		
		    RegistationInterface dbq =(RegistationInterface)Naming.lookup("rmi://localhost:1061/db");
			
		   ArrayList<String>  gg=dbq.sms();
			DefaultTableModel hh =(DefaultTableModel) table.getModel();
				
	
					Vector vv=new Vector();
					
					
					vv.add(gg);
					
					hh.addRow(vv);
					
					
					
					
				
//				System.out.println(gg);
//				System.out.println(gg);
			
		//	JOptionPane.showMessageDialog(null, locationinsert, "success", JOptionPane.INFORMATION_MESSAGE);
		
		
			
			}catch(Exception e1) {
				e1.printStackTrace();
			}

		
		

		
		
		
		return null;
		
		
		
		
	}


	
}
