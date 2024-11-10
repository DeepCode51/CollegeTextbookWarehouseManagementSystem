package Operatingdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Distribution {
    private String ISBN;
    private String className;
    private int disQuantity;

    @Override
    public String toString() {
        return "Distribution{" +
                "ISBN='" + ISBN + '\'' +
                ", className='" + className + '\'' +
                ", disQuantity=" + disQuantity +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public String getclassName() {
        return className;
    }

    public int getDisQuantity() {
        return disQuantity;
    }

    public Distribution(String ISBN, String className, int disQuantity) {
        this.ISBN = ISBN;
        this.className = className;
        this.disQuantity = disQuantity;
    }

    public static LinkedList<Distribution> getAllDis() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<Distribution> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM distribution");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Distribution dis = new Distribution(result.getString(1),
                        result.getString(2),
                        result.getInt(3));
                System.out.println(dis);
                list.add(dis);
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
        getAllDis();
    }
}
