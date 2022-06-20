package homework01;

import java.math.BigDecimal;
import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------王者荣耀英雄信息管理器----------");
            System.out.println("请选择功能");
            System.out.println("1,查看所有英雄列表");
            System.out.println("2,新增英雄");
            System.out.println("3,请输入英雄名或类型查看英雄列表");
            System.out.println("4,删除英雄");
            System.out.println("5,修改英雄");
            System.out.println("6,退出");
            System.out.println();
            String choose = scanner.next();
            switch (choose) {
                case "1":
                    service.showAll();
                    break;
                case "2":
                    System.out.println("请输入英雄名");
                    String name = scanner.next();
                    System.out.println("请输入类型");
                    String type = scanner.next();
                    System.out.println("请输入MP");
                    Integer mp = scanner.nextInt();
                    System.out.println("请输入HP");
                    Integer hp = scanner.nextInt();
                    System.out.println("请输入价格");
                    String price = scanner.next();
                    System.out.println("请输入口头禅");
                    String mantra = scanner.next();
                    System.out.println("请输入好基友");
                    String goodPal = scanner.next();
                    service.addUser(new HeroCard(name, type, mp, hp, new BigDecimal(price), mantra, goodPal));
                    System.out.println("增加成功");
                    break;
                case "3":
                    System.out.println("请输入英雄名或类型");
                    String nameOrType = scanner.next();
                    service.showAny(nameOrType);
                    break;
                case "4":
                    System.out.println("请输入需要删除的英雄名");
                    String delName = scanner.next();
                    if (service.findOneUser(delName) != null) {
                        service.deleteUser(delName);
                        System.out.println("删除成功");
                    } else {
                        System.out.println("未找到此英雄");
                    }
                    break;
                case "5":
                    System.out.println("请输入需要修改的英雄名");
                    String updateName = scanner.next();
                    if (service.findOneUser(updateName) != null) {
                        System.out.println("请输入新的英雄名");
                        String newName = scanner.next();
                        System.out.println("请输入新的类型");
                        String newType = scanner.next();
                        System.out.println("请输入新的MP");
                        Integer newMp = scanner.nextInt();
                        System.out.println("请输入新的HP");
                        Integer newHp = scanner.nextInt();
                        System.out.println("请输入新的价格");
                        String newPrice = scanner.next();
                        System.out.println("请输入新的口头禅");
                        String newMantra = scanner.next();
                        System.out.println("请输入新的好基友");
                        String newGoodPal = scanner.next();
                        service.updateUser(new HeroCard(newName, newType, newMp, newHp, new BigDecimal(newPrice), newMantra, newGoodPal), updateName);
                        System.out.println("修改成功");
                    } else {
                        System.out.println("未找到此英雄");
                    }
                case "6":
                    System.exit(0);
                    break;

            }
        }
    }
}