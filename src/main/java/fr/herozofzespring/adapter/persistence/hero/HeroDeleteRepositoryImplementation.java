package fr.herozofzespring.adapter.persistence.hero;

import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.port.out.hero.HeroDeleteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class HeroDeleteRepositoryImplementation implements HeroDeleteRepository {

        @PersistenceContext
        EntityManager entityManager;
        @Override
        @Transactional
        public HeroEntity deleteById(Integer heroId) {
            HeroEntity heroEntity = entityManager.find(HeroEntity.class, heroId);
            if (heroEntity == null) {
                return null;
            }
            entityManager.remove(heroEntity);
            return heroEntity;
        }
}
