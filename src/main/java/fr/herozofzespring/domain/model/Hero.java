package fr.herozofzespring.domain.model;

import fr.herozofzespring.domain.enumerator.Rarity;
import fr.herozofzespring.domain.enumerator.Speciality;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    /*private String name;
    private Integer hp;
    private Integer xp;
    private Integer power;
    private Integer armor;
    private Integer level;*/
}