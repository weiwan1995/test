package homework02.dao;


import homework02.pojo.User;
import homework02.utils.BankUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;


public class BankDao {
    //添加用户
    public int saveUser(User user) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(BankUtils.dataSource);

        String sql = "insert into user values (?,?,?,?) ";
        Object[] obj = {user.getUserName(), user.getPassword(), user.getMoney(), user.getCardNumber()};
        return queryRunner.update(sql, obj);
    }

    //删除用户
    public int deleteUser(Integer cardNumber) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(BankUtils.dataSource);
        String sql = "delete from user where id=?";
        Object[] obj = {cardNumber};
        return queryRunner.update(sql, obj);
    }

    //修改密码
    public int setPw(String name, String newPw) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(BankUtils.dataSource);
        String sql = "update user set password=? where  username=?";
        Object[] obj = {newPw, name};
        return queryRunner.update(sql, obj);
    }

    //存款
    public int deposit(String name, Double moneys) throws Exception {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update user set money=money+? where username=?";
        Object[] obj = {moneys, name};
        Connection connection = BankUtils.getConnection();
        int update = queryRunner.update(connection, sql, obj);
        BankUtils.closeConnection(connection);
        return update;
    }

    //取钱
    public int drawMoney(String name, Double moneys) throws Exception {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update user set money=money-? where username=?";
        Object[] obj = {moneys, name};
        Connection connection = BankUtils.getConnection();
        int update = queryRunner.update(connection, sql, obj);
        BankUtils.closeConnection(connection);
        return update;
    }

    //（余额）
    public Double show(String name, String pw) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(BankUtils.dataSource);
        String sql = "select money from user where username=? and password=?";
        Object[] obj = {name, pw};
        return queryRunner.query(sql, new ScalarHandler<>(), obj);
    }

    //根据用户名和密码查看用户
    public User findUserByNameAndPassword(String name, String password) throws Exception {
        //实例化工具类
        QueryRunner queryRunner = new QueryRunner(BankUtils.dataSource);
        //编写SQL语句
        String sql = "select * from user WHERE username=? and password=? ";
        //收集参数
        Object[] params = {name, password};
        //使用工具类中的方法完成查询操作
        return queryRunner.query(sql, new BeanHandler<>(User.class), params);
    }


}
