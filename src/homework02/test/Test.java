package homework02.test;


import homework02.pojo.User;
import homework02.service.BankService;


import java.util.Random;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) throws Exception {
        BankService bankService = new BankService();
        User login = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------------------欢迎来到IT银行系统-----------------------");
            System.out.println("1.创建用户 2.登录 3.注销 4.查询余额 5.修改密码 6.存钱 7.取钱 8.转账");
            System.out.println("请输入选择");
            String choose = scanner.next();
            switch (choose) {
                case "1":
                    System.out.println("请输入你的用户名:(以字母开头)");
                    String name = scanner.next();
                    if (!name.matches("[a-zA-Z]+")) {
                        break;
                    }
                    System.out.println("请输入你的密码:(6-12位)");
                    String password = scanner.next();
                    if (!password.matches("\\w{6,12}")) {
                        break;
                    }
                    System.out.println("请输入你的密码:(6-12位)");
                    String password1 = scanner.next();
                    if (!password.equals(password1)) {
                        break;
                    }
                    System.out.println("请输入你的存款");
                    double mon = scanner.nextDouble();
                    if (mon < 100) {
                        break;
                    }
                    Random random = new Random();
                    int i = random.nextInt(899999) + 100000;
                    System.out.println("恭喜" + name + "用户注册成功，我行为您分配的银行卡号为" + i);
                    User u = new User(name, password, mon, i);
                    bankService.register(u);
                    System.out.println(u);
                    break;
                case "2":
                    int a = 0;
                    while (a < 3) {
                        System.out.println("请输入账号");
                        String next = scanner.next();
                        System.out.println("请输入您的密码");
                        String password2 = scanner.next();
                        login = bankService.login(next, password2);
                        if (login != null) {
                            System.out.println("登录成功");
                            break;
                        } else {
                            System.out.println("登录失败");
                            a++;
                        }
                    }
                    break;
                case "3":
                    if (login != null) {
                        System.out.println("请输入你唯一的id");
                        Integer next = scanner.nextInt();
                        if (next.equals(login.getCardNumber())) {
                            bankService.deleteUser(next);
                        } else {
                            System.out.println("输入有误");
                        }
                    }
                    break;
                case "4":
                    if (login != null) {
                        System.out.println(bankService.show(login.getUserName(), login.getPassword()));
                    }
                    break;
                case "5":
                    if (login != null) {
                        System.out.println("请输入新密码");
                        String next = scanner.next();
                        bankService.setPw(login.getUserName(), next);
                        if (!next.matches("\\w{6,12}")) {
                            System.out.println("新密码不符合要求");
                            break;
                        }
                        System.out.println("修改成功");
                    }
            }

        }
    }


}
