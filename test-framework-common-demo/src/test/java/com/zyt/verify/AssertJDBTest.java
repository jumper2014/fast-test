package com.zyt.verify;


import com.zyt.App;
import lombok.SneakyThrows;
import org.assertj.db.type.Table;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.db.api.Assertions.assertThat;
import org.assertj.db.type.Request;
import org.assertj.db.type.Source;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AssertJDBTest {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/testflash?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=Asia/Shanghai";
    private static String username = "root"; //实际用户名
    private static String password = "123456"; //实际密码
    private static Connection conn = null;



    @Test
    public void basic_request_assertion_examples(){
        Source source = new Source(url,username,password);
        Table table = new Table(source, "user");
//        Request request = new Request(source,"SELECT * FROM user");
//        //获取该表的字段名
//        List<String> list = request.getColumnsNameList();
//        for (String s : list) {
//            System.out.print(s + "\t");
//        }
        //断言name这一列数据
        assertThat(table).column("user_name")
                .value().isEqualTo("tester1")
                .value().isEqualTo("tester2")
                .value().isEqualTo("tester3");

//        //断言数据库表中的数据条数
//        assertThat(request).hasNumberOfRows(3);
//
//        //断言第一行的数据的值,row(0)代表第一行数据
//        assertThat(request).row(0)
//                .value().isEqualTo("1")
//                .value().isEqualTo("hello")
//                .value().isEqualTo("1")
//                .value().isEqualTo("11");
    }


}
