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

public class Reservation extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reservation dialog = new Reservation("test","홍길동");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reservation(String strID, String strName) {
		setTitle("\uC608\uC57D\uD558\uAE30");
		setBounds(100, 100, 450, 349);
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
		lblNewLabel_1.setBounds(57, 102, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		tfContent = new JTextField();
		tfContent.setBounds(136, 99, 230, 115);
		contentPanel.add(tfContent);
		tfContent.setColumns(10);
		
		JLabel lblDATE = new JLabel("2022");
		lblDATE.setBounds(136, 45, 158, 30);
		contentPanel.add(lblDATE);
		
		JLabel lblNewLabel_2 = new JLabel("\uB2D8\uC758 \uC9C4\uB8CC\uC608\uC57D\uC774");
		lblNewLabel_2.setBounds(84, 10, 101, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uB204\uAD6C");
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
		btnNewButton.setBounds(94, 256, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB3CC\uC544\uAE30\uAE30");
		btnNewButton_1.setBounds(245, 256, 97, 23);
		contentPanel.add(btnNewButton_1);
	}

	protected void reservation(String strID, String strName) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO reservationtbl(id,content,rdate) values(strID,'";
			sql = sql + strID + "','";
			sql = sql +  tfContent.getText() + "', CURRENT_TIME())";
			
			System.out.println(sql);
			
			if(stmt.executeUpdate(sql)>0)
				JOptionPane.showMessageDialog(null, "정상 입력 완료");
					
			else
				JOptionPane.showMessageDialog(null, "오류입니다");
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
}
