package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.HeroEntity;

public interface HeroDeleteRepository {

    HeroEntity deleteById(Integer heroId);
}
