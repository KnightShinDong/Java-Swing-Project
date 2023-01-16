import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Search_IdPw extends JDialog {

	private final JPanel search = new JPanel();
	private JTextField tfSIdName;
	private JTextField tfSIdEmail1;
	private JTextField tfSIdPhone1;
	private JTextField tfSIdPhone2;
	private JTextField tfSIdPhone3;
	private JTextField tfSIdEmail2;
	private JTextField tfSPwName;
	private JTextField tfSPwEmail1;
	private JTextField tfSPwPhone1;
	private JTextField tfSPwPhone2;
	private JTextField tfSPwPhone3;
	private JTextField tfSPwEmail2;
	private JTextField tfSPwId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Search_IdPw dialog = new Search_IdPw();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Search_IdPw() {
		setBounds(100, 100, 450, 474);
		getContentPane().setLayout(new BorderLayout());
		search.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(search, BorderLayout.CENTER);
		search.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514\uCC3E\uAE30");
			lblNewLabel.setBounds(24, 10, 98, 22);
			search.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
			lblNewLabel_1.setBounds(24, 62, 57, 15);
			search.add(lblNewLabel_1);
		}
		{
			tfSIdName = new JTextField();
			tfSIdName.setBounds(93, 62, 116, 21);
			search.add(tfSIdName);
			tfSIdName.setColumns(10);
		}
		{
			JLabel lblNewLabel_1_4 = new JLabel("\uBAA8\uBC14\uC77C");
			lblNewLabel_1_4.setBounds(24, 96, 57, 15);
			search.add(lblNewLabel_1_4);
		}
		{
			JLabel lblNewLabel_1_5 = new JLabel("\uC774\uBA54\uC77C");
			lblNewLabel_1_5.setBounds(24, 129, 57, 15);
			search.add(lblNewLabel_1_5);
		}
		{
			tfSIdEmail1 = new JTextField();
			tfSIdEmail1.setColumns(10);
			tfSIdEmail1.setBounds(93, 126, 116, 21);
			search.add(tfSIdEmail1);
		}
		{
			tfSIdPhone1 = new JTextField();
			tfSIdPhone1.setColumns(10);
			tfSIdPhone1.setBounds(93, 95, 57, 21);
			search.add(tfSIdPhone1);
		}
		{
			tfSIdPhone2 = new JTextField();
			tfSIdPhone2.setColumns(10);
			tfSIdPhone2.setBounds(168, 95, 57, 21);
			search.add(tfSIdPhone2);
		}
		{
			tfSIdPhone3 = new JTextField();
			tfSIdPhone3.setColumns(10);
			tfSIdPhone3.setBounds(243, 95, 57, 21);
			search.add(tfSIdPhone3);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("-");
			lblNewLabel_1.setBounds(157, 98, 17, 15);
			search.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1_1 = new JLabel("-");
			lblNewLabel_1_1.setBounds(230, 98, 17, 15);
			search.add(lblNewLabel_1_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("@");
			lblNewLabel_2.setBounds(221, 129, 28, 15);
			search.add(lblNewLabel_2);
		}
		{
			tfSIdEmail2 = new JTextField();
			tfSIdEmail2.setColumns(10);
			tfSIdEmail2.setBounds(246, 126, 116, 21);
			search.add(tfSIdEmail2);
		}
		{
			JLabel lblQlalfqjsghckwrl = new JLabel("\uBE44\uBC00\uBC88\uD638\uCC3E\uAE30");
			lblQlalfqjsghckwrl.setBounds(24, 239, 98, 22);
			search.add(lblQlalfqjsghckwrl);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
			lblNewLabel_1.setBounds(24, 328, 57, 15);
			search.add(lblNewLabel_1);
		}
		{
			tfSPwName = new JTextField();
			tfSPwName.setColumns(10);
			tfSPwName.setBounds(93, 328, 116, 21);
			search.add(tfSPwName);
		}
		{
			JLabel lblNewLabel_1_4 = new JLabel("\uBAA8\uBC14\uC77C");
			lblNewLabel_1_4.setBounds(24, 362, 57, 15);
			search.add(lblNewLabel_1_4);
		}
		{
			JLabel lblNewLabel_1_5 = new JLabel("\uC774\uBA54\uC77C");
			lblNewLabel_1_5.setBounds(24, 395, 57, 15);
			search.add(lblNewLabel_1_5);
		}
		{
			tfSPwEmail1 = new JTextField();
			tfSPwEmail1.setColumns(10);
			tfSPwEmail1.setBounds(93, 392, 116, 21);
			search.add(tfSPwEmail1);
		}
		{
			tfSPwPhone1 = new JTextField();
			tfSPwPhone1.setColumns(10);
			tfSPwPhone1.setBounds(93, 359, 57, 21);
			search.add(tfSPwPhone1);
		}
		{
			tfSPwPhone2 = new JTextField();
			tfSPwPhone2.setColumns(10);
			tfSPwPhone2.setBounds(168, 359, 57, 21);
			search.add(tfSPwPhone2);
		}
		{
			tfSPwPhone3 = new JTextField();
			tfSPwPhone3.setColumns(10);
			tfSPwPhone3.setBounds(243, 359, 57, 21);
			search.add(tfSPwPhone3);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("-");
			lblNewLabel_1.setBounds(157, 362, 17, 15);
			search.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1_1 = new JLabel("-");
			lblNewLabel_1_1.setBounds(230, 362, 17, 15);
			search.add(lblNewLabel_1_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("@");
			lblNewLabel_2.setBounds(221, 395, 28, 15);
			search.add(lblNewLabel_2);
		}
		{
			tfSPwEmail2 = new JTextField();
			tfSPwEmail2.setColumns(10);
			tfSPwEmail2.setBounds(246, 392, 116, 21);
			search.add(tfSPwEmail2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("---------------");
			lblNewLabel_3.setBounds(12, 37, 98, 15);
			search.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("-----------------------------------------------------------------");
			lblNewLabel_3.setBounds(12, 187, 410, 15);
			search.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("---------------");
			lblNewLabel_3.setBounds(12, 266, 98, 15);
			search.add(lblNewLabel_3);
		}
		{
			JLabel lblJionId = new JLabel("\uC544\uC774\uB514");
			lblJionId.setBounds(22, 294, 57, 15);
			search.add(lblJionId);
		}
		{
			tfSPwId = new JTextField();
			tfSPwId.setColumns(10);
			tfSPwId.setBounds(91, 291, 168, 21);
			search.add(tfSPwId);
		}
		{
			JButton btnSId = new JButton("\uC544\uC774\uB514\uCC3E\uAE30");
			btnSId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					SearchId();
				}
			});
			btnSId.setBounds(302, 33, 97, 23);
			search.add(btnSId);
		}
		{
			JButton btnSPw = new JButton("\uBE44\uBC88\uCC3E\uAE30");
			btnSPw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					SearchPw();
					
				}
			});
			btnSPw.setBounds(302, 262, 97, 23);
			search.add(btnSPw);
		}
	}
	//아이디 비밀번호 찾기
	protected void SearchPw() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();
			String sql = "SELECT id FROM hlogin ";
			sql = sql + "where id= '" + tfSPwId.getText() +"' and name='" + tfSPwName.getText();
			sql = sql + "' and phone1='" + tfSPwPhone1.getText() + "' and phone2='" + tfSPwPhone2.getText();
			sql = sql + "' and phone3='" + tfSPwPhone3.getText() + "' and email1='" + tfSPwEmail1.getText();
			sql = sql + "' and email2='" + tfSPwEmail2.getText() + "'";
			
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				
				String strId, strPw;
				strPw = rs.getString("pw");
				strId = tfSPwId.getText();
				
				JOptionPane.showMessageDialog(null, strId+"님의 비밀번호는 "+strPw+" 입니다.");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "비밀번호찾기 실패! 정확하게 입력해주세요.");
				tfSIdName.requestFocus();
			}					
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
	
	}

	protected void SearchId() {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();
			String sql = "SELECT id FROM hlogin ";
			sql = sql + "where name='" + tfSIdName.getText();
			sql = sql + "' and phone1='" + tfSIdPhone1.getText() + "' and phone2='" + tfSIdPhone2.getText();
			sql = sql + "' and phone3='" + tfSIdPhone3.getText() + "' and email1='" + tfSIdEmail1.getText();
			sql = sql + "' and email2='" + tfSIdEmail2.getText() + "'";
			
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				
				String strName, strID;
				strID = rs.getString("id");
				strName = tfSIdName.getText();
				
				JOptionPane.showMessageDialog(null, strName+"님의 아이디는 "+strID+" 입니다.");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "아이디찾기 실패! 정확하게 입력해주세요.");
				tfSIdName.requestFocus();
			}					
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
	}

}
