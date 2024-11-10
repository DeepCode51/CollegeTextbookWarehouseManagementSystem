package view;

import Operatingdata.Book;

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

import static Operatingdata.Book.*;

class ReviseBookPage extends JFrame {

	private JPanel contentPane;
	private JTextField ISBN;
	private JTextField singlepublish;
	private JTextField singleISBN;
	private JTextField singlename;
	private JTextField singleauthor;
	private JTextField price;
	private JTable table;
	private JScrollPane scrollPane = new JScrollPane();

	public static LinkedList<Book> list;
	public static String[] index={"ISBN","书名", "作者", "价格", "出版社"};
	public static Object[][] data;

	/**
	 * Create the frame.
	 */
	public ReviseBookPage() {
		setTitle("修改教材");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 601);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("主界面");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("返回主界面");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPage().setVisible(true);
				ReviseBookPage.this.dispose();
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
		
		JLabel lblNewLabel_1 = new JLabel("教材表");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 904, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		list = Book.getAllBook();
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			Book book = list.get(i);
			data[i][0] = book.getISBN();
			data[i][1] = book.getName();
			data[i][2] = book.getAuthor();
			data[i][3] = book.getPrice();
			data[i][4] = book.getPublish();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("出版社名");
		lblNewLabel_3_1_1_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		singlepublish = new JTextField();
		singlepublish.setFont(new Font("宋体", Font.PLAIN, 18));
		singlepublish.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ISBN");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1 = new JLabel("书名");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("作者");
		lblNewLabel_3_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("价格");
		lblNewLabel_3_1_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("修改选项");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		singleISBN = new JTextField();
		singleISBN.setFont(new Font("宋体", Font.PLAIN, 18));
		singleISBN.setColumns(10);
		
		singlename = new JTextField();
		singlename.setFont(new Font("宋体", Font.PLAIN, 18));
		singlename.setColumns(10);
		
		singleauthor = new JTextField();
		singleauthor.setFont(new Font("宋体", Font.PLAIN, 18));
		singleauthor.setColumns(10);
		
		price = new JTextField();
		price.setFont(new Font("宋体", Font.PLAIN, 18));
		price.setColumns(10);
		
		JButton singleISBNButton = new JButton("修改");
		singleISBNButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ReviseBookISBN(ISBN.getText(), singleISBN.getText())) {
					JOptionPane.showMessageDialog(null, "修改成功!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"修改失败！","错误 ",0);
				}
			}
		});
		singleISBNButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton NameButton = new JButton("修改");
		NameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ReviseBookName(ISBN.getText(), singlename.getText())) {
					JOptionPane.showMessageDialog(null, "修改成功!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！", "错误 ", 0);
				}
			}
		});
		NameButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton authorButton = new JButton("修改");
		authorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ReviseBookAuthor(ISBN.getText(), singleauthor.getText())) {
					JOptionPane.showMessageDialog(null, "修改成功!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！", "错误 ", 0);
				}
			}
		});
		authorButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton publishButton = new JButton("修改");
		publishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ReviseBookPublish(ISBN.getText(), singlepublish.getText())) {
					JOptionPane.showMessageDialog(null, "修改成功!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！", "错误 ", 0);
				}
			}
		});
		publishButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton priceButton = new JButton("修改");
		priceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ReviseBookPrice(ISBN.getText(), price.getText())) {
					JOptionPane.showMessageDialog(null, "修改成功!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！", "错误 ", 0);
				}
			}
		});
		priceButton.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(64)
					.addComponent(singleISBNButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(88)
					.addComponent(NameButton)
					.addGap(90)
					.addComponent(authorButton)
					.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
					.addComponent(publishButton)
					.addGap(108)
					.addComponent(priceButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(100))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(74)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(115)
					.addComponent(lblNewLabel_3_1)
					.addGap(114)
					.addComponent(lblNewLabel_3_1_1)
					.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3_1_1_2)
					.addGap(140)
					.addComponent(lblNewLabel_3_1_1_1)
					.addGap(115))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(singleISBN, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(singlename, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(singleauthor, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
							.addComponent(singlepublish, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(price, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(71))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(670, Short.MAX_VALUE))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3_1, 0, 0, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3_1_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3_1_1_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_1_1_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(singlename, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(singleauthor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(price, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(singlepublish, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(singleISBN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(priceButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(publishButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(authorButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(2)
									.addComponent(NameButton, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(singleISBNButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("通过ISBN查询要修改的教材信息");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		
		ISBN = new JTextField();
		ISBN.setFont(new Font("宋体", Font.PLAIN, 18));
		ISBN.setColumns(10);
		
		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquireByISBN(ISBN.getText());
			}
		});
		confirm.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(ISBN, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(confirm, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	private void InquireByISBN(String text) {
		table = new JTable();
		list = Book.getBookByISBN(text);
		data = new Object[list.size()][index.length];
		for (int i = 0; i < list.size(); i++) {
			Book book = list.get(i);
			data[i][0] = book.getISBN();
			data[i][1] = book.getName();
			data[i][2] = book.getAuthor();
			data[i][3] = book.getPrice();
			data[i][4] = book.getPublish();
		}
		table = new JTable(data, index);
		scrollPane.setViewportView(table);
	}
}
