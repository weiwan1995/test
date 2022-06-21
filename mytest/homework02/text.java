package homework02;

import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到银行系统");
        while(true){
            System.out.println("选择功能");
            System.out.println("1,创建用户");
            System.out.println("2,创建用户");
            System.out.println("3,创建用户");
            System.out.println("4,创建用户");
            System.out.println("5,创建用户");
            System.out.println("6,创建用户");
            System.out.println("7,创建用户");
            System.out.println("8,创建用户");
            String choose = scanner.next();
            switch (choose){
                case"1":
                    System.out.println("请输入用户名");
                    String name = scanner.next();
                    System.out.println("请输入密码");
                    String pwd1 = scanner.next();
                    System.out.println("请校准密码");
                    String pwd2 = scanner.next();
            }
        }
    }
}
