package fr.herozofzespring.adapter.persistence;

import fr.herozofzespring.domain.model.Hero;
import fr.herozofzespring.port.HeroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class HeroRepositoryImplementation implements HeroRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Hero save(Hero hero) {
        System.out.println("repository !");
        System.out.println(hero.getName());
        entityManager.persist(hero);
        return hero;
    }
}