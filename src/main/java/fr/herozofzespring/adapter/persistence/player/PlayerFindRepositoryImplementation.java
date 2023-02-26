package fr.herozofzespring.adapter.persistence.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.port.out.player.PlayerFindRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerFindRepositoryImplementation implements PlayerFindRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<PlayerEntity> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM player_entity", PlayerEntity.class).getResultList();
    }

    @Override
    @Transactional
    public PlayerEntity findById(Integer id) {
        return entityManager.find(PlayerEntity.class, id);
    }
}
