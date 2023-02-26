package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.HeroEntity;

public interface HeroUpdateRepository {

        int updateById(HeroEntity hero);
}
