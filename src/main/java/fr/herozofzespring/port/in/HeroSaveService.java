package fr.herozofzespring.port.in;

import fr.herozofzespring.adapter.Entity.HeroEntity;

public interface HeroSaveService {

    HeroEntity save(String name, String speciality, String rarity);

}