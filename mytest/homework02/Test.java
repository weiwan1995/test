package homework02;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Service service=new Service();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("欢迎来到银行系统");
        while (true) {
            System.out.println("选择功能");
            System.out.println("1,创建用户");
            System.out.println("2,登录");
            System.out.println("3,注销");
            System.out.println("4,查询余额");
            System.out.println("5,修改密码");
            System.out.println("6,存钱");
            System.out.println("7,取钱");
            System.out.println("8,转账");
            String choose = scanner.next();
            switch (choose) {
                case "1":
                    System.out.println("请输入用户名");
                    String name = scanner.next();
                    if (!name.matches("[a-zA-Z]+")) {
                        System.err.println("请以字母开头");
                        break;
                    }
                    System.out.println("请输入密码");
                    String pwd1 = scanner.next();
                    if (!pwd1.matches("\\w{6,12}")) {
                        System.err.println("密码为6-12位的数字");
                        break;
                    }
                    System.out.println("请再次输入密码");
                    String pwd2 = scanner.next();
                    if (!Objects.equals(pwd2, pwd1)) {
                        System.err.println("第二次密码应于第一次保持一致");
                        break;
                    }
                    System.out.println("请输入你的存款");
                    double mon = scanner.nextDouble();
                    if (mon < 100) {
                        System.err.println("存款不能小于100");
                    }
                    int i = random.nextInt(899999) + 100000;
                    User user = new User(i, name, pwd1, mon);
                    int i1 = service.creatUser(user);
                    System.out.println("用户注册成功，为您分配的银行卡号为" + i + "号");
            }
        }

    }


}
