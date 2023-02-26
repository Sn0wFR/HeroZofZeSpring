package fr.herozofzespring.domain.service.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.port.in.player.PlayerSaveService;
import fr.herozofzespring.port.out.player.PlayerFindRepository;
import fr.herozofzespring.port.out.player.PlayerSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerSaveServiceImplementation implements PlayerSaveService {

    @Autowired
    PlayerSaveRepository playerSaveRepository;

    @Autowired
    PlayerFindRepository playerFindRepository;

    @Override
    public PlayerEntity save(String name) {

        for (PlayerEntity p : playerFindRepository.findAll())
            if (p.getName().equals(name))
                throw new IllegalArgumentException("Player already exist");

        PlayerEntity player = new PlayerEntity(name);

        return playerSaveRepository.save(player);
    }
}
