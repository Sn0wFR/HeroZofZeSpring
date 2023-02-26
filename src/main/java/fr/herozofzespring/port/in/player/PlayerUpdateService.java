package fr.herozofzespring.port.in.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;

public interface PlayerUpdateService {
    void updateById(Integer id, String name, Integer jeton);
}
