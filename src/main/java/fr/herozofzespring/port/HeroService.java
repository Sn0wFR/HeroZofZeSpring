package fr.herozofzespring.port;

import fr.herozofzespring.domain.model.Hero;

import java.util.List;

public interface HeroService {

    List<Hero> getHeros();

    Hero getHeroById(Integer heroId);

    Hero addHero(Hero product);

    Hero removeHero(Integer heroId);
}
