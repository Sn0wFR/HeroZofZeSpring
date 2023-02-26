package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.Entity.PlayerEntity;

public interface PlayerSaveRepository {
   PlayerEntity create(PlayerEntity player);
}
