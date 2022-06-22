package homework02.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class BankUtils {
    //定义一个连接池对象
    public static DataSource dataSource = null;

    //创建连接池
    static {
        try {
            //实例Properties
            Properties properties = new Properties();
            //获取配置文件的字节输入流
            InputStream resourceAsStream = BankUtils.class.getClassLoader().
                    getResourceAsStream("jdbc.properties");
            //读流
            properties.load(resourceAsStream);
            //创建数据流
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //存放事务的专用连接
    static ThreadLocal<Connection> t = new ThreadLocal<>();

    //获得连接
    public static Connection getConnection() throws SQLException {
        Connection connection = t.get();
        if (connection != null) {
            return connection;
        }
        return dataSource.getConnection();
    }

    //开启事务(关闭数据的自动事务提交)
    public static void beginTransaction() throws SQLException {
        //获取当前线程副本中的连接
        Connection connection = t.get();
        if (connection != null) {
            throw new SQLException("事务已开启,请勿重复开启");
        }
        //获取一个连接
        Connection connection1 = getConnection();
        //关闭自动事务提交
        connection.setAutoCommit(false);
        //把当前线程副本的连接保存起来
        t.set(connection1);
    }

    public static void commitTransaction() throws SQLException {
        //获取当前线程副本中的连接
        Connection connection = t.get();
        if (connection == null) {
            throw new SQLException("事务未提交,请勿提交");
        }
        //提交事务
        connection.commit();
        //归还连接给连接池
        connection.close();
        //移除当前线程副本中的连接
        t.remove();
    }

    public static void rollbackTransaction() throws SQLException {
        Connection connection = t.get();
        if (connection == null) {
            throw new SQLException("事务未开启，请勿回滚事务");
        }
        connection.rollback();
        connection.close();
        t.remove();

    }

    public static void closeConnection(Connection connection) throws Exception {
        Connection con = t.get();
        //如果是非事务连接 需要关闭
        if (con == null) {
            connection.close();
        }
    }

}
