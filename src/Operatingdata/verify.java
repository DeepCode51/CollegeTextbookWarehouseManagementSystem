package Operatingdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class verify {
    public static boolean Myverify(String account, String password) {
        new Connect();
        String pass = "";
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try {
            String sql = "SELECT * FROM accout WHERE account = \'" + account + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                account = result.getString(1);
                pass = result.getString(2);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        if (pass.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(Myverify("wang", "12346"));
    }
}
