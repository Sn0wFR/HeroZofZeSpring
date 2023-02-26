package fr.herozofzespring.adapter;

import fr.herozofzespring.domain.enumerator.Rarity;
import fr.herozofzespring.domain.enumerator.Speciality;
import fr.herozofzespring.domain.model.Hero;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class HeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer heroId;
    private String name;
    private String speciality;
    private String rarity;

    public HeroEntity(Hero hero) {
        this.name = hero.getName();
        this.speciality = hero.getSpeciality().name();
        this.rarity = hero.getRarity().name();
    }

    public HeroEntity() {

    }
}
