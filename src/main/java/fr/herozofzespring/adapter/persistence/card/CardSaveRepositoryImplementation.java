package fr.herozofzespring.adapter.persistence.card;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.port.out.card.CardSaveRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CardSaveRepositoryImplementation implements CardSaveRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public CardEntity save(CardEntity cardEntity) {
        entityManager.persist(cardEntity);
        return cardEntity;
    }
}
