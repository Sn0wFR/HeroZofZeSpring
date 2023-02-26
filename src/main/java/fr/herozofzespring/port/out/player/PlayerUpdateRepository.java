package fr.herozofzespring.port.out.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;

public interface PlayerUpdateRepository {
    int update(PlayerEntity playerEntity);
}
