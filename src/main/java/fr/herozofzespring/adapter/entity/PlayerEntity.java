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
    private  int jeton;
    private String name;

        public PlayerEntity(Player player) {
            this.jeton = player.getJeton();
            this.name = player.getName();
        }

        public PlayerEntity(){

        }

}
