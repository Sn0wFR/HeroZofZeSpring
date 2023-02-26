package fr.herozofzespring.adapter.persistence.in;

import fr.herozofzespring.adapter.HeroEntity;
import fr.herozofzespring.domain.model.Hero;
import fr.herozofzespring.port.in.HeroFindRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroFindRepositoryImplementation implements HeroFindRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<HeroEntity> findAll(){
        return entityManager.createNativeQuery("SELECT * FROM hero_entity", HeroEntity.class).getResultList();
    }

}
