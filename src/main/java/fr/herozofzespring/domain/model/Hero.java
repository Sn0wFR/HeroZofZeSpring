package fr.herozofzespring.domain.model;

import fr.herozofzespring.domain.enumerator.Rarity;
import fr.herozofzespring.domain.enumerator.Speciality;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
public class Hero {
    private final String name;

    private final Speciality speciality;

    private final Rarity rarity;

    public Hero(String name, Speciality speciality, Rarity rarity) {
        this.name = name;
        this.speciality = speciality;
        this.rarity = rarity;
    }

}