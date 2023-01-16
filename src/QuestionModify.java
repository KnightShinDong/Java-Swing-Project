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

public class QuestionModify extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	private JTextField tfTitle;
	private JTextField tfQuestion;
	private JTextField tfPw;
	private int listidx;
	private String listPw;
	private JTextField tfComment;
	private String commentOk;
	private String id;
	
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public QuestionModify(String strID,String strName, String listPW,String checkOk, int listidx) {
		setBounds(100, 100, 450, 622);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
	if(!strID.equals("admin")&& strID.equals(id)) {
		if(commentOk == null) {
		JButton btnNewButton = new JButton("변경완료");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (listPW.equals(tfPw.getText())) {
				
				ListModify(strID, listPW, listidx);
				QuestionList questionList = new QuestionList(strID, strName);
				setVisible(false);
				questionList.setModal(true);
				questionList.setVisible(true);
				
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요");
					tfPw.setText("");
					tfPw.requestFocus();
				}
			}
		});
		btnNewButton.setBounds(79, 322, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QuestionList questionList = new QuestionList(strID, strName);
				setVisible(false);
				questionList.setModal(true);
				questionList.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(207, 322, 97, 23);
		contentPanel.add(btnNewButton_1);
	
		tfPw = new JTextField();
		tfPw.setBounds(159, 273, 116, 21);
		contentPanel.add(tfPw);
		tfPw.setColumns(10);
		
		JLabel lbpw = new JLabel("\uAE00 \uBE44\uBC00\uBC88\uD638");
		lbpw.setBounds(61, 276, 57, 15);
		contentPanel.add(lbpw);
		} else { 
			JButton btnNewButton = new JButton("변경완료");
			btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (listPW.equals(tfPw.getText())) {
				
				ListModify(strID, listPW,listidx);
				QuestionList questionList = new QuestionList(strID, strName);
				setVisible(false);
				questionList.setModal(true);
				questionList.setVisible(true);
				
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요");
					tfPw.setText("");
					tfPw.requestFocus();
				}
			}
		});
		btnNewButton.setBounds(79, 322, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QuestionList questionList = new QuestionList(strID, strName);
				setVisible(false);
				questionList.setModal(true);
				questionList.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(207, 322, 97, 23);
		contentPanel.add(btnNewButton_1);
	
		tfPw = new JTextField();
		tfPw.setBounds(159, 273, 116, 21);
		contentPanel.add(tfPw);
		tfPw.setColumns(10);
		
		JLabel lbpw = new JLabel("\uAE00 \uBE44\uBC00\uBC88\uD638");
		lbpw.setBounds(61, 276, 57, 15);
		contentPanel.add(lbpw);
		
		tfComment = new JTextField();
		tfComment.setBounds(79, 383, 294, 131);
		contentPanel.add(tfComment);
		tfComment.setColumns(10);	
			
		}	
			
		
	} else if (strID.equals("admin")){

			JLabel lblNewLabel_3 = new JLabel("\uB2F5\uBCC0");
			lblNewLabel_3.setBounds(40, 385, 57, 15);
			contentPanel.add(lblNewLabel_3);
			
			
			tfComment = new JTextField();
			tfComment.setBounds(79, 383, 294, 131);
			contentPanel.add(tfComment);
			tfComment.setColumns(10);
			JButton btnNewButton_2 = new JButton("\uB2F5\uBCC0");
			
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					CommentOk(listidx);
					QuestionList questionList = new QuestionList(strID, strName);
					setVisible(false);
					questionList.setModal(true);
					questionList.setVisible(true);
				}
			});
			
			
			
			btnNewButton_2.setBounds(89, 531, 97, 23);
			contentPanel.add(btnNewButton_2);
			
			
			JButton btnNewButton_3 = new JButton("\uCDE8\uC18C");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					QuestionList questionList = new QuestionList(strID, strName);
					setVisible(false);
					questionList.setModal(true);
					questionList.setVisible(true);
			
				}
			});
			btnNewButton_3.setBounds(234, 531, 97, 23);
			contentPanel.add(btnNewButton_3);
		
			
			
	

				
		}
			
		tfTitle = new JTextField();
		tfTitle.setBounds(159, 82, 214, 21);
		contentPanel.add(tfTitle);
		tfTitle.setColumns(10);
		
		tfQuestion = new JTextField();
		tfQuestion.setBounds(159, 147, 214, 112);
		contentPanel.add(tfQuestion);
		tfQuestion.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("\uC9C8\uBB38\uB0B4\uC6A9");
		lblNewLabel_1.setBounds(61, 166, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_2.setBounds(61, 85, 57, 15);
		contentPanel.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_4 = new JLabel("----------------------------------------------------------------");
		lblNewLabel_4.setBounds(30, 355, 392, 15);
		contentPanel.add(lblNewLabel_4);
		
		
		
		
		listCheckOk(strID);
	}
	
	
	
	//답변쓰기
	protected void CommentOk(int listidx) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();
			String sql = "UPDATE questionlist SET commentOk = '"+tfComment.getText()+"', listcheck = 2 WHERE listidx= listidx";
			if(stmt.executeUpdate(sql) >0)
				JOptionPane.showMessageDialog(null, "정상 입력 완료");
				
			
			else
				JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요");
				
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	//질문입력
	protected void ListModify(String strID, String listPW,int listidx) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();
			System.out.println(listidx);
			
			
			String sql = "UPDATE questionlist SET title='"+tfTitle.getText()+"', ldate= CURRENT_TIME() ,listcontent = '"+tfQuestion.getText()+"' WHERE listidx= '"+listidx+"'";
			if(stmt.executeUpdate(sql) >0)
				JOptionPane.showMessageDialog(null, "정상 입력 완료");
				
			
			else
				JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요");
				
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
	
	//문의사항 리스트
	private void listCheckOk (String strID) {
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
			sql = "select H.name, Q.*";
			sql = sql + " from questionlist Q";
			sql = sql + " inner join hlogin H";
			sql = sql + " on H.id = Q.id";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
			String title = rs.getString("Q.title");
			tfTitle.setText(title);
			String listcontent = rs.getString("Q.listcontent");
			tfQuestion.setText(listcontent);
			id = rs.getString("Q.id");
			listPw = rs.getString("Q.listpw");
			listidx = rs.getInt("Q.listidx");
			commentOk = rs.getString("Q.commentok");
			
			} 
			
			
			
		
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	
	}
}
