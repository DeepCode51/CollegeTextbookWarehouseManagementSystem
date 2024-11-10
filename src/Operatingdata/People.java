package Operatingdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class People {
    private String name;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public People(String name) {
        this.name = name;
    }

    public static LinkedList<People> getPeople() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<People> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM manager");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                People people = new People(result.getString(1));
                System.out.println(people);
                list.add(people);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static boolean AddManager(String name) {
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "INSERT INTO manager(name) VALUE (\'" + name + "\');";
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

    public static boolean DelManager(String name) {
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "DELETE FROM manager WHERE name = \'" + name + "\';";
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
        getPeople();
    }
}
