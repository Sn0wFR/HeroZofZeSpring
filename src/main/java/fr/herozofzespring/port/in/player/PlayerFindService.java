package fr.herozofzespring.port.in.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;

import java.util.List;

public interface PlayerFindService {
    List<PlayerEntity> findAll();

    PlayerEntity findById(Integer id);
}
