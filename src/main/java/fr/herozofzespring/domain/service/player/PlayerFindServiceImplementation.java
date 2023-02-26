package fr.herozofzespring.domain.service.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.port.in.card.CardFindService;
import fr.herozofzespring.port.in.player.PlayerFindService;
import fr.herozofzespring.port.out.player.PlayerFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerFindServiceImplementation implements PlayerFindService {

    @Autowired
    PlayerFindRepository playerFindRepository;

    @Autowired
    CardFindService cardFindService;
    @Override
    public List<PlayerEntity> findAll() {

        List<PlayerEntity> players = playerFindRepository.findAll();

        for (PlayerEntity p : players){
            cardFindService.findAll().forEach(c -> {
                if (c.getPlayer().getPlayerId() == p.getPlayerId()){
                    System.out.println("Card " + c.getId() + " is owned by player " + p.getPlayerId());
                }
            });
        }
        return players;
    }

    @Override
    public PlayerEntity findById(Integer id) {
        return playerFindRepository.findById(id);
    }
}
