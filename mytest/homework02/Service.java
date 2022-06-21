package homework02;

import java.sql.SQLException;

public class Service {
    Dao dao = new Dao();

    //创建用户
    public int creatUser(User user) {
        try {
            return dao.addUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //登录
    public User loginUser(String name, String password) {

        try {
            return dao.findUserByNameAndPassword(name, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //注销
    public int delUser(int id){
        try {
            return dao.removeUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //查询余额
    public Double showMoney(){
        try {
            return dao.showMoney();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //修改密码
    public int updatePwd(String pwd){
        try {
            return dao.updatePwd(pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //存钱
    public int addMoney(Double money){
        try {
            return dao.inMoney(money);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public int minusMoney(Double money){
        try {
            return dao.outMoney(money);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean moneyService(String inName,Double money){
        boolean result=false;
        try {
            //开启事务
           Utils.startTranslation();

            //取出
            dao.outMoney(money);


            //存入
            dao.inMoney(money);

            result=true;
            //提交事务
            Utils.pullTranslation();
        } catch (Exception e) {
            //回滚事务
            try {
                Utils.backTranslation();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return result;
    }

}
