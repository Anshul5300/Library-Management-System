import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Table {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(12, 45, 1008, 415);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("show ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
		String dbName="library";
		String driverName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/";
		
				
		try
		{
			
		 Class.forName(driverName);
		String query="select * from bookdb";
		Connection con=(Connection) DriverManager.getConnection(url+dbName,"root","root");
		Statement st=(Statement) con.createStatement();
		
		ResultSet rs=st.executeQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		
		
		}
		
		catch(Exception ex) 
		{
			
		ex.printStackTrace();
		
		}
		}
				
				
				
				
				
	
		});
		btnNewButton.setBounds(402, 488, 116, 43);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("bookname");
		lblNewLabel.setBounds(29, 13, 97, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(354, 20, 56, 16);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(726, 20, 56, 16);
		frame.getContentPane().add(lblQuantity);
	}
}
