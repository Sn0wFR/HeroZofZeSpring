package fr.herozofzespring.port.in.hero;

import fr.herozofzespring.adapter.entity.HeroEntity;

public interface HeroSaveService {

    HeroEntity save(String name, String speciality, String rarity);

}