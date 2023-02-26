package fr.herozofzespring.domain.service.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.port.in.player.PlayerFindService;
import fr.herozofzespring.port.out.player.PlayerFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerFindServiceImplementation implements PlayerFindService {

    @Autowired
    PlayerFindRepository playerFindRepository;

    @Override
    public List<PlayerEntity> findAll() {
        return playerFindRepository.findAll();
    }

    @Override
    public PlayerEntity findById(Integer id) {
        return playerFindRepository.findById(id);
    }
}
