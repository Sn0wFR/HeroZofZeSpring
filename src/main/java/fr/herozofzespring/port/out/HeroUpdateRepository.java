package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.entity.HeroEntity;

public interface HeroUpdateRepository {

        int updateById(HeroEntity hero);
}
