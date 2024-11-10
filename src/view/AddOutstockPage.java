package view;

import Operatingdata.Distribution;
import Operatingdata.People;
import Operatingdata.Stock;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import static Operatingdata.outstock.AddOutstock;

class AddOutstockPage extends JFrame {

	private JPanel contentPane;
	private JTextField ISBN;
	private JTextField outTime;
	private JTextField outQuantity;
	private JTextField outClass;
	private JTable table;
	private JTable table_1;
	private JComboBox manager;

	public static LinkedList<People> lists;
	public static Object[] datas;

	/**
	 * Create the frame.
	 */
	public AddOutstockPage() {
		setTitle("教材出库");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 644);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("主界面");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("返回主界面");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPage().setVisible(true);
				AddOutstockPage.this.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("班级分配表");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(470, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);

		String[] index1={"ISBN", "班级", "剩余分配数量"};
		LinkedList<Distribution> list1 = Distribution.getAllDis();
		Object[][] data1 = new Object[list1.size()][index1.length];
		for (int i = 0; i < list1.size(); i++) {
			Distribution element = list1.get(i);
			data1[i][0] = element.getISBN();
			data1[i][1] = element.getclassName();
			data1[i][2] = element.getDisQuantity();
		}
		table = new JTable(data1, index1);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1 = new JLabel("库存表");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(473, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);

		String[] index={"ISBN", "书名", "库存量"};
		LinkedList<Stock> list = Stock.getStock();
		Object[][] data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			Stock element = list.get(i);
			data[i][0] = element.getISBN();
			data[i][1] = element.getName();
			data[i][2] = element.getTotal();
		}
		table_1 = new JTable(data, index);
		scrollPane_1.setViewportView(table_1);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_3 = new JLabel("ISBN");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1 = new JLabel("出库时间");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("出库数量");
		lblNewLabel_3_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("经办人");
		lblNewLabel_3_1_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("出库信息");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		ISBN = new JTextField();
		ISBN.setFont(new Font("宋体", Font.PLAIN, 18));
		ISBN.setColumns(10);
		
		outTime = new JTextField();
		outTime.setFont(new Font("宋体", Font.PLAIN, 18));
		outTime.setColumns(10);
		
		outQuantity = new JTextField();
		outQuantity.setFont(new Font("宋体", Font.PLAIN, 18));
		outQuantity.setColumns(10);
		
		outClass = new JTextField();
		outClass.setFont(new Font("宋体", Font.PLAIN, 18));
		outClass.setColumns(10);
		
		JButton confirm = new JButton("确认出库");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AddOutstock(ISBN.getText(), outTime.getText(), outClass.getText(),
						outQuantity.getText(), manager.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(null, "添加成功!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"添加失败！","错误 ",0);
				}
			}
		});
		confirm.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("领用班级");
		lblNewLabel_3_1_1_1_1.setFont(new Font("宋体", Font.PLAIN, 18));

		lists = People.getPeople();
		datas = new Object[lists.size()];
		for (int i = 0; i < lists.size(); i++) {
			People element = lists.get(i);
			datas[i] = element.getName();
		}

		manager = new JComboBox(datas);

		manager.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(outTime, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(125)
									.addComponent(lblNewLabel_3_1)))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(11)
									.addComponent(lblNewLabel_3_1_1)
									.addGap(93)
									.addComponent(lblNewLabel_3_1_1_1_1)
									.addGap(73)
									.addComponent(lblNewLabel_3_1_1_1)
									.addContainerGap())
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(outQuantity, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(outClass, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(manager, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(confirm, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
									.addGap(20))))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3_1, 0, 0, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3_1_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3_1_1_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(outTime, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(outQuantity, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(outClass, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(manager, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 932, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
