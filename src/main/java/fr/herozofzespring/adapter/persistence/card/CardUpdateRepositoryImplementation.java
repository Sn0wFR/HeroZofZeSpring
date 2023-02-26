package fr.herozofzespring.adapter.persistence.card;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.port.out.card.CardUpdateRepository;
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

        String sql = "UPDATE cardentity SET ";
        String data = "";

        if (cardEntity.getHero().getHeroId() != null) {
            data += "hero_id = '" + cardEntity.getHero().getHeroId() + "' ";
        }

        if (cardEntity.getPlayer().getPlayerId() != null) {
            if (!data.equals("")) {
                data += ", ";
            }
            data += "player_id = '" + cardEntity.getPlayer().getPlayerId() + "' ";
        }

        sql += data + "WHERE id = " + cardEntity.getId();

        System.out.println(sql);

        return entityManager.createNativeQuery(sql).executeUpdate();

    }
}
