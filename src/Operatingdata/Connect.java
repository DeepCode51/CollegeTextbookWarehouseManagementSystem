package Operatingdata;

import java.sql.*;

 class Connect {
    private String JDBC_URL = "jdbc:mysql://localhost:3306/graduation_219_manage";
    private String JDBC_USER = "root";
    private String JDBC_PASSWORD = "123456";
    public static Connection conn;
    public Connect() {
        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
    }
    //获取数据库连接
    public static Connection getCon() {
        return conn;
    }
    //关闭数据库连接
    public static void closeCon(java.sql.Connection con) {
        if(con!= null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
