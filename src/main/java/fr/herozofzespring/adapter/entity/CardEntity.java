package fr.herozofzespring.adapter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "hero_id")
    private HeroEntity hero;
    private Integer armor;
    private Integer xp;
    private Integer hp;
    private Integer power;
    private Integer level;

    public CardEntity(HeroEntity hero, Integer armor, Integer xp, Integer hp, Integer power, Integer level) {
        this.hero = hero;

        for (int i = 0; i < level; i++) {
            armor = (int) (armor + (armor * 0.1));
            hp = (int) (hp + (hp * 0.1));
            power = (int) (power + (power * 0.1));
        }

        this.armor = armor;
        this.xp = xp;
        this.hp = hp;
        this.power = power;
        this.level = level;
    }

    public CardEntity(Integer id, HeroEntity hero, Integer armor, Integer xp, Integer hp, Integer power, Integer level) {

        this.id = id;

        this.hero = hero;

        for (int i = 0; i < level; i++) {
            armor = (int) (armor + (armor * 0.1));
            hp = (int) (hp + (hp * 0.1));
            power = (int) (power + (power * 0.1));
        }

        this.armor = armor;
        this.xp = xp;
        this.hp = hp;
        this.power = power;
        this.level = level;
    }

    public CardEntity() {

    }
}
