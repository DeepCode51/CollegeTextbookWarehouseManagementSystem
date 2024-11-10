package Operatingdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Notdelivered {
    private String ISBN;
    private String name;
    private String publish;
    private int NotarriveQuantity;
    private String className;

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public String getPublish() {
        return publish;
    }

    public int getNotarriveQuantity() {
        return NotarriveQuantity;
    }

    public String getClassName() {
        return className;
    }

    public Notdelivered(String ISBN, String name, String publish, int notarriveQuantity, String className) {
        this.ISBN = ISBN;
        this.name = name;
        this.publish = publish;
        NotarriveQuantity = notarriveQuantity;
        this.className = className;
    }

    public static LinkedList<Notdelivered> getNotdelivered() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<Notdelivered> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM notdelivered");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Notdelivered notdelivered = new Notdelivered(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5));
                System.out.println(notdelivered);
                list.add(notdelivered);
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
        getNotdelivered();
    }
}
