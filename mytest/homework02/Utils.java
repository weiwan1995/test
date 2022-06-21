package homework02;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Utils {
    static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = Utils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static Connection con;

    public static Connection getConnection() throws SQLException {
        if (con != null) {
            return con;
            //如果连接存在,则返回这个连接
        }
        return dataSource.getConnection();
    }

    //开启事务
    public static void startTranslation() throws SQLException {
        if (con != null) {
            throw new SQLException("事务已存在,请勿重复开启");

        }
        con = getConnection();
        con.setAutoCommit(false);

    }

    //提交事务
    public static void pullTranslation() throws SQLException {
        if (con == null) {
            throw new SQLException("事务不存在,无法提交");
        }
        con.commit();
        con.close();
        con = null;

    }

    //回滚事务
    public static void backTranslation() throws SQLException {
        if (con == null) {
            throw new SQLException("事务不存在,无法回滚");
        }
        con.rollback();
        con.close();
        con = null;
    }

    //关闭非事务
    public static void closeTranslation(Connection connection) throws SQLException {
        if (con == null) {
            connection.close();
        }

    }

}
