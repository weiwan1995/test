package homework02.pojo;

/**
 * @author easonsy
 * @Description
 * @createTime 2022/06/21 17:25:00
 */
public class User {

    private String userName;
    private String password;
    private Double money;
    private Integer cardNumber;
    public User() {
    }

    public User(String userName, String password, Double money, Integer cardNumber) {
        this.userName = userName;
        this.password = password;
        this.money = money;
        this.cardNumber = cardNumber;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
