package Operatingdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyClass {
    private String number;
    private String name;
    private String monitor;

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getMonitor() {
        return monitor;
    }

    @Override
    public String toString() {
        return "Class{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", monitor='" + monitor + '\'' +
                '}';
    }

    public MyClass(String number, String name, String monitor) {
        this.number = number;
        this.name = name;
        this.monitor = monitor;
    }

    public static LinkedList<MyClass> getAllClass() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<MyClass> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM class");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                MyClass aClass = new MyClass(result.getString(1),
                        result.getString(2),
                        result.getString(3));
                System.out.println(aClass);
                list.add(aClass);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<MyClass> getClassById(int id) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<MyClass> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "SELECT * FROM class where number = " + id + ";";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                MyClass aClass = new MyClass(result.getString(1),
                        result.getString(2),
                        result.getString(3));
                System.out.println(aClass);
                list.add(aClass);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static boolean AddClass(String number, String name, String monitor) {
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "INSERT INTO class(number, name, monitor) VALUES(?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, number);
            statement.setString(2, name);
            statement.setString(3, monitor);
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

    public static boolean DelClass(String classNum) {
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "DELETE FROM class WHERE number = \'" + classNum + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
            flag = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        if (flag > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ReviseClassNum(String classNum, String singleclassNum) {
        int flag = 0;
        //获取数据库连接
        int num = Integer.parseInt(classNum);
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "UPDATE class SET number = \'" + singleclassNum + " \' WHERE number = " + num + ";";
            PreparedStatement statement = conn.prepareStatement(sql);
            flag = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        if (flag > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ReviseClassName(String classNum, String className) {
        int flag = 0;
        //获取数据库连接
        int num = Integer.parseInt(classNum);
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "UPDATE class SET name = \'" + className + " \' WHERE number = " + num + ";";
            PreparedStatement statement = conn.prepareStatement(sql);
            flag = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        if (flag > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ReviseClassMonitor(String classNum, String monitor) {
        int flag = 0;
        //获取数据库连接
        int num = Integer.parseInt(classNum);
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "UPDATE class SET monitor = \'" + monitor + " \' WHERE number = " + num + ";";
            PreparedStatement statement = conn.prepareStatement(sql);
            flag = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        if (flag > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        getClassById(2);
    }
}
