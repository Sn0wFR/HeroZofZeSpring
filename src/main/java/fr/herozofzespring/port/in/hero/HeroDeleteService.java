package fr.herozofzespring.port.in.hero;

import fr.herozofzespring.adapter.entity.HeroEntity;

public interface HeroDeleteService {

    HeroEntity deleteById(Integer heroId);

}
