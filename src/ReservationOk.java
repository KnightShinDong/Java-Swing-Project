import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReservationOk extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfcontent2;
	int ridx;
	private JTextField textField;
	private JTextField tfContent;
	private JTextField tfrdate;
	JComboBox comboBox;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ReservationOk(String checkOk,String strID,String strName) {
		setBounds(100, 100, 450, 394);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC99D\uC0C1");
		lblNewLabel_1.setBounds(109, 179, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		tfcontent2 = new JTextField();
		tfcontent2.setBounds(189, 179, 179, 61);
		contentPanel.add(tfcontent2);
		tfcontent2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(strName);
		lblNewLabel_2.setBounds(26, 10, 86, 33);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("-------------------------------------------------------------------");
		lblNewLabel_6.setBounds(12, 71, 410, 15);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3_1 = new JLabel("\uBCC0\uACBD");
		lblNewLabel_3_1.setBounds(38, 132, 50, 76);
		contentPanel.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("\uBCC0\uACBD\uC644\uB8CC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Modify();
				
				Home home = new Home(strName, strName);	
				setVisible(false);
				home.ContentList(strID, strName);
				home.setModal(true);
				home.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(82, 269, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBounds(210, 269, 97, 23);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("\uB0A0\uC9DC");
		lblNewLabel_7.setBounds(110, 105, 57, 15);
		contentPanel.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(190, 102, 80, 21);
		contentPanel.add(textField);
		
		JButton btnNewButton_2 = new JButton("...");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				WinCalendar winCalendar = new WinCalendar();	
				winCalendar.setModal(true);
				winCalendar.setVisible(true);				
				textField.setText(winCalendar.getDate());
			}
		});
		btnNewButton_2.setBounds(278, 101, 45, 23);
		contentPanel.add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("\uC2DC\uAC04");
		lblNewLabel_8.setBounds(108, 149, 57, 15);
		contentPanel.add(lblNewLabel_8);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30"}));
		comboBox.setBounds(187, 145, 134, 23);
		contentPanel.add(comboBox);
		
		checkOk(strID);
	}
	
	
	
	//예약 수정
	protected void Modify() {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();
			
			String sql = "UPDATE reservationtbl SET content='"+tfcontent2.getText()+"', rdate='"+textField.getText()+"' ,rtime = '"+comboBox.getSelectedItem()+"' WHERE ridx= '"+ridx+"'";
			
	
			
			if(stmt.executeUpdate(sql) >0)
				JOptionPane.showMessageDialog(null, "정상 입력 완료");
					
			else
				JOptionPane.showMessageDialog(null, "오류입니다");
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

	//예약보기 
	private void checkOk (String strID) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();			
			String sql = "";
			sql = "select H.name, R.*";
			sql = sql + " from reservationtbl R";
			sql = sql + " inner join hlogin H";
			sql = sql + " on H.id = R.id";
			
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
			String rdate = rs.getString("R.rdate");
			textField.setText(rdate);
			String rtime = rs.getString("R.rtime");
			comboBox.setSelectedItem(rtime);
			String content = rs.getString("R.content");
			tfcontent2.setText(content);
			ridx = rs.getInt("R.ridx");
			
			}
		
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}
