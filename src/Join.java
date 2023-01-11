import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.swing.JRadioButton;

public class Join extends JDialog {

	private static Font font = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfJoinId;
	private JTextField tfJoinPw;
	private JTextField tfJoinName;
	private JTextField tfJoinAddress;
	private JTextField tfJoinEmail1;
	private JTextField tfJoinPhone1;
	private JTextField tfJoinPhone2;
	private JTextField tfJoinPhone3;
	private JTextField tfJoinEmail2;
	private JComboBox cbPhone;
	private JTextField tfBirth;
	private ButtonGroup group;
	private String result;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Join dialog = new Join();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Join() {
		setBounds(100, 100, 450, 462);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("회원가입");
			lblNewLabel.setBounds(27, 10, 64, 32);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblJionId = new JLabel("아이디");
		lblJionId.setBounds(27, 55, 57, 15);
		contentPanel.add(lblJionId);
		
		tfJoinId = new JTextField();
		tfJoinId.setBounds(96, 52, 168, 21);
		contentPanel.add(tfJoinId);
		tfJoinId.setColumns(10);
		
		JLabel lblJoinPw = new JLabel("비밀번호");
		lblJoinPw.setBounds(27, 90, 57, 15);
		contentPanel.add(lblJoinPw);
		
		tfJoinPw = new JTextField();
		tfJoinPw.setColumns(10);
		tfJoinPw.setBounds(96, 87, 168, 21);
		contentPanel.add(tfJoinPw);
		
		JLabel lblJoinName = new JLabel("이름");
		lblJoinName.setBounds(27, 121, 57, 15);
		contentPanel.add(lblJoinName);
		
		tfJoinName = new JTextField();
		tfJoinName.setColumns(10);
		tfJoinName.setBounds(96, 118, 168, 21);
		contentPanel.add(tfJoinName);
		
		JLabel lblJoinAddress = new JLabel("주소");
		lblJoinAddress.setBounds(27, 194, 57, 15);
		contentPanel.add(lblJoinAddress);
		
		tfJoinAddress = new JTextField();
		tfJoinAddress.setColumns(10);
		tfJoinAddress.setBounds(96, 191, 275, 53);
		contentPanel.add(tfJoinAddress);
		
		JLabel lblNewLabel_1_4 = new JLabel("모바일");
		lblNewLabel_1_4.setBounds(27, 257, 57, 15);
		contentPanel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("이메일");
		lblNewLabel_1_5.setBounds(27, 290, 57, 15);
		contentPanel.add(lblNewLabel_1_5);
		
		tfJoinEmail1 = new JTextField();
		tfJoinEmail1.setColumns(10);
		tfJoinEmail1.setBounds(96, 287, 116, 21);
		contentPanel.add(tfJoinEmail1);
		
		cbPhone = new JComboBox();
		cbPhone.setModel(new DefaultComboBoxModel(new String[] {"SKT", "LGU+", "KT"}));
		cbPhone.setBounds(96, 254, 64, 23);
		contentPanel.add(cbPhone);
		
		tfJoinPhone1 = new JTextField();
		tfJoinPhone1.setBounds(164, 254, 57, 21);
		contentPanel.add(tfJoinPhone1);
		tfJoinPhone1.setColumns(10);
		
		tfJoinPhone2 = new JTextField();
		tfJoinPhone2.setColumns(10);
		tfJoinPhone2.setBounds(239, 254, 57, 21);
		contentPanel.add(tfJoinPhone2);
		
		tfJoinPhone3 = new JTextField();
		tfJoinPhone3.setColumns(10);
		tfJoinPhone3.setBounds(314, 254, 57, 21);
		contentPanel.add(tfJoinPhone3);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setBounds(228, 257, 17, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("-");
		lblNewLabel_1_1.setBounds(301, 257, 17, 15);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("@");
		lblNewLabel_2.setBounds(224, 290, 28, 15);
		contentPanel.add(lblNewLabel_2);
		
		tfJoinEmail2 = new JTextField();
		tfJoinEmail2.setBounds(249, 287, 116, 21);
		contentPanel.add(tfJoinEmail2);
		tfJoinEmail2.setColumns(10);
		
		JButton btnJoinOk = new JButton("가입신청");
		btnJoinOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Join();
			}
		});
	
		btnJoinOk.setBounds(96, 379, 97, 23);
		contentPanel.add(btnJoinOk);
		
		JButton btnJoinFail = new JButton("가입취소");
		btnJoinFail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJoinFail.setBounds(239, 379, 97, 23);
		contentPanel.add(btnJoinFail);
		
	
		
		group = new ButtonGroup();
		
		
		
		JLabel lblsex = new JLabel("\uC131\uBCC4");
		lblsex.setBounds(27, 330, 57, 15);
		contentPanel.add(lblsex);
		
		JLabel lblNewLabel_3 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_3.setBounds(26, 154, 57, 15);
		contentPanel.add(lblNewLabel_3);
		
		tfBirth = new JTextField();
		tfBirth.setText("ex)850214");
		tfBirth.setBounds(96, 149, 168, 21);
		contentPanel.add(tfBirth);
		tfBirth.setColumns(10);
		
		JRadioButton raMale = new JRadioButton("남성");
		
		raMale.setFont(font); 
		group.add(raMale);
		raMale.setBounds(99, 326, 64, 23);
		contentPanel.add(raMale);
		
		JRadioButton raFemale = new JRadioButton("여성");
		raMale.setSelected(true);
		raFemale.setFont(font);
		group.add(raFemale);
		raFemale.setBounds(184, 326, 113, 23);
		contentPanel.add(raFemale);
		
		
			if(raMale.isSelected()) {
				result = "남성";
			} else if (raFemale.isSelected())
				result = "여성";
	}

	
	protected void Join() {
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = 
						DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/hospital",
								"root",
								"12345");
				Statement stmt = con.createStatement();
				System.out.println(result);
				
				String sql = "INSERT INTO hlogin(id,pw,name,birth,address,phonecompany,phone1,phone2,phone3,email1,email2,gender,joindate) values('";
				sql = sql + tfJoinId.getText() + "','";
				sql = sql + tfJoinPw.getText() + "','" + tfJoinName.getText() + "','" + tfBirth.getText() + "','" + tfJoinAddress.getText() + "','";
				sql = sql + cbPhone.getSelectedItem() + "','" + tfJoinPhone1.getText() + "','";
				sql = sql + tfJoinPhone2.getText() + "','" + tfJoinPhone3.getText() + "','";
				sql = sql + tfJoinEmail1.getText() + "','" + tfJoinEmail2.getText() + "','"+result+"',CURRENT_TIME())";
				
				
				
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
