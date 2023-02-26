package fr.herozofzespring.port.out.hero;

import fr.herozofzespring.adapter.entity.HeroEntity;

public interface HeroUpdateRepository {

        int updateById(HeroEntity hero);
}
