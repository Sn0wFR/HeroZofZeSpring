package fr.herozofzespring.adapter.persistence.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.port.out.player.PlayerDeleteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDeleteRepositoryImplementation implements PlayerDeleteRepository {

        @PersistenceContext
        EntityManager entityManager;

        @Override
        @Transactional
        public PlayerEntity deleteById(Integer id) {
            PlayerEntity playerEntity = entityManager.find(PlayerEntity.class, id);
            if (playerEntity == null) {
                return null;
            }
            entityManager.remove(playerEntity);
            return playerEntity;
        }
}
