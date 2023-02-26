package fr.herozofzespring.port.in.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.domain.model.Player;

public interface PlayerSaveService {
    PlayerEntity save(String name);
}
