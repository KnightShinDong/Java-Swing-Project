import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.cj.Session;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuestionList extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String listPW;
	public int listidx;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public QuestionList(String strID, String strName) {
		setBounds(100, 100, 450, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 71, 378, 148);
		contentPanel.add(scrollPane);
		String columnNames[]= {"순번","제목","날짜","답변여부"};
		DefaultTableModel dtm = new DefaultTableModel(columnNames,0);
		table = new JTable(dtm);		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String checkOk = (String)table.getValueAt(row, 1);
				
				
				setVisible(false);
				QuestionModify modify = new QuestionModify(strID, strName,listPW,checkOk,listidx) ;
				modify.setModal(true);
				modify.setVisible(true);
			}
		});
		scrollPane.setViewportView(table);
		// 글꼴 선택(WindowBuilder -> Design - Properties)
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		// 셀 너비 조절
		int widths[] = { 5, 30, 10,5};		 
		for (int i=0; i<4; i++) {
		  TableColumn column = table.getColumnModel().getColumn(i);
		  column.setPreferredWidth( widths[i] );
		}
		// 셀 높이 조절
		table.setRowHeight(25);
		
		JButton btnNewButton = new JButton("문의하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QuestionOk questionOk= new QuestionOk(strID, strName);
				setVisible(false);
				questionOk.setModal(true);
				questionOk.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(98, 248, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 Home home = new Home(strName, strName);
			 setVisible(false);
			 home.setModal(true);
			 home.setVisible(true);	
			}
		});
		btnNewButton_1.setBounds(237, 248, 97, 23);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\uBB38\uC758 \uAC8C\uC2DC\uD310");
		lblNewLabel.setBounds(25, 10, 197, 34);
		contentPanel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("\uB0B4\uC9C8\uBB38\uBCF4\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Myquestion(strID, strName);
				
			}
		});
		btnNewButton_2.setBounds(294, 16, 97, 23);
		contentPanel.add(btnNewButton_2);
		// 셀 정렬
		DefaultTableCellRenderer cellAlignRight = new DefaultTableCellRenderer();
		cellAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumn("순번").setCellRenderer(cellAlignRight);		
		table.getColumn("날짜").setCellRenderer(cellAlignRight);
		
		ContentList(strID, strName);
		
	}
	
	//내질문 보기
	protected void Myquestion(String strID, String strName) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();	
			
			String sql = "SELECT * FROM questionlist where id='"+strID+"'";
			ResultSet rs = stmt.executeQuery(sql);			
			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			dtm.setRowCount(0);
			
			
			
			int cnt=0;
			while(rs.next()) {
				String record[] = new String[4];
				record[0] = Integer.toString(++cnt);
				record[1] = rs.getString("title");
				record[2] = rs.getString("ldate");
				
				String ck = null;
				int listcheck = rs.getInt("listcheck");
				
				if(listcheck == 1) {
					ck = "답변대기중";
				} else if ( listcheck == 2) {
					ck = "답변완료";
				}
				
				record[3] = ck;	
				
				dtm.addRow(record);
			}
											
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
	}

	//질문리스트
	public void ContentList(String strID, String strName) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/hospital",
							"root",
							"12345");
			Statement stmt = con.createStatement();	
			
			String sql = "SELECT * FROM questionlist ORDER BY listidx DESC";
			ResultSet rs = stmt.executeQuery(sql);			
			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			dtm.setRowCount(0);
			
			
			
			int cnt=0;
			while(rs.next()) {
				String record[] = new String[4];
				record[0] = Integer.toString(++cnt);
				record[1] = rs.getString("title");
				record[2] = rs.getString("ldate");
				listPW = rs.getString("listPW");
				listidx= rs.getInt("listidx");
				String ck = null;
				int listcheck = rs.getInt("listcheck");
				
				if(listcheck == 1) {
					ck = "답변대기중";
				} else if ( listcheck == 2) {
					ck = "답변완료";
				}
				
				record[3] = ck;	
				
				dtm.addRow(record);
			}
											
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
}
