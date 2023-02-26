package fr.herozofzespring.adapter.persistence.card;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.port.out.card.CardDeleteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CardDeleteRepositoryImplementation implements CardDeleteRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public CardEntity deleteById(Integer id) {
        CardEntity cardEntity = entityManager.find(CardEntity.class, id);
        if (cardEntity == null) {
            return null;
        }
        entityManager.remove(cardEntity);
        return cardEntity;
    }
}
