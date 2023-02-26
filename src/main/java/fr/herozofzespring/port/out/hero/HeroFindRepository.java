package fr.herozofzespring.port.out.hero;

import fr.herozofzespring.adapter.entity.HeroEntity;

import java.util.List;

public interface HeroFindRepository {
    List<HeroEntity> findAll();

    HeroEntity findById(Integer heroId);
}
