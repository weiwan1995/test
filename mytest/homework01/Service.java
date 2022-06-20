package homework01;


import java.util.ArrayList;

public class Service {
    Dao dao = new Dao();

    public void showAll() {
        ArrayList<HeroCard> list = dao.findAllHero();
        for (HeroCard heroCard : list) {
            System.out.println(heroCard);
        }
    }

    public int addUser(HeroCard heroCard) {
        return dao.addHero(heroCard);
    }

    public void showAny(String name) {
        dao.findHero(name).forEach(System.out::println);
    }

    public int deleteUser(String name) {
        return dao.removeHero(name);
    }

    public int updateUser(HeroCard hero,String preName) {
        return dao.updateHero(hero,preName);
    }

    public ArrayList<HeroCard> findOneUser(String name) {
        return dao.findOneHeroByName(name);
    }


}
