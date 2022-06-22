package homework01;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    //加载驱动和连接
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://sh-cynosdbmysql-grp-hctrsavk.sql.tencentcdb.com:29871/demo",
                    "root", "123456zzh?");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //释放资源
    public void closeJDBC(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                connection.close();
            }
            if (resultSet != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {

    }



    //    通用的增删改
    public int getUpdate(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeJDBC(connection, preparedStatement, null);
        }
    }

    //    通用的查方法
    public ArrayList<HeroCard> getQuery(String sql, Object... params) {
        ArrayList<HeroCard> list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HeroCard heroCard = new HeroCard(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getInt(4), resultSet.getBigDecimal(5), resultSet.getString(6),
                        resultSet.getString(7));
                list.add(heroCard);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeJDBC(connection, preparedStatement, resultSet);
        }
        return list;
    }


}
