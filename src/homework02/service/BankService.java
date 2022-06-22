package homework02.service;


import homework02.dao.BankDao;
import homework02.pojo.User;
import homework02.utils.BankUtils;

import java.sql.SQLException;


public class BankService {
    BankDao bankDao = new BankDao();

    //注册用户
    public int register(User user) throws SQLException {
        return bankDao.saveUser(user);
    }

    //删除用户
    public int deleteUser(Integer cardNumber) throws SQLException {
        return bankDao.deleteUser(cardNumber);
    }

    public int setPw(String name, String newPw) throws SQLException {
        return bankDao.setPw(name, newPw);
    }

    //转账
    public boolean inMoney(String name1, String name2, Double money) {
        boolean result = false;
        //开事务
        try {
            BankUtils.beginTransaction();
            bankDao.drawMoney(name1, money);
            bankDao.deposit(name2, money);
            result = true;
            //提交事务
            BankUtils.commitTransaction();
        } catch (Exception e) {
            try {
                BankUtils.rollbackTransaction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return result;

    }

    //取钱
    public int drawMoney(String name, Double money) throws Exception {
        return bankDao.drawMoney(name, money);

    }

    //存钱
    public int deposit(String name, Double money) throws Exception {
        return bankDao.deposit(name, money);
    }

    //登录
    public User login(String name, String password) throws Exception {

        return bankDao.findUserByNameAndPassword(name, password);

    }

    //查询余额
    public Double show(String name, String pw) throws SQLException {
        return bankDao.show(name, pw);
    }

    //查询用户
    public User findUserByNumAndPassword(String cardNumber, String pw) throws Exception {
        return bankDao.findUserByNameAndPassword(cardNumber, pw);
    }

}
