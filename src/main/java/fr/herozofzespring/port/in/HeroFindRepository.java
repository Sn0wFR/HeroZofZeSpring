package fr.herozofzespring.port.in;

import fr.herozofzespring.adapter.Entity.HeroEntity;

import java.util.List;

public interface HeroFindRepository {
    List<HeroEntity> findAll();

}
