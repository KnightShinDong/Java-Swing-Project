import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Reservation extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfContent;
	private JTextField tfrdate;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Reservation(String strID, String strName) {
		setTitle("\uC608\uC57D\uD558\uAE30");
		setBounds(100, 100, 450, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\uB0A0\uC9DC");
			lblNewLabel.setBounds(57, 53, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("\uC99D\uC0C1");
		lblNewLabel_1.setBounds(57, 147, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		tfContent = new JTextField();
		tfContent.setBounds(136, 144, 230, 115);
		contentPanel.add(tfContent);
		tfContent.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uB2D8\uC758 \uC9C4\uB8CC\uC608\uC57D\uC774");
		lblNewLabel_2.setBounds(84, 10, 101, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(strName);
		lblNewLabel_3.setBounds(30, 10, 45, 15);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uBA87");
		lblNewLabel_4.setBounds(182, 10, 31, 15);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uAC74 \uC788\uC2B5\uB2C8\uB2E4..");
		lblNewLabel_5.setBounds(213, 10, 126, 15);
		contentPanel.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("\uC608\uC57D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				reservation(strID, strName);
			}
		});
		btnNewButton.setBounds(94, 301, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB3CC\uC544\uAE30\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home home = new Home(strID, strName);
				setVisible(false);
				home.setModal(true);
				home.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(245, 301, 97, 23);
		contentPanel.add(btnNewButton_1);
		
		tfrdate = new JTextField();
		tfrdate.setBounds(137, 50, 80, 21);
		contentPanel.add(tfrdate);
		tfrdate.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("...");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WinCalendar winCalendar = new WinCalendar();	
				winCalendar.setModal(true);
				winCalendar.setVisible(true);				
				tfrdate.setText(winCalendar.getDate());
				
				
			}
		});
		btnNewButton_2.setBounds(225, 49, 45, 23);
		contentPanel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\uC2DC\uAC04");
		lblNewLabel.setBounds(57, 85, 57, 15);
		contentPanel.add(lblNewLabel);
		
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30"}));
		comboBox.setBounds(136, 81, 134, 23);
		contentPanel.add(comboBox);
		
	}

	protected void reservation(String strID,String strName) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO reservationtbl(id,content,rdate,rtime,checkflag) "
					+ "values('" + strID + "','" +  tfContent.getText() + "','"+ tfrdate.getText() + "',"
							+ "'"+  comboBox.getSelectedItem() + "', 1)";
			
				
				if(stmt.executeUpdate(sql)>0) {
				JOptionPane.showMessageDialog(null, "정상 입력 완료");
				
				}
					
			else
				JOptionPane.showMessageDialog(null, "오류입니다");
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
}
