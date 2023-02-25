package fr.herozofzespring.port;

import fr.herozofzespring.domain.model.Hero;

import java.util.List;

public interface HeroRepository {

    List<Hero> getHeros();

    Hero getHeroById(Integer heroId);

    Hero addHero(Hero hero);

    Hero removeHero(Integer heroId);
}
