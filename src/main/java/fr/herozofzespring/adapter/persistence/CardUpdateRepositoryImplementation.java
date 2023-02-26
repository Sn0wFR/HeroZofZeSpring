package fr.herozofzespring.adapter.persistence;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.port.out.CardUpdateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CardUpdateRepositoryImplementation implements CardUpdateRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public int updateById(CardEntity cardEntity) {

        System.out.println(cardEntity.getHero().getHeroId());
        System.out.println(cardEntity.getId());

        return entityManager.createNativeQuery("UPDATE card_entity SET hero_id = ? WHERE id = ?")
                .setParameter(1, cardEntity.getHero().getHeroId())
                .setParameter(2, cardEntity.getId())
                .executeUpdate();
    }
}
