import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfLoginId;
	private JTextField tfLoginPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			login dialog = new login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public login() {
		setTitle("로그인");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			tfLoginId = new JTextField();
			tfLoginId.setBounds(102, 80, 116, 21);
			contentPanel.add(tfLoginId);
			tfLoginId.setColumns(10);
		}
		{
			JLabel lblLoginId = new JLabel("ID :");
			lblLoginId.setBounds(56, 83, 57, 15);
			contentPanel.add(lblLoginId);
		}
		{
			tfLoginPw = new JTextField();
			tfLoginPw.setColumns(10);
			tfLoginPw.setBounds(102, 135, 116, 21);
			contentPanel.add(tfLoginPw);
		}
		{
			JLabel lblLoginPw = new JLabel("PW :");
			lblLoginPw.setBounds(56, 138, 57, 15);
			contentPanel.add(lblLoginPw);
		}
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Go();
			}
		});
		
		btnLogin.setBounds(259, 79, 97, 74);
		contentPanel.add(btnLogin);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Join join  = new Join();
				setVisible(false);
				join.setModal(true);
				join.setVisible(true);	
				
				
			}
		});
		btnJoin.setBounds(259, 196, 97, 23);
		contentPanel.add(btnJoin);
		
		JLabel lblSearchId = new JLabel("아이디/비밀번호 찾기");
		lblSearchId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Search_IdPw search_IdPw = new Search_IdPw();
				setVisible(false);
				search_IdPw.setModal(true);
				search_IdPw.setVisible(true);
			}
		});
		
		lblSearchId.setBounds(56, 197, 134, 21);
		contentPanel.add(lblSearchId);
	}
	
	protected void Go() {
		// DB 연동
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();
			
			
			
			String sql = "SELECT name FROM hlogin ";
			sql = sql + "where id='" + tfLoginId.getText();
			sql = sql + "' and pw='" + tfLoginPw.getText()+"'";	
			
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				setVisible(false);
				String strName, strID;
				strID = tfLoginId.getText();
				strName = rs.getString("name");
				
				Home home = new Home(strID,strName);
				home.setModal(true);
				home.setVisible(true);
				Reservation reservation = new Reservation(strID, strName);
				
				System.exit(DISPOSE_ON_CLOSE);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "ID/PW 확인 요망");
				tfLoginId.requestFocus();
			}					
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
}
