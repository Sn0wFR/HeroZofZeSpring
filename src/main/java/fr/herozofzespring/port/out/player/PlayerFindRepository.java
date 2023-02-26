package fr.herozofzespring.port.out.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;

import java.util.List;

public interface PlayerFindRepository {
    List<PlayerEntity> findAll();

    PlayerEntity findById(Integer id);
}
