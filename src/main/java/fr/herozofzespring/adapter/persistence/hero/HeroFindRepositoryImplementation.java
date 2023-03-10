package fr.herozofzespring.adapter.persistence.hero;

import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.port.out.hero.HeroFindRepository;
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

    @Override
    @Transactional
    public HeroEntity findById(Integer heroId){
        return entityManager.find(HeroEntity.class, heroId);
    }


}
