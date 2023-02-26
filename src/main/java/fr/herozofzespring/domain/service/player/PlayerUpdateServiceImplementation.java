package fr.herozofzespring.domain.service.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.port.in.player.PlayerUpdateService;
import fr.herozofzespring.port.out.player.PlayerUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerUpdateServiceImplementation implements PlayerUpdateService {

    @Autowired
    private PlayerUpdateRepository playerUpdateRepository;

    @Override
    public void updateById(Integer id, String name, Integer jeton) {

        PlayerEntity player = new PlayerEntity(id, name, jeton);

        if (playerUpdateRepository.update(player) == 0) {
            throw new IllegalArgumentException("Player not found");
        }

    }
}
