package fr.herozofzespring.adapter.persistence;

import fr.herozofzespring.domain.model.Hero;
import fr.herozofzespring.port.HeroRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

@Repository
public class HeroRepositoryImplementation implements HeroRepository {

    private static final Map<Integer, Hero> heroMap = new HashMap<Integer, Hero>(0);
    EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");//
    @PersistenceContext
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

    @Override
    public <S extends Hero> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Hero> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Hero> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Hero> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hero> cq = cb.createQuery(Hero.class);
        Root<Hero> root = cq.from(Hero.class);
        cq.select(root);
        TypedQuery<Hero> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Iterable<Hero> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {
    }

    @Override
    public void delete(Hero entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Hero> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
