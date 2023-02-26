package fr.herozofzespring.port.out.hero;

import fr.herozofzespring.adapter.entity.HeroEntity;

public interface HeroDeleteRepository {

    HeroEntity deleteById(Integer heroId);
}
