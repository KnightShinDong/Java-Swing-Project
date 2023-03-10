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

public class Home extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public Home(String strID, String strName) {
		setBounds(100, 100, 450, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_2 = new JLabel("\uB2D8\uC758 \uC9C4\uB8CC\uC608\uC57D\uC774");
			lblNewLabel_2.setBounds(66, 10, 101, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel(strName);
			lblNewLabel_3.setBounds(12, 10, 45, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("\uBA87");
			lblNewLabel_4.setBounds(164, 10, 31, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("\uAC74 \uC788\uC2B5\uB2C8\uB2E4..");
			lblNewLabel_5.setBounds(195, 10, 126, 15);
			contentPanel.add(lblNewLabel_5);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 71, 378, 148);
		contentPanel.add(scrollPane);
		String columnNames[]= {"순번","날짜","시간","진료여부"};
		DefaultTableModel dtm = new DefaultTableModel(columnNames,0);
		table = new JTable(dtm);		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String checkOk = (String)table.getValueAt(row, 1);
				setVisible(false);
				ReservationOk reOk = new ReservationOk(checkOk,strID,strName);
				reOk.setModal(true);
				reOk.setVisible(true);
			}
		});
		scrollPane.setViewportView(table);
		// 글꼴 선택(WindowBuilder -> Design - Properties)
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		// 셀 너비 조절
		int widths[] = { 5, 10, 20, 20};		 
		for (int i=0; i<4; i++) {
		  TableColumn column = table.getColumnModel().getColumn(i);
		  column.setPreferredWidth( widths[i] );
		}
		// 셀 높이 조절
		table.setRowHeight(25);
		
		JButton btnNewButton = new JButton("예약하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reservation reservation = new Reservation(strID, strName);
				setVisible(false);
				reservation.setModal(true);
				reservation.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(25, 248, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("로그아웃");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login login = new login();
				setVisible(false);
				login.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(306, 248, 97, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uBB38\uC758\uD558\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question question = new Question(strID, strName);
				setVisible(false);
				question.setModal(true);
				question.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(164, 248, 97, 23);
		contentPanel.add(btnNewButton_2);
		// 셀 정렬
		DefaultTableCellRenderer cellAlignRight = new DefaultTableCellRenderer();
		cellAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumn("순번").setCellRenderer(cellAlignRight);		
		table.getColumn("날짜").setCellRenderer(cellAlignRight);
		
		ContentList(strID, strName);
		
	}

	// 병원 진료 예약 리스트 
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
			
			String sql = "SELECT * FROM reservationtbl where id='"+strID+"'";
			ResultSet rs = stmt.executeQuery(sql);			
			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			dtm.setRowCount(0);
			
			
			
			int cnt=0;
			while(rs.next()) {
				String record[] = new String[6];
				record[0] = Integer.toString(++cnt);
				record[1] = rs.getString("rdate");
				record[2] = rs.getString("rtime");
				
				String ck = null;
				int checked = rs.getInt("checkflag");
				
				if(checked == 1) {
					ck = "예약확인중";
				} else if (checked == 2) {
					ck = "예약완료";
				} else if (checked == 0) {
					ck= "취소";
				}
				
				record[3] = ck;	
				
				dtm.addRow(record);
			}
											
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	

}
