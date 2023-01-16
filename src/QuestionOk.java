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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class QuestionOk extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public QuestionOk(String strID, String strName) {
		setTitle("\uC608\uC57D\uD558\uAE30");
		setBounds(100, 100, 450, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uC9C8\uBB38\uC644\uB8CC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QuestionOk(strID, strName);
				QuestionList questionList = new QuestionList(strID, strName);
				setVisible(false);
				questionList.setModal(true);
				questionList.setVisible(true);
			}
		});
		btnNewButton.setBounds(92, 355, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QuestionList questionList = new QuestionList(strID, strName);
				setVisible(false);
				questionList.setModal(true);
				questionList.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(246, 355, 97, 23);
		contentPanel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(149, 102, 116, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 178, 222, 88);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setBounds(48, 105, 57, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC9C8\uBB38\uB0B4\uC6A9");
		lblNewLabel_1.setBounds(48, 181, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						int length = textField_2.getText().length();
						if(length >= 4) {
							String value = 
									JOptionPane.showInputDialog("비밀번호 입력(확인)");
							if(textField_2.getText().equals(value)) {
								JOptionPane.showMessageDialog(null, "일치합니다");
								btnNewButton.setEnabled(true);
							}						
						}
						else {
							JOptionPane.showMessageDialog(null, "4글자 이상 비밀번호 입력해야 합니다");
							textField_2.setText("");
							textField_2.requestFocus();
						}
					}
				}
		});
		textField_2.setBounds(149, 304, 116, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uAE00 \uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setBounds(48, 307, 89, 15);
		contentPanel.add(lblNewLabel_2);
		
	}

	//문의사항 입력
	protected void QuestionOk(String strID,String strName) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO questionlist(id,title,listcontent,listpw,ldate,listcheck) "
					+ "values('" + strID + "','" +  textField.getText() + "','"+ textField_1.getText() + "','"+textField_2.getText()+"',CURRENT_TIME(), 1)";
			
				
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
