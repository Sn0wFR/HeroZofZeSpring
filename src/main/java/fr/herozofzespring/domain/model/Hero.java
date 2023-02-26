package fr.herozofzespring.domain.model;

import fr.herozofzespring.domain.enumerator.Rarity;
import fr.herozofzespring.domain.enumerator.Speciality;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
public class Hero {
    private Integer heroId;
    private String name;

    private Speciality speciality;

    private Rarity rarity;

    public Hero(Integer heroId, String name, Speciality speciality, Rarity rarity) {
        this.heroId = heroId;
        this.name = name;
        this.speciality = speciality;
        this.rarity = rarity;
    }

    public Hero(String name, Speciality speciality, Rarity rarity) {
        this.name = name;
        this.speciality = speciality;
        this.rarity = rarity;
    }

    public Hero() {

    }
}