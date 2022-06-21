package homework02;

import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;


import static homework02.Utils.dataSource;

public class Dao {
    //增加
    public int addUser(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "insert into user values(?,?,?,?)";
        Object[] params = {user.getId(),user.getName(), user.getPassword(), user.getMoney()};
        return queryRunner.update(sql, params);
    }

    //删除
    public int removeUser(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "delete from user where id = ? ";
        Object[] params = {id};
        return queryRunner.update(sql, params);
    }

    //修改密码
    public int updatePwd(String newPassword) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "UPDATE user set password=?   ";
        Object[] params = {newPassword};
        return queryRunner.update(sql, params);
    }


    //根据用户名和账号查
    public User findUserByNameAndPassword(String username, String password) throws Exception {

        QueryRunner queryRunner = new QueryRunner(dataSource);

        String sql = "SELECT * FROM USER WHERE username=? AND PASSWORD=? ";

        Object[] params = {username, password};

        return queryRunner.query(sql, new BeanHandler<>(User.class), params);
    }

    //查询余额
    public double showMoney() throws Exception {
        //实例化工具类
        QueryRunner queryRunner = new QueryRunner(dataSource);
        //编写SQL语句
        String sql = "SELECT money FROM USER  ";
        //使用工具类中的方法完成查询操作
        return queryRunner.query(sql, new ScalarHandler<Double>());
    }

    //给自己存钱
    public int inMoney( double money) throws Exception {

        QueryRunner queryRunner = new QueryRunner();

        String sql = "UPDATE user SET money=money+? ";

        Object[] params = {money};

        Connection connection = Utils.getConnection();

        int row = queryRunner.update(connection, sql, params);

        Utils.closeTranslation(connection);

        return row;
    }
    //给别人存钱
    public int inOtherMoney( int id,double money) throws Exception {

        QueryRunner queryRunner = new QueryRunner();

        String sql = "UPDATE user SET money=money+? where id=?";

        Object[] params = {money,id};

        Connection connection = Utils.getConnection();

        int row = queryRunner.update(connection, sql, params);

        Utils.closeTranslation(connection);

        return row;
    }


    //取钱
    public int outMoney( double money) throws Exception {

        QueryRunner queryRunner = new QueryRunner();

        String sql = "UPDATE user SET money=money-? ";

        Object[] params = {money};

        Connection connection = Utils.getConnection();

        int row = queryRunner.update(connection, sql, params);

        Utils.closeTranslation(connection);

        return row;
    }
}
