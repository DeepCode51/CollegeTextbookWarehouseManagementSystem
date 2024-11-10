package Operatingdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Stock {
    private String ISBN;
    private String name;
    private int total;

    @Override
    public String toString() {
        return "Stock{" +
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

    public Stock(String ISBN, String name, int total) {
        this.ISBN = ISBN;
        this.name = name;
        this.total = total;
    }

    public static LinkedList<Stock> getStock() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<Stock> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM showstock");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Stock stock = new Stock(result.getString(1),
                        result.getString(2),
                        result.getInt(3));
                System.out.println(stock);
                list.add(stock);
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
        getStock();
    }
}
