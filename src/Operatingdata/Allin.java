package Operatingdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Allin {
    private String ISBN;
    private String name;
    private int total;

    @Override
    public String toString() {
        return "Allin{" +
                "ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", total=" + total +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public Allin(String ISBN, String name, int total) {
        this.ISBN = ISBN;
        this.name = name;
        this.total = total;
    }

    public static LinkedList<Allin> getAllin() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<Allin> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM allin");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Allin allin = new Allin(result.getString(1),
                        result.getString(2),
                        result.getInt(3));
                System.out.println(allin);
                list.add(allin);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static void main(String[] args) {
        getAllin();
    }
}
