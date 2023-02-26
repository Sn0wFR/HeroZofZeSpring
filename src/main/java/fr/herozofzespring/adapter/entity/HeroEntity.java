package fr.herozofzespring.adapter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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

    public HeroEntity(String name, String speciality, String rarity) {
        this.name = name;
        this.speciality = speciality;
        this.rarity = rarity;
    }

    public HeroEntity(Integer heroId, String name, String speciality, String rarity) {
        this.heroId = heroId;
        this.name = name;
        this.speciality = speciality;
        this.rarity = rarity;
    }

    public HeroEntity() {

    }
}
