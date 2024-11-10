package Operatingdata;

import java.sql.*;
import java.util.LinkedList;

public class Book {
    private String ISBN;
    private String name;
    private String author;
    private double price;
    private String publish;

    public Book(String ISBN, String name, String author, double price, String publish) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.price = price;
        this.publish = publish;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publish='" + publish + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getPublish() {
        return publish;
    }

    public static LinkedList<Book> getAllBook() {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<Book> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM books");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Book book = new Book(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDouble(4),
                        result.getString(5));
                System.out.println(book);
                list.add(book);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static LinkedList<Book> getBookByISBN(String isbn) {
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        LinkedList<Book> list = new LinkedList<>();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "SELECT * FROM books WHERE ISBN = \'" + isbn + "\';";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Book book = new Book(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDouble(4),
                        result.getString(5));
                System.out.println(book);
                list.add(book);
            }
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connect.closeCon(conn);
        return list;
    }

    public static boolean AddBook(String ISBN, String name, String author,
                                           String Sprice, String publish) {
        int flag = 0;
        double price = Double.parseDouble(Sprice);
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "INSERT INTO books(ISBN, name, author, price, publish) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, ISBN);
            statement.setString(2, name);
            statement.setString(3, author);
            statement.setDouble(4, price);
            statement.setString(5, publish);
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

    public static boolean DelBook(String ISBN) {
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "DELETE FROM books WHERE ISBN = \'" + ISBN + "\';";
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

    public static boolean ReviseBookISBN(String ISBN, String singleISBN) {
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "UPDATE books SET ISBN = \'" + singleISBN + " \' WHERE ISBN = \'" + ISBN + "\';";
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

    public static boolean ReviseBookName(String ISBN, String singlename) {
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "UPDATE books SET name = \'" + singlename + " \' WHERE ISBN = \'" + ISBN + "\';";
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

    public static boolean ReviseBookAuthor(String ISBN, String singleauthor) {
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "UPDATE books SET author = \'" + singleauthor + " \' WHERE ISBN = \'" + ISBN + "\';";
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

    public static boolean ReviseBookPublish(String ISBN, String singlePublish) {
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "UPDATE books SET publish = \'" + singlePublish + " \' WHERE ISBN = \'" + ISBN + "\';";
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

    public static boolean ReviseBookPrice(String ISBN, String Sprice) {
        double price = Double.parseDouble(Sprice);
        int flag = 0;
        //获取数据库连接
        new Connect();
        Connection conn = Connect.getCon();
        //通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
        try  {
            String sql = "UPDATE books SET price = " + price + " WHERE ISBN = \'" + ISBN + "\';";
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
        getBookByISBN("ISBN7121344411");
    }
}
