package fr.herozofzespring.port.in.hero;

import fr.herozofzespring.adapter.entity.HeroEntity;

public interface HeroUpdateService {

        void updateById(Integer id, String name, String speciality, String rarity);
}
