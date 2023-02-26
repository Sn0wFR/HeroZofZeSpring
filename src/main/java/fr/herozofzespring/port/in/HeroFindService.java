package fr.herozofzespring.port.in;

import fr.herozofzespring.adapter.entity.HeroEntity;

import java.util.List;

public interface HeroFindService {

    List<HeroEntity> findAll();

    HeroEntity findById(Integer heroId);

}