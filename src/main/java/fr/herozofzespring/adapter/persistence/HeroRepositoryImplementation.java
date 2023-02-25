package fr.herozofzespring.adapter.persistence;

import fr.herozofzespring.domain.model.Hero;
import fr.herozofzespring.port.HeroRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HeroRepositoryImplementation implements HeroRepository {

    private static final Map<Integer, Hero> heroMap = new HashMap<Integer, Hero>(0);

    @Override
    public List<Hero> getHeros() {
        return new ArrayList<>(heroMap.values());
    }

    @Override
    public Hero getHeroById(Integer heroId) {
        return heroMap.get(heroId);
    }

    @Override
    public Hero addHero(Hero hero) {
        System.out.println(this.getClass().getName());
        heroMap.put(hero.getHeroId(), hero);
        return hero;
    }

    @Override
    public Hero removeHero(Integer heroId) {
        if(heroMap.get(heroId)!= null){
            Hero hero = heroMap.get(heroId);
            heroMap.remove(heroId);
            return hero;
        } else
            return null;

    }
}
