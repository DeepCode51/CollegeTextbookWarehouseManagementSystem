package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setFont(new Font("楷体", Font.PLAIN, 20));
		setTitle("高校教材管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 553);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("教材管理");
		mnNewMenu.setBackground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("查询教材");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InquireBooksPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("增加教材");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBookPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("删除教材");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DelBookPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("修改教材");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReviseBookPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_6 = new JMenu("班级管理");
		menuBar.add(mnNewMenu_6);

		JMenuItem mntmNewMenuItem_19 = new JMenuItem("增加班级");
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddClassPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_19);

		JMenuItem mntmNewMenuItem_20 = new JMenuItem("修改班级");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReviseClassPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_20);

		JMenuItem mntmNewMenuItem_22 = new JMenuItem("删除班级");
		mntmNewMenuItem_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DelClassPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_22);

		JMenuItem mntmNewMenuItem_17 = new JMenuItem("查询班级");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InquireClassPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_17);

		JMenu mnNewMenu_5 = new JMenu("出版社(书店)管理");
		menuBar.add(mnNewMenu_5);

		JMenuItem mntmNewMenuItem_15 = new JMenuItem("出版社管理");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagePublishPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_15);

		JMenu mnNewMenu_7 = new JMenu("仓库人员管理");
		menuBar.add(mnNewMenu_7);

		JMenuItem mntmNewMenuItem_21 = new JMenuItem("管理");
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagePeoplePage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_21);

		JMenu mnNewMenu_1 = new JMenu("订购管理");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("添加订单");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddOrderPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("查询订单");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InquireOrderPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("删除订单");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DelOrderPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("订单统计");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatisticsOrderPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JMenu mnNewMenu_2 = new JMenu("入库管理");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("教材入库");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddInstockPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("查询入库信息");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InquireInstockPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("入库表统计");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatisticsInstockPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);

		JMenu mnNewMenu_3 = new JMenu("出库管理");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("教材出库");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddOutstockPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_11);

		JMenuItem mntmNewMenuItem_12 = new JMenuItem("查询出库信息");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InquireOutstockPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_12);

		JMenuItem mntmNewMenuItem_13 = new JMenuItem("出库表统计");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatisticsOutstockPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_13);

		JMenu mnNewMenu_4 = new JMenu("库存管理");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_14 = new JMenuItem("库存查询");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StockPage().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_14);

		JMenu mnNewMenu_8 = new JMenu("统计");
		menuBar.add(mnNewMenu_8);

		JMenuItem mntmNewMenuItem_16 = new JMenuItem("订购入库出库统计");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Statistics().setVisible(true);
				MainPage.this.dispose();
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_16);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGap(0, 926, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGap(0, 467, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
