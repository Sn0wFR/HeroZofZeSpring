package fr.herozofzespring.domain.service.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.port.in.player.PlayerDeleteService;
import fr.herozofzespring.port.out.player.PlayerDeleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerDeleteServiceImplementation implements PlayerDeleteService {

    @Autowired
    private PlayerDeleteRepository playerDeleteRepository;

    @Override
    public PlayerEntity deleteById(Integer id) {
        PlayerEntity playerEntity = playerDeleteRepository.deleteById(id);

        if (playerEntity == null) {
            throw new IllegalArgumentException("Player not found");
        }

        return playerEntity;
    }
}
