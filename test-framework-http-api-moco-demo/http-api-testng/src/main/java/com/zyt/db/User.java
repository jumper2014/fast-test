package com.zyt.db;

import java.sql.ResultSet;

public class User {

    public void deleteUserByName(String name) {
        MySQLer sqler = new MySQLer();
        sqler.connSQL();

        String sql = "delete from user where name='" + name +"'";
        String select = "select * from user";
        System.out.println(sql);
        if (sqler.deleteSQL(sql) == true) {
            System.out.println("delete successfully");
            ResultSet resultSet = sqler.selectSQL(select);
            sqler.show(resultSet);
        }
        sqler.deconnSQL();
    }

    public static void main(String[] args) {
        User user = new User();
        user.deleteUserByName("root");
    }
}
