package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.HeroEntity;
import fr.herozofzespring.domain.model.Hero;

import java.util.List;

public interface HeroSaveService {

    HeroEntity save(String name, String speciality, String rarity);

}