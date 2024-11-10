package Operatingdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

public class instock {
    private String ISBN;
    private Date inTime;
    private  String inpublishName;
    private int inQuantity;
    private String inmanager;

    public String getISBN() {
        return ISBN;
    }

    public Date getInTime() {
        return inTime;
    }

    public String getInpublishName() {
        return inpublishName;
    }

    public int getInQuantity() {
        return inQuantity;
    }

    @Override
    public String toString() {
        return "instock{" +
                "ISBN='" + ISBN + '\'' +
                ", inTime=" + inTime +
                ", inpublishName='" + inpublishName + '\'' +
                ", inQuantity=" + inQuantity +
                ", inmanager='" + inmanager + '\'' +
                '}';
    }

    public String getInmanager() {
        return inmanager;
    }

    public instock(String ISBN, Date inTime, String inpublishName, int inQuantity, String inmanager) {
        this.ISBN = ISBN;
        this.inTime = inTime;
        this.inpublishName = inpublishName;
        this.inQuantity = inQuantity;
        this.inmanager = inmanager;
    }

    public static LinkedList<instock> getinstock() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<instock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM instock");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                instock in = new instock(result.getString(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5));
                System.out.println(in);
                list.add(in);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<instock> getinstockByISBN(String isbn) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<instock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM instock WHERE ISBN = \'" + isbn + "\';");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                instock in = new instock(result.getString(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5));
                System.out.println(in);
                list.add(in);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<instock> getinstockByDate(Date date) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<instock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM instock WHERE inTime = \'" + date + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                instock in = new instock(result.getString(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5));
                System.out.println(in);
                list.add(in);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<instock> getinstockByPublish(String publish) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<instock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM instock WHERE inpublishName = \'" + publish + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                instock in = new instock(result.getString(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5));
                System.out.println(in);
                list.add(in);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<instock> getinstockByAll(String isbn, Date date, String publish) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<instock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM instock WHERE inpublishName = \'" + publish +
                    "\' and inTime = \'" + date + "\' and ISBN = \'" + isbn + "\';";
            System.out.println(sql);
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                instock in = new instock(result.getString(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5));
                System.out.println(in);
                list.add(in);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static boolean AddInstock(String ISBN, String time, String publishName,
                                   String quantity, String manager) {
        int inQuantity = Integer.parseInt(quantity);
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "INSERT INTO instock(ISBN, inTime, inpublishName, inQuantity, inmanager) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, ISBN);
            statement.setDate(2, java.sql.Date.valueOf(time));
            statement.setString(3, publishName);
            statement.setInt(4, inQuantity);
            statement.setString(5, manager);
            flag = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Date date = java.sql.Date.valueOf("2021-12-28");
//        getinstockByDate(date);
        getinstockByAll("ISBN7040466411", date, "西安电子科技大学出版社");
    }
}
