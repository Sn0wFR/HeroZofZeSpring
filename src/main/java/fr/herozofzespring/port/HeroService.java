package fr.herozofzespring.port;

import fr.herozofzespring.domain.model.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroService {

    List<Hero> getHeros();

    Optional<Hero> getHeroById(Integer heroId);

    Hero addHero(Hero product);

    void removeHero(Integer heroId);
}
