package view;

import Operatingdata.instock;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.LinkedList;

class InquireInstockPage extends JFrame {

	private JPanel contentPane;
	private JTextField singleISBN;
	private JTextField singleDate;
	private JTextField textField;
	private JTextField ISBN;
	private JTextField date;
	private JTextField publish;
	private JTable table;
	private JScrollPane scrollPane = new JScrollPane();
	public static LinkedList<instock> list;
	public static String[] index = {"ISBN", "入库时间", "出版社", "入库数量", "经办人"};
	public static Object[][] data;


	/**
	 * Create the frame.
	 */
	public InquireInstockPage() {
		setTitle("查询入库");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 633);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("主界面");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("返回主界面");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPage().setVisible(true);
				InquireInstockPage.this.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1 = new JLabel("通过ISBN查询");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		singleISBN = new JTextField();
		singleISBN.setFont(new Font("宋体", Font.PLAIN, 18));
		singleISBN.setColumns(10);
		
		JButton singleISBNButton = new JButton("查询");
		singleISBNButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquireByISBN(singleISBN.getText());
			}
		});
		singleISBNButton.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(19)
							.addComponent(singleISBN, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(59)
							.addComponent(singleISBNButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(singleISBN, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(singleISBNButton, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1_1 = new JLabel("通过日期查询");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		singleDate = new JTextField();
		singleDate.setFont(new Font("宋体", Font.PLAIN, 18));
		singleDate.setColumns(10);
		
		JButton singledateButton = new JButton("查询");
		singledateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquireByDate(singleDate.getText());
			}
		});
		singledateButton.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(singleDate, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1_1.createSequentialGroup()
					.addContainerGap(66, Short.MAX_VALUE)
					.addComponent(singledateButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(singleDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(singledateButton, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(6))
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton singlepublishButton = new JButton("查询");
		singlepublishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquireByPublish(textField.getText());
			}
		});
		singlepublishButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("通过出版社查询");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setColumns(10);
		GroupLayout gl_panel_1_1_1 = new GroupLayout(panel_1_1_1);
		gl_panel_1_1_1.setHorizontalGroup(
			gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1_1))
					.addContainerGap(23, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_panel_1_1_1.createSequentialGroup()
					.addContainerGap(66, Short.MAX_VALUE)
					.addComponent(singlepublishButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
		);
		gl_panel_1_1_1.setVerticalGroup(
			gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(singlepublishButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1_1_1.setLayout(gl_panel_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		ISBN = new JTextField();
		ISBN.setFont(new Font("宋体", Font.PLAIN, 18));
		ISBN.setColumns(10);
		
		date = new JTextField();
		date.setFont(new Font("宋体", Font.PLAIN, 18));
		date.setColumns(10);
		
		publish = new JTextField();
		publish.setFont(new Font("宋体", Font.PLAIN, 18));
		publish.setColumns(10);
		
		JButton confirm = new JButton("查询");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquireByALL(ISBN.getText(), date.getText(),
						publish.getText());
			}
		});
		confirm.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("查询具体的某一条数据");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("ISBN");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("日期");
		lblNewLabel_3_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("出版社编号");
		lblNewLabel_3_1_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(14)
							.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(date, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(publish, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(76)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(134)
									.addComponent(lblNewLabel_3_1_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
							.addGap(154)
							.addComponent(lblNewLabel_3_1_1_1)))
					.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
					.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(54))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(date, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(publish, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_3_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(65))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNewLabel_3_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(67))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
							.addGap(122)
							.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
							.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 946, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 767, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1_1, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
						.addComponent(panel_1_1_1, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
		JLabel lblNewLabel = new JLabel("查询结果");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 733, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(201, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);

		list = instock.getinstock();
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			instock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getInTime();
			data[i][2] = element.getInpublishName();
			data[i][3] = element.getInQuantity();
			data[i][4] = element.getInmanager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	private void InquireByALL(String text, String text1, String text2) {
		Date date1 = java.sql.Date.valueOf(text1);
		list = instock.getinstockByAll(text, date1, text2);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			instock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getInTime();
			data[i][2] = element.getInpublishName();
			data[i][3] = element.getInQuantity();
			data[i][4] = element.getInmanager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

	private void InquireByPublish(String text) {
		list = instock.getinstockByPublish(text);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			instock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getInTime();
			data[i][2] = element.getInpublishName();
			data[i][3] = element.getInQuantity();
			data[i][4] = element.getInmanager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

	private void InquireByDate(String text) {
		Date date = java.sql.Date.valueOf(text);
		list = instock.getinstockByDate(date);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			instock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getInTime();
			data[i][2] = element.getInpublishName();
			data[i][3] = element.getInQuantity();
			data[i][4] = element.getInmanager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

	private void InquireByISBN(String text) {
		list = instock.getinstockByISBN(text);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			instock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getInTime();
			data[i][2] = element.getInpublishName();
			data[i][3] = element.getInQuantity();
			data[i][4] = element.getInmanager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

}
