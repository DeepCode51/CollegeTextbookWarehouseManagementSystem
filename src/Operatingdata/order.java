package Operatingdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

public class order {
    private String className;
    private String ISBN;
    private String publishName;
    private Date orderTime;
    private int orderQuantity;
    private  String manager;

    public order(String className, String ISBN, String publishName, Date orderTime, int orderQuantity, String manager) {
        this.className = className;
        this.ISBN = ISBN;
        this.publishName = publishName;
        this.orderTime = orderTime;
        this.orderQuantity = orderQuantity;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "order{" +
                "className='" + className + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publishName='" + publishName + '\'' +
                ", orderTime=" + orderTime +
                ", orderQuantity=" + orderQuantity +
                ", manager='" + manager + '\'' +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublishName() {
        return publishName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public String getManager() {
        return manager;
    }
    public static LinkedList<order> getorder() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<order> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM ordertable");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                order order = new order(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDate(4),
                        result.getInt(5),
                        result.getString(6));
                System.out.println(order);
                list.add(order);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<order> getorderByISBN(String isbn) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<order> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM ordertable WHERE ISBN = \'" + isbn + "\';");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                order order = new order(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDate(4),
                        result.getInt(5),
                        result.getString(6));
                System.out.println(order);
                list.add(order);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<order> getorderByDate(Date date) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<order> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM ordertable WHERE orderTime = \'" + date + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                order order = new order(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDate(4),
                        result.getInt(5),
                        result.getString(6));
                System.out.println(order);
                list.add(order);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<order> getorderByPublish(String publish) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<order> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM ordertable WHERE publisherName = \'" + publish + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                order order = new order(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDate(4),
                        result.getInt(5),
                        result.getString(6));
                System.out.println(order);
                list.add(order);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<order> getorderByClass(String className) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<order> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM ordertable WHERE className = \'" + className + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                order order = new order(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDate(4),
                        result.getInt(5),
                        result.getString(6));
                System.out.println(order);
                list.add(order);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<order> getorderByAll(String isbn, String className, Date date, String publish) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<order> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM ordertable WHERE publisherName = \'" + publish +
                    "\' and orderTime = \'" + date + "\' and ISBN = \'" + isbn +
                    "\' and className = \'" + className + "\';";
            System.out.println(sql);
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                order order = new order(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDate(4),
                        result.getInt(5),
                        result.getString(6));
                System.out.println(order);
                list.add(order);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }


    public static boolean AddOrder(String className, String ISBN, String publishName,
                                   String time, String quantity, String manager) {
        int orderQuantity = Integer.parseInt(quantity);
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "INSERT INTO ordertable(className, ISBN, publisherName, orderTime, orderQuantity, manager) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, className);
            statement.setString(2, ISBN);
            statement.setString(3, publishName);
            statement.setDate(4, java.sql.Date.valueOf(time));
            statement.setInt(5, orderQuantity);
            statement.setString(6, manager);
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

    public static boolean DelOrder(String className, String ISBN, String publishName,
                                   String time) {
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "DELETE FROM ordertable WHERE className = \'" + className +
                    "\' AND ISBN = \'" + ISBN + "\' AND orderTime = \'" +
                    java.sql.Date.valueOf(time) + "\' AND publisherName = \'" + publishName + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
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
//        getorderByISBN("ISBN7040466411");
        Date date = java.sql.Date.valueOf("2021-12-22");
//        getorderByDate(date);
//        getorderByPublish("电子工业出版社");
//        getorderByClass("软件工程1901");
        getorderByAll("ISBN7040466411","软件工程1901", date, "西安电子科技大学出版社");
    }

}
