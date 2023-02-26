package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.entity.PlayerEntity;

public interface PlayerSaveRepository {
   PlayerEntity create(PlayerEntity player);
}
