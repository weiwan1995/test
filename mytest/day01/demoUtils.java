package day01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class demoUtils {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://sh-cynosdbmysql-grp-hctrsavk.sql.tencentcdb.com:29871/demo",
                    "root", "123456zzh?");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void closeJdbc(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                connection.close();
            }
            if (resultSet != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int getStatement(String sql) {
        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeJdbc(connection, statement, null);
        }
    }

    public List<User> getResultSet(String sql) {
        List<User> list = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User(resultSet.getInt(1), resultSet.getString(1),
                        resultSet.getInt(3));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeJdbc(connection, statement, resultSet);
        }
    }
}
