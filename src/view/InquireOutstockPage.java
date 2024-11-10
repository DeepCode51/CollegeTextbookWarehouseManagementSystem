package view;

import Operatingdata.outstock;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.LinkedList;

class InquireOutstockPage extends JFrame {

	private JPanel contentPane;
	private JTextField singleISBN;
	private JTextField singleDate;
	private JTextField singleClassNum;
	private JTextField ISBN;
	private JTextField ClassNum;
	private JTextField Date;
	private JTable table;
	private JScrollPane scrollPane = new JScrollPane();
	public static LinkedList<outstock> list;
	public static String[] index={"ISBN", "出库时间", "领用班级", "出库数量", "经办人", "领取人"};
	public static Object[][] data;


	/**
	 * Create the frame.
	 */
	public InquireOutstockPage() {
		setTitle("查询出库");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 646);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("主界面");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("返回主界面");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPage().setVisible(true);
				InquireOutstockPage.this.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
							.addGap(64)
							.addComponent(singleISBNButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(singleISBN, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(singleISBNButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
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
							.addComponent(singleDate, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addGap(65)
							.addComponent(singledateButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(singleDate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(singledateButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1_2 = new JLabel("通过班级查询");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		singleClassNum = new JTextField();
		singleClassNum.setFont(new Font("宋体", Font.PLAIN, 18));
		singleClassNum.setColumns(10);
		
		JButton sigleclassNumbutton = new JButton("查询");
		sigleclassNumbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquireByClass(singleClassNum.getText());
			}
		});
		sigleclassNumbutton.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel_1_2 = new GroupLayout(panel_1_2);
		gl_panel_1_2.setHorizontalGroup(
			gl_panel_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_2.createSequentialGroup()
					.addGroup(gl_panel_1_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1_2.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(singleClassNum, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_2.createSequentialGroup()
							.addGap(56)
							.addComponent(sigleclassNumbutton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panel_1_2.setVerticalGroup(
			gl_panel_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_2.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(singleClassNum, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sigleclassNumbutton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_1_2.setLayout(gl_panel_1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		ISBN = new JTextField();
		ISBN.setFont(new Font("宋体", Font.PLAIN, 18));
		ISBN.setColumns(10);
		
		ClassNum = new JTextField();
		ClassNum.setFont(new Font("宋体", Font.PLAIN, 18));
		ClassNum.setColumns(10);
		
		Date = new JTextField();
		Date.setFont(new Font("宋体", Font.PLAIN, 18));
		Date.setColumns(10);
		
		JButton confirm = new JButton("查询");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquireByAll(ISBN.getText(), ClassNum.getText(), Date.getText());
			}
		});
		confirm.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("查询具体的某一条数据");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("ISBN");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1 = new JLabel("班级名");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("日期");
		lblNewLabel_3_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(14)
							.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(ClassNum, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Date, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(76)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addGap(148)
								.addComponent(lblNewLabel_3_1)
								.addGap(130)
								.addComponent(lblNewLabel_3_1_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
					.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_3_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3_1, 0, 0, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(ClassNum, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(Date, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel_4 = new JLabel("查询结果");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addGap(114)
					.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(798, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 938, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		list = outstock.getoutstock();
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			outstock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getOutTime();
			data[i][2] = element.getClassName();
			data[i][3] = element.getOutQuantity();
			data[i][4] = element.getManager();
			data[i][5] = element.getReceive();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	private void InquireByAll(String text, String text1, String text2) {
		Date date = java.sql.Date.valueOf(text2);
		list = outstock.getoutstockByAll(text, text1, date);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			outstock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getOutTime();
			data[i][2] = element.getClassName();
			data[i][3] = element.getOutQuantity();
			data[i][4] = element.getManager();
			data[i][5] = element.getReceive();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

	private void InquireByClass(String text) {
		list = outstock.getoutstockByclass(text);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			outstock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getOutTime();
			data[i][2] = element.getClassName();
			data[i][3] = element.getOutQuantity();
			data[i][4] = element.getManager();
			data[i][5] = element.getReceive();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

	private void InquireByDate(String text) {
		Date date = java.sql.Date.valueOf(text);
		list = outstock.getoutstockByDate(date);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			outstock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getOutTime();
			data[i][2] = element.getClassName();
			data[i][3] = element.getOutQuantity();
			data[i][4] = element.getManager();
			data[i][5] = element.getReceive();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

	private void InquireByISBN(String text) {
		list = outstock.getoutstockByISBN(text);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			outstock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getOutTime();
			data[i][2] = element.getClassName();
			data[i][3] = element.getOutQuantity();
			data[i][4] = element.getManager();
			data[i][5] = element.getReceive();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

}
