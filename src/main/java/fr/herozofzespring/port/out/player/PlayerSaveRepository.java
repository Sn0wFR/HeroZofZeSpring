package fr.herozofzespring.port.out.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;

public interface PlayerSaveRepository {
   PlayerEntity save(PlayerEntity player);
}
