package Operatingdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Publish {
    private String num;
    private String name;

    @Override
    public String toString() {
        return "Publish{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public Publish(String num, String name) {
        this.num = num;
        this.name = name;
    }

    public static LinkedList<Publish> getPublish() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<Publish> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM publisher");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Publish publish = new Publish(result.getString(1),
                        result.getString(2));
                System.out.println(publish);
                list.add(publish);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<Publish> getPublishById(String id) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<Publish> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            int i = Integer.valueOf(id);
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM publisher where publisherNum = \'" + i + "\';");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Publish publish = new Publish(result.getString(1),
                        result.getString(2));
                System.out.println(publish);
                list.add(publish);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static boolean AddPublish(String num, String name) {
        int flag = 0;
        //获取数据库连接
        int number = Integer.parseInt(num);
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "INSERT INTO publisher(publisherNum, publishername) VALUES(?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, number);
            statement.setString(2, name);
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

    public static boolean DelPublish(String num) {
        int number = Integer.parseInt(num);
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "DELETE FROM publisher WHERE publisherNum = " + number + ";";
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
       getPublishById("1");
    }
}
