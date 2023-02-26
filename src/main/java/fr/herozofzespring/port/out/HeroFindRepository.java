package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.Entity.HeroEntity;

import java.util.List;

public interface HeroFindRepository {
    List<HeroEntity> findAll();

    HeroEntity findById(Integer heroId);
}
