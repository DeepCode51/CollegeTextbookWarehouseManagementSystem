package Operatingdata;

import java.sql.*;

public class Procedure {
    public static double AllPrice() {
        double Allprice = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        try  {
            CallableStatement clbStmt = conn.prepareCall("{call totalprice(?)}"); // CallableStatement对象
            clbStmt.registerOutParameter(1, Types.INTEGER);
            clbStmt.execute();
            Allprice = clbStmt.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return Allprice;
    }

    public static int[] Total(String ISBN) {
        int[] total = {0, 0, 0};
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        try  {
            //创建一个CallableStatement对象调用存储过程
            CallableStatement clbStmt = conn.prepareCall("CALL Summation(?, ?, ?, ?);"); // CallableStatement对象
            clbStmt.setString(1, ISBN);
            clbStmt.registerOutParameter(2, Types.INTEGER);
            clbStmt.registerOutParameter(3, Types.INTEGER);
            clbStmt.registerOutParameter(4, Types.INTEGER);
            clbStmt.execute();
            total[0] = clbStmt.getInt(2);
            total[1] = clbStmt.getInt(3);
            total[2] = clbStmt.getInt(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return total;
    }


    public static void main(String[] args) {
        int[] total = Total("ISBN7040466411");
        for (int i:
             total) {
            System.out.println(i);
        }
    }
}
