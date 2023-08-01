package com.zyt.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLer {
    private Connection conn = null;
    PreparedStatement statement = null;

    // connect to MySQL
    void connSQL() {
        String url = "jdbc:mysql://localhost:3306/api";
        String username = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.jdbc.Driver" );
            conn = DriverManager.getConnection( url,username, password );
        }

        catch ( ClassNotFoundException cnfex ) {
            System.err.println("load JDBC/ODBC driver fail" );
            cnfex.printStackTrace();
        }

        catch ( SQLException sqlex ) {
            System.err.println( "Fail to connect db" );
            sqlex.printStackTrace();
        }
    }

    // disconnect to MySQL
    void deconnSQL() {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            System.out.println("Error: close connection");
            e.printStackTrace();
        }
    }

    // execute selection language
    ResultSet selectSQL(String sql) {
        ResultSet rs = null;
        try {
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // execute insertion language
    boolean insertSQL(String sql) {
        try {
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Insert fail");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Insert fail");
            e.printStackTrace();
        }
        return false;
    }
    //execute delete language
    boolean deleteSQL(String sql) {
        try {
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Delete fail");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Delete fail");
            e.printStackTrace();
        }
        return false;
    }
    //execute update language
    boolean updateSQL(String sql) {
        try {
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Update fail");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Update fail");
            e.printStackTrace();
        }
        return false;
    }
    // show data in ju_users
    void show(ResultSet rs) {
        System.out.println("---------------------------------------------------");
        System.out.println("execution result:");
        System.out.println("---------------------------------------------------");
        System.out.println(" ID" + "\t\t" + "Name"+ "\t\t" + "Age");
        System.out.println("---------------------------------------------------");
        try {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t\t"
                        + rs.getString("name")
                        + "\t\t" + rs.getString("age"));
            }
        } catch (SQLException e) {
            System.out.println("Display fail");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Display fail");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        MySQLer user = new MySQLer();
        user.connSQL();
        String s = "select * from user";

        String insert = "insert into ju_users(ju_userID,TaobaoID,ju_userName,ju_userPWD) values("+8329+","+34243+",'mm','789')";
        String update = "update ju_users set ju_userPWD =123 where ju_userName= 'mm'";
        String delete = "delete from user where name= 'tom'";

        if (user.insertSQL(insert) == true) {
            System.out.println("insert successfully");
            ResultSet resultSet = user.selectSQL(s);
            user.show(resultSet);
        }
        if (user.updateSQL(update) == true) {
            System.out.println("update successfully");
            ResultSet resultSet = user.selectSQL(s);
            user.show(resultSet);
        }
        if (user.insertSQL(delete) == true) {
            System.out.println("delete successfully");
            ResultSet resultSet = user.selectSQL(s);
            user.show(resultSet);
        }

        user.deconnSQL();
    }
}
