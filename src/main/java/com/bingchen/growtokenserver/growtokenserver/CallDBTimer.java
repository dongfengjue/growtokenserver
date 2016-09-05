package com.bingchen.growtokenserver.growtokenserver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import com.mysql.jdbc.Driver;
public class CallDBTimer extends TimerTask{

    public void run() {
        System.out.println("Time's up!!!!");
        
        
        Connection conn = null;
        String sql;
        String url = "jdbc:mysql://172.31.12.142:3306/topicer?"
                + "user=topicer&password=topicer@2015&useUnicode=true&characterEncoding=UTF8";
 
        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
 
            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = conn.createStatement();
            sql = "insert into tpcr_grow_token_info select null,count(*),now() from tpcr_googleid limit 1";
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != -1) {
            	System.out.println("insert success ");
            }
            
            
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        
    }
}