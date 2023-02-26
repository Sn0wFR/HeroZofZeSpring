package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.HeroEntity;
import fr.herozofzespring.domain.model.Hero;

import java.util.List;

public interface HeroFindRepository {
    List<HeroEntity> findAll();

    HeroEntity findById(Integer heroId);
}
