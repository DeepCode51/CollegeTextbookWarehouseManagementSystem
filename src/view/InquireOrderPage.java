package view;

import Operatingdata.order;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.LinkedList;

class InquireOrderPage extends JFrame {

	private JPanel contentPane;
	private JTextField singleISBN;
	private JTextField singleClassNum;
	private JTextField singleDate;
	private JTextField singlepublish;
	private JTextField ISBN;
	private JTextField classNum;
	private JTextField date;
	private JTextField publishNum;
	private JTable table;
	private JScrollPane scrollPane = new JScrollPane();
	public static LinkedList<order> list;
	public static String[] index={"班级","ISBN", "出版社", "日期", "订购数量", "经办人"};
	public static Object[][] data;


	/**
	 * Create the frame.
	 */
	public InquireOrderPage() {
		setTitle("查询订单");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 634);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("主界面");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("返回主界面");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPage().setVisible(true);
				InquireOrderPage.this.dispose();
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
		
		JLabel lblNewLabel_1 = new JLabel("通过班级名查询");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		singleClassNum = new JTextField();
		singleClassNum.setFont(new Font("宋体", Font.PLAIN, 18));
		singleClassNum.setColumns(10);
		
		JButton sigleclassNumbutton = new JButton("查询");
		sigleclassNumbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquireByClassNum(singleClassNum.getText());
			}
		});
		sigleclassNumbutton.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(singleClassNum, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(60)
							.addComponent(sigleclassNumbutton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(singleClassNum, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(sigleclassNumbutton, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
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
							.addComponent(singleDate, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addGap(67)
							.addComponent(singledateButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
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
					.addComponent(singledateButton, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("通过出版社名查询");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		singlepublish = new JTextField();
		singlepublish.setFont(new Font("宋体", Font.PLAIN, 18));
		singlepublish.setColumns(10);
		
		JButton singlepublishButton = new JButton("查询");
		singlepublishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquireByPublish(singlepublish.getText());
			}
		});
		singlepublishButton.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel_1_1_1 = new GroupLayout(panel_1_1_1);
		gl_panel_1_1_1.setHorizontalGroup(
			gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(singlepublish, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1_1))
					.addContainerGap(24, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
					.addGap(67)
					.addComponent(singlepublishButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_panel_1_1_1.setVerticalGroup(
			gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(singlepublish, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(singlepublishButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1_1_1.setLayout(gl_panel_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		

		
		JLabel lblNewLabel_4 = new JLabel("查询结果");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1_1_1, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addComponent(panel_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(36)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);

		list = order.getorder();
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			order element = list.get(i);
			data[i][0] = element.getClassName();
			data[i][1] = element.getISBN();
			data[i][2] = element.getPublishName();
			data[i][3] = element.getOrderTime();
			data[i][4] = element.getOrderQuantity();
			data[i][5] = element.getManager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("查询具体的某一条数据");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		ISBN = new JTextField();
		ISBN.setFont(new Font("宋体", Font.PLAIN, 18));
		ISBN.setColumns(10);
		
		classNum = new JTextField();
		classNum.setFont(new Font("宋体", Font.PLAIN, 18));
		classNum.setColumns(10);
		
		date = new JTextField();
		date.setFont(new Font("宋体", Font.PLAIN, 18));
		date.setColumns(10);
		
		publishNum = new JTextField();
		publishNum.setFont(new Font("宋体", Font.PLAIN, 18));
		publishNum.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ISBN");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1 = new JLabel("班级名");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("日期");
		lblNewLabel_3_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("出版社名");
		lblNewLabel_3_1_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton confirm = new JButton("查询");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquireByAll(ISBN.getText(), classNum.getText(),
						date.getText(), publishNum.getText());
			}
		});
		confirm.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(14)
							.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(classNum, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(date, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(publishNum, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
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
								.addComponent(lblNewLabel_3_1_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addGap(124)
								.addComponent(lblNewLabel_3_1_1_1))))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(lblNewLabel_3_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3_1, 0, 0, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(classNum, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(date, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(publishNum, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel = new JLabel("通过ISBN查询");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(singleISBN, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(66)
							.addComponent(singleISBNButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(singleISBN, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(singleISBNButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	private void InquireByAll(String text, String text1, String text2, String text3) {
		Date date1 = java.sql.Date.valueOf(text2);
		list = order.getorderByAll(text, text1, date1, text3);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			order element = list.get(i);
			data[i][0] = element.getClassName();
			data[i][1] = element.getISBN();
			data[i][2] = element.getPublishName();
			data[i][3] = element.getOrderTime();
			data[i][4] = element.getOrderQuantity();
			data[i][5] = element.getManager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

	private void InquireByPublish(String text) {
		list = order.getorderByPublish(text);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			order element = list.get(i);
			data[i][0] = element.getClassName();
			data[i][1] = element.getISBN();
			data[i][2] = element.getPublishName();
			data[i][3] = element.getOrderTime();
			data[i][4] = element.getOrderQuantity();
			data[i][5] = element.getManager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

	private void InquireByDate(String text) {
		Date date = java.sql.Date.valueOf(text);
		list = order.getorderByDate(date);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			order element = list.get(i);
			data[i][0] = element.getClassName();
			data[i][1] = element.getISBN();
			data[i][2] = element.getPublishName();
			data[i][3] = element.getOrderTime();
			data[i][4] = element.getOrderQuantity();
			data[i][5] = element.getManager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

	private void InquireByClassNum(String text) {
		list = order.getorderByClass(text);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			order element = list.get(i);
			data[i][0] = element.getClassName();
			data[i][1] = element.getISBN();
			data[i][2] = element.getPublishName();
			data[i][3] = element.getOrderTime();
			data[i][4] = element.getOrderQuantity();
			data[i][5] = element.getManager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}

	private void InquireByISBN(String text) {
		list = order.getorderByISBN(text);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			order element = list.get(i);
			data[i][0] = element.getClassName();
			data[i][1] = element.getISBN();
			data[i][2] = element.getPublishName();
			data[i][3] = element.getOrderTime();
			data[i][4] = element.getOrderQuantity();
			data[i][5] = element.getManager();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}
}
