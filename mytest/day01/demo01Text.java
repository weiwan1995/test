package day01;

import java.util.List;

public class demo01Text {
    public static void main(String[] args) {
        demoUtils demoUtils = new demoUtils();
        List<User> resultSet = demoUtils.getResultSet("select * from student");
        resultSet.forEach(System.out::println);
    }
}
