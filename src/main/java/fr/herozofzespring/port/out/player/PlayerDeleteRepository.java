package fr.herozofzespring.port.out.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;

public interface PlayerDeleteRepository {
    PlayerEntity deleteById(Integer id);
}
