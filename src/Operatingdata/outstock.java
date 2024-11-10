package Operatingdata;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

public class outstock {
    private String ISBN;
    private Date outTime;
    private String className;
    private int outQuantity;
    private String manager;
    private String receive;


    @Override
    public String toString() {
        return "outstock{" +
                "ISBN='" + ISBN + '\'' +
                ", outTime=" + outTime +
                ", className='" + className + '\'' +
                ", outQuantity=" + outQuantity +
                ", manager='" + manager + '\'' +
                ", receive='" + receive + '\'' +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public Date getOutTime() {
        return outTime;
    }

    public String getClassName() {
        return className;
    }

    public int getOutQuantity() {
        return outQuantity;
    }

    public String getManager() {
        return manager;
    }

    public String getReceive() {
        return receive;
    }

    public outstock(String ISBN, Date outTime, String className, int outQuantity, String manager, String receive) {
        this.ISBN = ISBN;
        this.outTime = outTime;
        this.className = className;
        this.outQuantity = outQuantity;
        this.manager = manager;
        this.receive = receive;
    }

    public static LinkedList<outstock> getoutstock() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<outstock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM outstock");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                outstock out = new outstock(result.getString(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6));
                System.out.println(out);
                list.add(out);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<outstock> getoutstockByISBN(String isbn) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<outstock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM outstock WHERE ISBN = \'" + isbn + "\';");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                outstock out = new outstock(result.getString(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6));
                System.out.println(out);
                list.add(out);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<outstock> getoutstockByDate(Date date) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<outstock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM outstock WHERE outTime = \'" + date + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                outstock out = new outstock(result.getString(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6));
                System.out.println(out);
                list.add(out);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<outstock> getoutstockByclass(String className) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<outstock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM outstock WHERE className = \'" + className + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                outstock out = new outstock(result.getString(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6));
                System.out.println(out);
                list.add(out);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<outstock> getoutstockByAll(String isbn, String className, Date date) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<outstock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM outstock WHERE className = \'" + className +
                    "\' and outTime = \'" + date + "\' and ISBN = \'" + isbn + "\';";
            System.out.println(sql);
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                outstock out = new outstock(result.getString(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6));
                System.out.println(out);
                list.add(out);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static boolean AddOutstock(String ISBN, String time, String className,
                                     String quantity, String manager) {
        int outQuantity = Integer.parseInt(quantity);
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String receive = "";
            PreparedStatement statement1 = conn.prepareStatement("select monitor from class where name = \'" + className + "\';");
            ResultSet result1 = statement1.executeQuery();
            while (result1.next()) {
                receive = result1.getString(1);
            }

            String sql = "INSERT INTO outstock(ISBN, outTime, className, outQuantity, manager, receive) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, ISBN);
            statement.setDate(2, java.sql.Date.valueOf(time));
            statement.setString(3, className);
            statement.setInt(4, outQuantity);
            statement.setString(5, manager);
            statement.setString(6, receive);
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
//        getoutstockByISBN("ISBN7040466411");
        Date date = java.sql.Date.valueOf("2021-12-13");
//        getoutstockByDate(date);
//        getoutstockByclass("软件工程1901");
        getoutstockByAll("ISBN7040466411", "软件工程1901", date);
    }
}
