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
@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer heroId;
    private String name;
    private Integer hp;
    private Integer xp;
    private Integer power;
    private Integer armor;
    private Integer level;

    public Hero(Integer heroId, String name, Integer hp, Integer xp, Integer power, Integer armor, Integer level) {
        this.heroId = heroId;
        this.hp = hp;
        this.xp = xp;
        this.power = power;
        this.armor = armor;
        this.level = level;
    }

    public Hero(String name, Integer hp, Integer xp, Integer power, Integer armor, Integer level) {
        this.name = name;
        this.hp = hp;
        this.xp = xp;
        this.power = power;
        this.armor = armor;
        this.level = level;
    }

    public Hero() {

    }
}