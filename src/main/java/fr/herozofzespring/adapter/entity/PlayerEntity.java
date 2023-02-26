package fr.herozofzespring.adapter.entity;

import fr.herozofzespring.domain.model.Player;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;
    private  Integer jeton;
    private String name;

    public PlayerEntity(String name) {
        this.jeton = 0;
        this.name = name;
    }

    public PlayerEntity(){
    }

    public PlayerEntity(Integer id, String name, Integer jeton) {
        this.playerId = id;
        this.jeton = jeton;
        this.name = name;
    }
}
