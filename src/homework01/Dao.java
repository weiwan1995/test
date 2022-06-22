package homework01;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    Utils utils = new Utils();

    public int addHero(HeroCard hero) {
        String sql = "Insert into 英雄表 values(?,?,?,?,?,?,?)";
        Object[] params = {hero.getName(), hero.getPosition(), hero.getMp(), hero.getHp(), hero.getPrice(), hero.getMantra(), hero.getGoodPal()};
        return utils.getUpdate(sql, params);
    }

    public int removeHero(String name) {
        String sql = "delete from 英雄表 where 英雄名 = ? ";
        Object[] params = {name};
        return utils.getUpdate(sql, params);
    }



    public int updateHero(HeroCard hero, String preName) {
        String sql = "update  英雄表 set 英雄名=?,类型=?,MP=?,HP=?,价格=?,口头禅=?,好基友=? where 英雄名=?";
        Object[] params = {hero.getName(), hero.getPosition(), hero.getMp(), hero.getHp(), hero.getPrice(), hero.getMantra(), hero.getGoodPal(), preName};
        return utils.getUpdate(sql, params);

    }

    public ArrayList<HeroCard> findOneHeroByName(String name) {
        String sql = "SELECT * FROM 英雄表 WHERE 英雄名 = ? ";
        Object[] params = {name};
        return utils.getQuery(sql, params);
    }

    public ArrayList<HeroCard> findHero(String nameOrType) {
        String sql = "SELECT * FROM 英雄表 WHERE 英雄名 like '%?%' or 类型 =? ";
        Object[] params = {nameOrType};
        return utils.getQuery(sql, params);
    }

    public ArrayList<HeroCard> findAllHero() {
        String sql = "SELECT * FROM 英雄表 ";
        Object[] params = {};
        return utils.getQuery(sql, params);
    }
}
