package fr.herozofzespring.adapter.persistence;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.port.out.CardFindRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardFindRepositoryImplementation implements CardFindRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<CardEntity> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM card_entity", CardEntity.class).getResultList();
    }

    @Override
    @Transactional
    public CardEntity findById(Integer cardId) {
        return entityManager.find(CardEntity.class, cardId);
    }
}
