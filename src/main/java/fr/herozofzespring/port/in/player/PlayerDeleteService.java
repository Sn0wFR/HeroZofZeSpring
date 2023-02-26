package fr.herozofzespring.port.in.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;

public interface PlayerDeleteService {
    PlayerEntity deleteById(Integer id);
}
