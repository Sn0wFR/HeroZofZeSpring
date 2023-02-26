package fr.herozofzespring.port.in;

import fr.herozofzespring.adapter.HeroEntity;

public interface HeroDeleteService {

    HeroEntity deleteById(Integer heroId);

}
