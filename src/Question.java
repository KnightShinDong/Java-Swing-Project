import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Question extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Question(String strID, String strName) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uBB38\uC758\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				QuestionList questionList = new QuestionList(strID, strName);
				setVisible(false);
				questionList.setModal(true);
				questionList.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(69, 74, 115, 100);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCCC7\uBD07");
		btnNewButton_1.setBounds(243, 74, 115, 100);
		contentPanel.add(btnNewButton_1);
	}
}
