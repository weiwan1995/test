package homework01;

import java.math.BigDecimal;

public class HeroCard {

    private String name;
    private String position;
    private Integer Mp;
    private Integer Hp;
    private BigDecimal price;
    private String mantra;
    private String goodPal;


    public HeroCard(String name, String position, Integer mp, Integer hp, BigDecimal price, String mantra, String goodPal) {

        this.name = name;
        this.position = position;
        Mp = mp;
        Hp = hp;
        this.price = price;
        this.mantra = mantra;
        this.goodPal = goodPal;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getMp() {
        return Mp;
    }

    public void setMp(Integer mp) {
        Mp = mp;
    }

    public Integer getHp() {
        return Hp;
    }

    public void setHp(Integer hp) {
        Hp = hp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMantra() {
        return mantra;
    }

    public void setMantra(String mantra) {
        this.mantra = mantra;
    }

    public String getGoodPal() {
        return goodPal;
    }

    public void setGoodPal(String goodPal) {
        this.goodPal = goodPal;
    }

    @Override
    public String toString() {
        return "HeroCard{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", Mp=" + Mp +
                ", Hp=" + Hp +
                ", price=" + price +
                ", mantra='" + mantra + '\'' +
                ", goodPal='" + goodPal + '\'' +
                '}';
    }
}
