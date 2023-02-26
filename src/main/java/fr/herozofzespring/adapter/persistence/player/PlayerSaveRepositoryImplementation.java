package fr.herozofzespring.adapter.persistence.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.port.out.player.PlayerSaveRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerSaveRepositoryImplementation implements PlayerSaveRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public PlayerEntity save(PlayerEntity player) {
        entityManager.persist(player);
        return player;
    }
}
