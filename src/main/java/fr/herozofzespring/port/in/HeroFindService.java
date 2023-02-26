package fr.herozofzespring.port.in;

import fr.herozofzespring.adapter.Entity.HeroEntity;

import java.util.List;

public interface HeroFindService {

    List<HeroEntity> findAll();

    HeroEntity findById(Integer heroId);

}