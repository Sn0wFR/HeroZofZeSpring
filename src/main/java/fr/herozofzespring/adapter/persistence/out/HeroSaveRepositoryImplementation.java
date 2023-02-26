package fr.herozofzespring.adapter.persistence.out;

import fr.herozofzespring.adapter.Entity.HeroEntity;
import fr.herozofzespring.port.out.HeroSaveRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class HeroSaveRepositoryImplementation implements HeroSaveRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public HeroEntity save(HeroEntity heroEntity) {

        entityManager.persist(heroEntity);
        return heroEntity;
    }
}