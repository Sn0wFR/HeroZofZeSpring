package fr.herozofzespring.port;

import fr.herozofzespring.domain.model.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroService {

    List<Hero> findAll();
    Hero save(String name, Integer hp, Integer xp, Integer power, Integer armor, Integer level);

}