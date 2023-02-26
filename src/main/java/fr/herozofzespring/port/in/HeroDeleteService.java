package fr.herozofzespring.port.in;

import fr.herozofzespring.adapter.entity.HeroEntity;

public interface HeroDeleteService {

    HeroEntity deleteById(Integer heroId);

}
